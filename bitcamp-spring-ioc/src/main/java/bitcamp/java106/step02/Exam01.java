// 객체 생성
package bitcamp.java106.step02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bitcamp.java106.BeanUtils;

public class Exam01 {
    public static void main(String[] args) {
        ApplicationContext iocContainer = new ClassPathXmlApplicationContext(
                "bitcamp/java106/step02/application-context-01.xml");
        /*
        Car car = (Car) iocContainer.getBean("c1");
        System.out.println(car);
        
        // 존재하지 않는 자바 객체를 꺼내려 한다면?
        // => 예외 발생!
        car = (Car) iocContainer.getBean("c2");
        */
        
        BeanUtils.printBeanList(iocContainer);
        

    }
}
