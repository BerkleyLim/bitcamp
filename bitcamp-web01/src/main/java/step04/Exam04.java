// GET 요청과 POST 요청 구분하기 - HttpServlet 클래스의 doXXX() 사용하기!
package step04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step04/exam04")
public class Exam04 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // 테스트 방법:
    // http://localhost:8888/bitcamp-web01/step04/exam03_test.html
    
    // 서블릿 컨테이너는 service(ServletRequest, ServletResponse)를 호출한다.
    // 다음 절차를 거치면서 메서드가 호출된다.
    // service(ServletRequest, ServletResponse)
    //     => service(HttpServletRequest, HttpServletResponse)
    //          => doGet(HttpServletRequest, HttpServletResponse)
    //          => doPost(HttpServletRequest, HttpServletResponse)
    //          => doHead(HttpServletRequest, HttpServletResponse)
    //             ....
    // 따라서, GET 요청을 처리하고 싶다면 service()를 재정의하는 대신 doGet()을 재정의하면 된다.
    // POST 요청을 처리하고 싶다면 마찬가지로 service() 대신에 doPost()를 재정의하면 된다.
    @Override
    public void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {

        // 클라이언트가 GET 요청을 하면 이 메서드가 최종적으로 호출된다.
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        
        response.setContentType("text/plane; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.printf("doGet() 호출됨!\n");
        out.printf("name=%s\n", name);
        out.printf("age=%d\n", age);
    }
    
    @Override
    public void doPost(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {

        // 클라이언트가 POST 요청을 하면 이 메서드가 최종적으로 호출된다.
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        
        response.setContentType("text/plane; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.printf("doPost() 호출됨!\n");
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
