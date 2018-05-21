package step09.ex01;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//웹 애플리케이션 컴포넌트?
//- 서블릿(servlet): 클라이언트의 요청을 처리하는 역할
//- 필터(filter): 서블릿을 실행하기 전/후에 보조 작업을 수행
//- 리스너(listener): 서블릿 컨테이너에서 특정 사건이 발생할 때 작업을 수행
//
//필터
//- 서블릿을 실행하기 전이나 후에 특정 작업을 수행하고 싶을 때 사용한다.
//- 예: 
//=> 클라이언트의 접속을 기록
//=> 클라이언트가 보낸 데이터의 압축을 해제
//=> 클라이언트가 보낸 데이터의 암호를 해제
//=> 서블릿을 작업을 수행하기 전에 공통으로 처리해야 하는 작업을 수행
//=> 클라이언트의 인증 또는 권한 검사
//=> 클라이언트에게 보낼 데이터를 압축하거나 암호화시키기
//
//필터 만들기
//- javax.servlet.Filter 인터페이스 구현
//
//필터 배치
//1) 애노테이션으로 필터를 배치하기
// @WebFilter(필터를 적용할 URL)
//2) DD File(web.xml)에 필터를 배치하기
// - 필터 등록
// <filter>
//     <filter-name>filter1</filter-name>
//     <filter-class>step09.ex1.Filter1</filter-class>
// </filter>
//- 필터를 적용할 URL 지정
// <filter-mapping>
//     <filter-name>filter1</filter-name>
//     <url-pattern>/step09/ex1/*</url-pattern>
// </filter-mapping>
//
@WebFilter("/step09/ex01/exam03")
public class Filter3 implements Filter {
    FilterConfig config;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.config = filterConfig;
    }
    
    @Override
    public void destroy() {
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        
        String v1 = config.getInitParameter("v1");
        String v2 = config.getInitParameter("v2");
        System.out.printf("v1=%s, v2=%s\n", v1, v2);
        chain.doFilter(request, response);
    }
}
 
