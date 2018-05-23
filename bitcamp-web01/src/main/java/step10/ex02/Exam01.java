// 쿠키 : 유효기간 설정하기
package step10.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/step10/ex02/exam01")
public class Exam01 extends HttpServlet {
    
    @Override
    protected void doGet(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Cookie cookie1 = new Cookie("c1", "aaa");
        cookie1.setMaxAge(20); // 유지 시간(초)을 설정한다.(20초 동안 유효)
        // 유효기간을 설정하면 웹브라우저를 닫아도, 컴퓨터를 종료해도 유지된다.
        // 왜? 파일시스템(HDD 등)에 보관하기 때문에 컴퓨터를 꺼도 유지된다.
        // 당연히 유효기간이 지나면 웹 브라우저는 웹 서버에게 보내지 않고 해당 쿠기를 제거한다.
        
        Cookie cookie2 = new Cookie("c2", "123");
        cookie2.setMaxAge(40); // 40초 동안 유효
        
        Cookie cookie3 = new Cookie("c3", "123");
        // 유효기간을 설정하지 않으면 웹브라우저를 실행하는 동안만 유효하다.
        // 웹브라우저를 닫으면 유효기간이 설정되지 않은 쿠키는 자동으로 삭제된다.
        
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        response.addCookie(cookie3);
        
        response.setContentType("text/plain;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("쿠키를 보냈습니다.");
        
        
    }
}
// 쿠키(cookie)?
// => 웹서버에서 보낸 데이터를 보내 웹브라우저에 저장하는 것
// => 웹브라우저는 웹서버로부터 받은 데이터를 보관하고 있다가
//    웹서버에 요청할 때마다 다시 보낸다.
//    예) 쿠폰

// 쿠키를 클라이언트로 보내는 HTTP 프로토콜?
//HTTP/1.1 200
//Set-Cookie: c1=aaa; Max-Age=30; Expires=Wed, 23-May-2018 01:55:16 GMT
//Set-Cookie: c2=123
//Set-Cookie: c2=123
//Content-Type: text/plain;charset=utf-8
//Content-Length: 28
//Date: Wed, 23 May 2018 01:54:46 GMT





