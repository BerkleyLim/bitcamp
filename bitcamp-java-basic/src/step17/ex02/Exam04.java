// 스태틱 멤버와 import
package step17.ex02;

// 스태틱 중첩 클래스를 사용할 때 바깥 클래스를 지정하고 싶지 않다면
// 다음과 같이 미리 해당 스태틱 멤버가 들어 있는 클래스를 컴파일러에게 알려줘라! 
import step17.ex02.Category2.*;

public class Exam04 {
    public static void main(String[] args) {
        Product2 p = new Product2();
        
        //p.category = Category2.appliance.TV;
        
        // 위에서 import로 인스턴스가 들어 있는 클래스의
        // Category2 클래스에 대해 정보를 컴파일러에게 알려줬기 때문에
        // 다음과 같이 클래스 이름을 생략하고 쓸 수 있다.
        p.category = appliance.TV;
        p.category = book.NOVEL;
        p.category = computer.MOUSE;
        p.name = "울트라비전 뷰";
        p.price = 2000000;
    }
}
