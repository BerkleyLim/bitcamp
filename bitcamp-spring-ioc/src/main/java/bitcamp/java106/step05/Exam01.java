// 프로퍼티 호출
package bitcamp.java106.step05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bitcamp.java106.BeanUtils;

public class Exam01 {
    public static void main(String[] args) {
        // ClassPathXmlApplicationContext("리소스 경로");
        // => 보통 컨텍스트의 정의를 구성하는 XML 파일 같은 리소스의 위치 경로를 문자열 or 문자 배열 받음
        // 
        ApplicationContext iocContainer = new ClassPathXmlApplicationContext(
                "bitcamp/java106/step05/application-context-01.xml");
        
        System.out.println(iocContainer.getBean("c1"));
        System.out.println(iocContainer.getBean("c2"));
    }
}
