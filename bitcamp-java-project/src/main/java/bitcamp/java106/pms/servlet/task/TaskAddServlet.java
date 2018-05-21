package bitcamp.java106.pms.servlet.task;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.support.WebApplicationContextUtils;

@SuppressWarnings("serial")
@WebServlet("/task/add")
public class TaskAddServlet extends HttpServlet {
    
    TeamDao teamDao;
    TaskDao taskDao;
    TeamMemberDao teamMemberDao;

    @Override
    public void init() throws ServletException {
        // 스프링 IoC 컨테이너에서 서블릿 객체를 관리하는 것이 아니기 때문에
        // 스프링 IoC 컨테이너에 들어 있는 DAO 객체를 자동으로 주입 받을 수 없다.
        // 서블릿을 생성할 때 스프링 IoC 컨테이너에서 직접 DAO를 꺼내와야 한다.
        ApplicationContext iocContainer =
                WebApplicationContextUtils.getWebApplicationContext(
                        this.getServletContext());
        
        teamDao = iocContainer.getBean(TeamDao.class);
        taskDao = iocContainer.getBean(TaskDao.class);
        teamMemberDao = iocContainer.getBean(TeamMemberDao.class);
    }
    
    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        String teamName = request.getParameter("teamName");
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>작업 등록</title>");
        out.println("</head>");
        out.println("<body>");
        out.printf("<h1>'%s' 팀의 작업 등록</h1>\n", teamName);
        
        try {
            Team team = teamDao.selectOne(teamName);
            if (team == null) {
                throw new Exception(teamName + " 팀은 존재하지 않습니다.");
            }
            List<Member> members = teamMemberDao.selectListWithEmail(teamName);
            
            out.println("<form action='add' method='post'>");
            out.printf("<input type='hidden' name='teamName' value='%s'>\n", teamName);
            out.println("<table border='1'>");
            out.println("<tr>");
            out.println("    <th>작업명</th><td><input type='text' name='title'></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("    <th>시작일</th><td><input type='date' name='startDate'></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("    <th>종료일</th><td><input type='date' name='endDate'></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("    <th>작업자</th>");
            out.println("    <td>");
            out.println("        <select name='memberId'>");
            out.println("            <option value=''>--선택 안함--</option>");
            
            for (Member member : members) {
                out.printf("            <option>%s</option>\n", member.getId());
            }
            
            out.println("        </select>");
            out.println("    </td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("<button>등록</button>");
            out.println("</form>");

        } catch (Exception e) {
            // 예외가 발생하면 ErrorServlet으로 예외 내용을 출력하도록 실행을 위윔한다.
            // 1) 실행을 위임할 객체를 준비한다.
            RequestDispatcher 요청배달자 = request.getRequestDispatcher("/error");
            
            // 2) 다른 서블릿에게 실행을 위임하기 전에 그 서블릿에 전달할 데이터가 있다면,
            //    ServletRequest 보관소에 담아라.
            request.setAttribute("error", e);
            request.setAttribute("title", "게시물 목록조회 실패!");
            
            // 3) 다른 서블릿으로 실행을 위임한다.
            // 다른 서블릿으로 실행을 위임할 때,
            // 이전까지 버퍼로 출력한 데이터를 버린다.
            요청배달자.forward(request, response);
        }
        out.println("</body>");
        out.println("</html>");
    }
    
    @Override
    protected void doPost(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        Task task = new Task();
        task.setTitle(request.getParameter("title"));
        task.setStartDate(Date.valueOf(request.getParameter("startDate")));
        task.setEndDate(Date.valueOf(request.getParameter("endDate")));
        task.setTeam(new Team().setName(request.getParameter("teamName")));
        task.setWorker(new Member().setId(request.getParameter("memberId")));
        
        
        try {
            Team team = teamDao.selectOne(task.getTeam().getName());
            if (team == null) {
                throw new Exception(task.getTeam().getName() + " 팀은 존재하지 않습니다.");
            }
            
            if (task.getWorker().getId().length() > 0 &&
                !teamMemberDao.isExist(
                    task.getTeam().getName(), task.getWorker().getId())) {
                throw new Exception(task.getWorker().getId() + "는 이 팀의 회원이 아닙니다.");
            }
            
            taskDao.insert(task);
            
            
         // 한글을 웹서버/브라우저로 보낼 때, 무조건 한글을 바로 보내지 않고 UTF-8의 7bit로 된 값으로 보낸다.
            // 이후 나중에 디코딩을 자동으로 한다.
            // list?teamName= : 로케이션 헤더값 
            // 웹서버가 웹 브라우저에게 헤더값을 요구하면 자동으로 한글 처리를 하지 않는다.
            // 참고로 우리는 수정으로 처리!!
            // javaScript에서도 자주 쓰이기도 한다.
            response.sendRedirect("list?teamName=" + 
                        URLEncoder.encode(task.getTeam().getName(), "UTF-8"));
            // 다시 강조 : 무조건 sendRedirect는 헤더로만 보냄
            
        } catch (Exception e) {
            // 예외가 발생하면 ErrorServlet으로 예외 내용을 출력하도록 실행을 위윔한다.
            // 1) 실행을 위임할 객체를 준비한다.
            RequestDispatcher 요청배달자 = request.getRequestDispatcher("/error");
            
            // 2) 다른 서블릿에게 실행을 위임하기 전에 그 서블릿에 전달할 데이터가 있다면,
            //    ServletRequest 보관소에 담아라.
            request.setAttribute("error", e);
            request.setAttribute("title", "작업 추가 실패!");
            
            // 3) 다른 서블릿으로 실행을 위임한다.
            // 다른 서블릿으로 실행을 위임할 때,
            // 이전까지 버퍼로 출력한 데이터를 버린다.
            요청배달자.forward(request, response);
        }
    }

}
//ver 37 - 컨트롤러를 서블릿으로 변경
//ver 31 - JDBC API가 적용된 DAO 사용
//ver 28 - 네트워크 버전으로 변경
//ver 26 - TaskController에서 add() 메서드를 추출하여 클래스로 정의.
//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - TaskDao 변경 사항에 맞춰 이 클래스를 변경한다.
//ver 18 - ArrayList가 적용된 TaskDao를 사용한다.
//ver 17 - 클래스 생성
