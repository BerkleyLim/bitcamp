// 쿠기 : 쿠키를 사용할 범위 지정하기
package step10.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/step10/ex02/exam03")
public class Exam03 extends HttpServlet {
    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        Cookie cookie1 = new Cookie("c1", "aaa");
        cookie1.setPath("/");
        
        // 웹브라우저가 쿠키를 받은 서버를 요청할 때
        // "/"로 시작하는 요청에 대해서는 c1 쿠키를 보낸다.
        
        Cookie cookie2 = new Cookie("c2", "123");
        cookie2.setPath("/bitcamp-web01/step10");
        // 웹브라우저가 쿠키를 받은 서버에 요청할 때
        // "/bitcamp-web01/step10"으로 시작하는 요청일 경우 c2 쿠키를 보낸다.
        
        
        Cookie cookie3 = new Cookie("c3", "123");
        cookie3.setPath("bitcamp-web01/step10/ex02/Exam04");
        // 웹브라우저가 쿠키를 받은 서버에 요청할 때
        // "/bitcamp-web01/step10/ex02/Exam04"으로 시작하는 요청일 경우 c2 쿠키를 보낸다.
        
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        response.addCookie(cookie3);
        
        response.setContentType("text/plain;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("쿠키를 보냈습니다.");
        
        
    }
}








