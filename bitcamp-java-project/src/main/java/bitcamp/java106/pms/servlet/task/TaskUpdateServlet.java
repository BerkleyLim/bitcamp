// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.servlet.task;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Date;

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
@WebServlet("/task/update")
public class TaskUpdateServlet extends HttpServlet {
    
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
    protected void doPost(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        String teamName = request.getParameter("teamName");
        
        
        try {
            Task task = new Task()
                .setNo(Integer.parseInt(request.getParameter("no")))
                .setTitle(request.getParameter("title"))
                .setStartDate(Date.valueOf(request.getParameter("startDate")))
                .setEndDate(Date.valueOf(request.getParameter("endDate")))
                .setState(Integer.parseInt(request.getParameter("state")))
                .setTeam(new Team().setName(request.getParameter("teamName")))
                .setWorker(new Member().setId(request.getParameter("memberId")));
            
            int count = taskDao.update(task);
            if (count == 0) {
                throw new Exception("<p>해당 작업이 없습니다.</p>");
            } 
            
            // 한글을 웹서버/브라우저로 보낼 때, 무조건 한글을 바로 보내지 않고 UTF-8의 7bit로 된 값으로 보낸다.
            // 이후 나중에 디코딩을 자동으로 한다.
            // list?teamName= : 로케이션 헤더값 
            // 웹서버가 웹 브라우저에게 헤더값을 요구하면 자동으로 한글 처리를 하지 않는다.
            // 참고로 우리는 수정으로 처리!!
            // javaScript에서도 자주 쓰이기도 한다.
            response.sendRedirect("list?teamName=" + 
                        URLEncoder.encode(task.getTeam().getName(), "UTF-8"));
            //response.sendRedirect("../list?teamName=" + task.getTeam().getName());
            
        } catch (Exception e) {
            // 예외가 발생하면 ErrorServlet으로 예외 내용을 출력하도록 실행을 위윔한다.
            // 1) 실행을 위임할 객체를 준비한다.
            RequestDispatcher 요청배달자 = request.getRequestDispatcher("/error");
            
            // 2) 다른 서블릿에게 실행을 위임하기 전에 그 서블릿에 전달할 데이터가 있다면,
            //    ServletRequest 보관소에 담아라.
            request.setAttribute("error", e);
            request.setAttribute("title", "작업 변경 실패!");
            
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
//ver 26 - TaskController에서 update() 메서드를 추출하여 클래스로 정의.
//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - TaskDao 변경 사항에 맞춰 이 클래스를 변경한다.
//ver 18 - ArrayList가 적용된 TaskDao를 사용한다.
//ver 17 - 클래스 생성
