// AOP(Aspect-Oriented Programming) - AOP 필터 적용 후
package bitcamp.java106.step13.ex2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

// 주석 추가

// AOP 용어:
// => Advice        : 메서드(join point) 호출 앞뒤에 삽입될 코드이다. 필터 객체이다.
//                    예) MyAdvice
// => Join Point    : Advice가 들어갈 메서드이다.
//                    예) m() 메서드
// => Pointcut      : Advice를 삽입할 위치 정보이다.
//                    예) execution(* bitcamp.java106.step13.ex2.*.*(..))
// => Target Object : Advice를 삽입할 대상 객체이다.
//                    예) X, Y, C 클래스
// => Aspect        : 어느 pointcut에 어떤 advice를 삽입할 것인지 카리키는 정보이다.
//                    예) 설정 정보

// 작업 클래스
// => Advice        : MyAdvice
// => Join Point    : m() 메서드
// => Pointcut      : execution(* bitcamp.java106.step13.ex2.*.*(..))
// => Target Object : 
// =>
public class Exam03 {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext iocContainer = 
                new ClassPathXmlApplicationContext(
                        "bitcamp/java106/step13/ex2/application-context-03.xml");
        
        String[] names = iocContainer.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(iocContainer.getBean(name).getClass().getName());
        }
        System.out.println("---------------------------------------");
        
        Caller caller = (Caller) iocContainer.getBean(Caller.class);
        caller.test();
    }

}



