package bitcamp.java106.pms.servlet.task;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.servlet.InitServlet;

@SuppressWarnings("serial")
@WebServlet("/task/delete")
public class TaskDeleteServlet extends HttpServlet {
    
    TeamDao teamDao;
    TaskDao taskDao;
    
    @Override
    public void init() throws ServletException {
        teamDao = InitServlet.getApplicationContext().getBean(TeamDao.class);
        taskDao = InitServlet.getApplicationContext().getBean(TaskDao.class);
    }
    
    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        String teamName = request.getParameter("teamName");
        
        try {
            int no = Integer.parseInt(request.getParameter("no"));
            int count = taskDao.delete(no);
            if (count == 0) {
                throw new Exception("해당 작업이 존재하지 않습니다.");
            } 
            
            // 한글을 웹서버/브라우저로 보낼 때, 무조건 한글을 바로 보내지 않고 UTF-8의 7bit로 된 값으로 보낸다.
            // 이후 나중에 디코딩을 자동으로 한다.
            // list?teamName= : 로케이션 헤더값 
            // 웹서버가 웹 브라우저에게 헤더값을 요구하면 자동으로 한글 처리를 하지 않는다.
            // 참고로 우리는 수정으로 처리!!
            // javaScript에서도 자주 쓰이기도 한다.
            response.sendRedirect("list?teamName=" + 
                        URLEncoder.encode(teamName, "UTF-8"));
            /* response.sendRedirect("list?teamName=" + teamName);
             * teamName='가가각' 하면?
             *  HTTP/1.1 302
                Location: list?teamName=???
                Content-Length: 0
                Date: Fri, 18 May 2018 03:50:06 GMT
             * */
            // 정리 : 
            //  응답 헤더의 값으로 한글을 포함할 때는 
            //  서블릿 컨테이너가 자동으로 URL 인코딩하지 않는다.
            //  위와 같이 개발자가 직접 URL 인코딩 해야 한다.
            
            
        } catch (Exception e) {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.printf("<meta http-equiv='Refresh' content='1;url=list?teamName=%s'>\n",
                    teamName);
            out.println("<title>작업 삭제</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>작업 삭제 결과</h1>");
            out.println("<p>삭제 실패!<br>");
            out.println("잠시 후 다시 시도해주세요. 계속 오류 발생 시<br>");
            out.println("담당자(내선: 120)에게 연락주세요.</p>");
            out.println("<pre>");
            e.printStackTrace(out);
            out.println("</pre>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}

//ver 37 - 컨트롤러를 서블릿으로 변경
//ver 31 - JDBC API가 적용된 DAO 사용
//ver 28 - 네트워크 버전으로 변경
//ver 26 - TaskController에서 delete() 메서드를 추출하여 클래스로 정의.
//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - TaskDao 변경 사항에 맞춰 이 클래스를 변경한다.
//ver 18 - ArrayList가 적용된 TaskDao를 사용한다.
//ver 17 - 클래스 생성