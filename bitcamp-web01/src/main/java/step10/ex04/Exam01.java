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
@WebServlet("/step10/ex04/exam01")
public class Exam01 extends HttpServlet {
    
    @Override
    protected void doGet(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        
        out.println("<html>");
        out.println("<head>");
        out.println("   <meta charset='utf-8'>");
        out.println("</head>");
        out.println("<body>");
        out.println("   <h1>페이지 1</h1>");
        out.println("   <form action='exam02' method='post'>");
        out.println("   이름: <input type='text' name='name'><br>");
        out.println("   <button>다음</button>");
        out.println("   </form>");
        out.println("</body>");
        out.println("</html>");
        
    }
}





