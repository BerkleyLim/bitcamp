// 쿠키 : 클라이언트 쪽에 데이터를 보관하는 방법
package step10.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/step10/ex01/exam01")
public class Exam01 extends HttpServlet {
    
    @Override
    protected void doGet(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // 쿠키(cookie) 보내기
        // 1) key-value 한 쌍의 값을 갖는 쿠키 객체를 만든다.
        Cookie cookie1 = new Cookie("c1", "aaa");
        Cookie cookie2 = new Cookie("c2", "123");
        
        // 2) 응답 헤더에 쿠키 정보를 출력한다.
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        
        response.setContentType("text/plain;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("쿠키를 보냈습니다.");
        
        // 쿠키(cookie)?
        // => 웹서버에서 데이터를 보내 웹브라우저에 저장하는 것
        // => 웹브라우저는 웹서버로부터 받은 데이터를 보관하고 있다가
        //    웹서버에 요청할 때마다 다시 보낸다.
        //    예) 쿠폰, 
        
    }
}
