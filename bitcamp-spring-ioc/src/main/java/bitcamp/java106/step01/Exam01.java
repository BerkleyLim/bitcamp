// 스프링 IoC 컨테이너 사용
package bitcamp.java106.step01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam01 {
    public static void main(String[] args) {
        // 스프링 IoC 컨테이너는 ApplicationContext의 구현한다.
        ApplicationContext iocContainer = null;
        
        // ApplicationContext 구현체 종류
        // 1) XML 파일 작성된 설정 정보를 읽어서 처리하는 IoC 컨테이너
        //    => ClassPathXmlApplicationContext (자바 classpath에서 xml 파일을 찾는다.)
        //    => FileSystemXmlApplicationContext (OS 파일시스템에서 xml 파일을 찾는다.)
        // 2) 클래스 안에 작성된 애노테이션을 읽어서 처리하는 IoC 컨테이너
        //    => AnnotationConfigApplicationContext
        //
        
        
        // ClassPathXmlApplicationContext 사용
        // => 자바 classpath에서 해당 경로의 XML 파일을 찾는다.
        // => 물론 XML 파일은 스프링 규칙에 따라 태그를 작성한다.
        iocContainer = new ClassPathXmlApplicationContext(
                "bitcamp/java106/step01/application-context.xml");
        
        Car car = (Car) iocContainer.getBean("c1");
        System.out.println(car);
        
        // 존재하지 않는 자바 객체를 꺼내려 한다면?
        // => 예외 발생!
        car = (Car) iocContainer.getBean("c2");
    }
}
