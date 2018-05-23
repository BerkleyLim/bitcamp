// 세션 : 응용 - 세션간의 
package step10.ex04;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/step10/ex04/exam02")
public class Exam02 extends HttpServlet {
    
    @Override
    protected void doPost(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");

        // 파라미터로 받은 데이터를 다른 서블릿에서 사용할 수 있도록 세션에 보관한다.
        HttpSession session = request.getSession();
        session.setAttribute("name", name);
        
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        
        out.println("<html>");
        out.println("<head>");
        out.println("   <meta charset='utf-8'>");
        out.println("</head>");
        out.println("<body>");
        out.println("   <h1>페이지 2</h1>");
        out.println("   <form action='exam03' method='post'>");
        out.println("   나이: <input type='text' name='age'><br>");
        out.println("   <button>다음</button>");
        out.println("   </form>");
        out.println("</body>");
        out.println("</html>");
    }
}





