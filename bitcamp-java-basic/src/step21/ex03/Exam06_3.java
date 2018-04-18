// 예외 처리 후 마무리 작업 - try-with-resource
package step21.ex03;

import java.io.FileReader;
import java.util.Scanner;

public class Exam06_3 {
    
    static void m() throws Exception {
        // 자원 해제시키는 코드를 매번 작성하기가 귀찮다!
        // => try-with-resources 라는 문법을 사용하면 
        //    굳이 finally 블록으로 close()를 직접 호출할 필요가 없다.
        //    자동으로 처리한다.
        // => 단, java.lang.AutoCloseable 구현체에 대해서만 가능하다!
        // => 문법
        //    try (java.lang.AutoColseable 구현체) {....}
        
        try (
                Scanner keyScan = new Scanner(System.in); // OK!
                
                // FileReader 클래스도 java.lang.AutoCloseable 구현체이다.
                FileReader in = new FileReader("Hello.java"); // OK!

                // 반드시 AutoCloseable 구현체이어야 한다.
                //String s = "Hello"; // 컴파일 오류!
                
                // 변수 선언만 올 수 있다.
                //if (true) {} 
                
                ) {
            System.out.print("입력> ");
            int value = keyScan.nextInt();
            System.out.println(value * value);
        }
        
        // 문제는 close()를 호출하기 전에 예외가 발생시,
        // 제대로 자원을 해제시키지도 못한다는 것이다.
        // 이것을 해결하는 방법은 finally 블록을 사용하는 것이다.
    }
    
    public static void main(String[] args) throws Exception {
        m();
    }
}
