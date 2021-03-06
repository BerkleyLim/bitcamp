// GET 요청과 POST 요청 구분하기
package step04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

@WebServlet("/step04/exam02")
public class Exam02 extends GenericServlet {
    private static final long serialVersionUID = 1L;

    // 테스트 방법:
    // http://localhost:8888/bitcamp-web01/step04/exam02_test.html
    @Override
    public void service(
            ServletRequest request, 
            ServletResponse response) throws ServletException, IOException {
        // 클라이언트가 보낸 값을 꺼낼 때는 GET, POST 구분없이 동일한 방법으로 값을 꺼낸다.
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        
        // 클라이언트가 요청한 방식을 알아내기
        // => 요청 방식은 HTTP 프로토콜에 대한 내용이다.
        // => ServletRequest에는 HTTP 프로토콜에 대한 내용을 다룰 수 있는 기능이 없다.
        // => 해결책?
        //    서블릿 컨테이너가 service()를 호출할 때 넘겨준 파라미터의
        //    원리 타입으로 변환하라!
        // => 서블릿 컨테이너는 service()를 호출할 때 HTTP 정보를 다룰 수 있는
        //    HttpServletRequest와 HttpServletResponse를 넘겼다.
        // => 따라서 이 타입으로 형변환하면 된다.
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        
        // ServletRequest에는 "HTTP method"를 알아내는 메서드가 없다.
        // String method = request.getMethod();
        
        // 원래의 타입인 HttpServletRequest에는 "HTTP method"를 알아내는 메서드가 있다.
        String method = httpRequest.getMethod();
        
        // UTF-16 ==> UTF-8
        response.setContentType("text/plane; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.printf("요청 방식=%s\n", method);
        out.printf("name=%s\n", name);
        out.printf("age=%d\n", age);
    }
}

// HTTP 프로토콜 - GET 요청
// - request-URI에 데이터를 포함해서 보낸다.
//      URL?파라미터명=값&파라미터명=값&파라미터명=값......
//   예) /bitcamp-web01/step04/exam01?name=aaa&age=20

/*
GET /bitcamp-web01/step04/exam01?name=aaa&age=20 HTTP/1.1  <== request-line
Host: localhost:8888  <== header(general/request/entity)
Connection: keep-alive  <==
Upgrade-Insecure-Requests: 1
User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.170 Safari/537.36
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,* / *;q=0.8
Referer: http://localhost:8888/bitcamp-web01/step04/exam01_test.html
Accept-Encoding: gzip, deflate, br
Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7
(빈줄)   <== empty line. 보내는 데이터의 끝을 알림. 
*/

// HTTP 프로토콜 - POST 요청
// - message-body(entity-body)에 데이터를 포함해서 보낸다.
// - post 요청을 할 때는 보내는 데이터의 정보를 추가한다.
//   즉 Content-Length와 Content-Type을 추가해서 보낸다.
//
/*
POST /bitcamp-web01/step04/exam01 HTTP/1.1 <== request-Line
Host: localhost:8888  <== header(general/request/entity)
Connection: keep-alive
Content-Length: 15      <== post 요청할 때만 보내는 헤더 값, 빈 줄 다음에 읽어야 할 바이트의 수.
Cache-Control: max-age=0
Origin: http://localhost:8888
Upgrade-Insecure-Requests: 1
Content-Type: application/x-www-form-urlencoded    <== post 요청할 때만 보내는 헤더 값
User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.170 Safari/537.36
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,* /*;q=0.8
Referer: http://localhost:8888/bitcamp-web01/step04/exam01_test.html
Accept-Encoding: gzip, deflate, br
Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7
(빈 줄) <== empty line
name=bbb&age=30 <= post 요청은 빈 줄 다음에 데이터를 보내다.
*/
