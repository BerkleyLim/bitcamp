// 예외 처리 후 마무리 작업 - try-with-resource
package step21.ex03;

import java.io.FileReader;
import java.util.Scanner;

public class Exam06_4 {
    static class A {}
    static class B implements AutoCloseable {
        @Override
        public void close() throws Exception {
            System.out.println("B 클래스의 자원을 해제하였습니다.");
        }
    }
    
    static void m() throws Exception {
        try (
                // A 클래스는 AutoCloseable 구현체가 아니기 때문에 여기에 선언 불가
                //A obj = new A();
                
                B obj2 = new B(); // OK!
            ) {
            System.out.println("try 블록 실행.... ");
        }
        
        // finally 블록에서 B의 close()를 호출하지 않아도,
        // 자동으로 호출될 것이다. 실행하여 확인하라!
    }
    
    public static void main(String[] args) throws Exception {
        m();
    }
}
