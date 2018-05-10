// 서블릿 클래스가 구현해야 할 메서드를 미리 이 클래스에서 구현해 둔다.
package step01;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

// Servlet 인터페이스에 선언된 메서드 중에서
// 개발자가 관심없는 메서드는 이 클래스에서 미리 구현해 둔다.
// 그러면 개발자는 Servlet 인터페이스를 직접 구현하기 보다는
// 이 클래스를 상속 받음으로써 개발이 간결해 질 것이다.
// 복습 : 추상클래스 : 서브클래스의 공통 속성과 상속을 해주는 것
//      추상메서드 : 메소드를 강제로 구현하게 하기 위해, 어차피 재정의 해야 할 메서드일 경우
//      지금 interface Servlet의 Service를 정의 되어 있다.
//      추상클래스를 선언하면 여기서 Service 메서드를 굳이 사용 하지 않아도 됨
public abstract class GenericServlet implements Servlet {
    ServletConfig config;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }
    
    @Override
    public void destroy() {}
    
    @Override
    public String getServletInfo() {
        return this.getClass().getName();
    }
    
    @Override
    public ServletConfig getServletConfig() {
        return this.config;
    }
}
