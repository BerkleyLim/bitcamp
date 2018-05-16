// GET 요청과 POST 요청 구분하기 - HttpServlet 클래스
package step04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// HTTP 요청을 다루기 위해 매번 ServletRequest와 ServletResponse를
// 형변환해야 한다면 프로글매이 하기가 매우 번거롭다.
// 미리 형변환 처리를 한 클래스가 있으니 그 클래스를 사용하자.
@WebServlet("/step04/exam03")
public class Exam03 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // 테스트 방법:
    // http://localhost:8888/bitcamp-web01/step04/exam03_test.html
    
    // => service() 메서드를 오버라이딩 할 때도 Servlet 인터페이스에 선언된
    //    원래의 service(ServletRequest, ServletResponse)를 오버라이딩 하지 말고,
    //    HttpServlet 클래스에서 추가(오버로딩)한 service() 메서드를 오버라이딩 하라!
    // => 이 메서드는 파라미터 값으로 HttpServletRequest와 HttpServletResponse를 받는다.
    //    물론 서블릿 컨테이너가이 메서드를 직접 호출하는 것이 아니라
    //    service(ServletRequest, ServletResponse)를 호출하면,
    //    내부적으로 service(HttpServletRequest,HttpServletResponse)를 호출하는 것이다.
    //    
    @Override
    public void service(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        // 클라이언트가 보낸 값을 꺼낼 때는 GET, POST 구분없이 동일한 방법으로 값을 꺼낸다.
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        
        // 이 메서드를 재정의 하면 다음과 같이 파라미터 값을 원래의 타입으로 형변환 필요 무
        // => 즉 오리지널 service(ServletRequest, ServletResponse)를 재정의하는 것보다
        //    이 메서드를 재정의하는 것이 코딩하는데 편하다!
        //HttpServletRequest httpRequest = (HttpServletRequest) request;
        
        // 원래의 타입인 HttpServletRequest에는 "HTTP method"를 알아내는 메서드가 있다.
        String method = request.getMethod();
        
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
