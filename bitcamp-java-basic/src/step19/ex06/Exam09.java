// IoC 컨테이너 만들기 - 6) class 객체를 이용하여 인스턴스를 만들어 저장한다.
package step19.ex06;

import java.util.List;

import step19.ex03.ApplicationContext4;

// => 클래스 이름으로 해당 클래스를 로딩한 후 클래스 객체를 가져온다.
//    왜? Class 객체가 있으면 언제라도 인스턴스를 생성할 수 있기 ㄸ#ㅐ문이다.
public class Exam09 {
    public static void main(String[] args) throws Exception {
        ApplicationContext7 appContext = new ApplicationContext7("step19.ex01");
        List<Object> objects = appContext.getObjects();
        for (Object obj : objects) {
            System.out.println(obj.getClass().getName());
        }
    }
}
