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
        
        
    }
}
// 쿠키(cookie)?
// => 웹서버에서 보낸 데이터를 보내 웹브라우저에 저장하는 것
// => 웹브라우저는 웹서버로부터 받은 데이터를 보관하고 있다가
//    웹서버에 요청할 때마다 다시 보낸다.
//    예) 쿠폰

// 쿠키를 클라이언트로 보내는 HTTP 프로토콜?
//GET /bitcamp-web01/step10/ex01/exam01 HTTP/1.1
//Host: localhost:8888
//Connection: keep-alive
//Cache-Control: max-age=0
//Upgrade-Insecure-Requests: 1
//User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36
//Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8
//Accept-Encoding: gzip, deflate, br
//Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7