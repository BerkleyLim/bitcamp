// 예외 처리 후 마무리 작업 - finally 블록과 자우너 해제
package step21.ex03;

import java.util.Scanner;

public class Exam06_2 {
    
    static void m(){
        Scanner keyScan = null;
        try {
            // 키보드 입력을 읽어 들이는 도구 준비
            keyScan = new Scanner(System.in);
            
            // 스캐너 객체를 사용하여 키보드 입력을 읽어 드린다.
            // => 예외가 발생한다면?
            System.out.print("입력> ");
            int value = keyScan.nextInt();
            System.out.println(value * value);
            
        } finally {
            // 이렇게 정상적으로 실행되든 예외가 발생하든 상관없이
            // 자원해제 같은 일은 반드시 실행해야 한다.
            keyScan.close();
            System.out.println("스캐너 자원 해제!");
        }
        
        // 문제는 close()를 호출하기 전에 예외가 발생시,
        // 제대로 자원을 해제시키지도 못한다는 것이다.
        // 이것을 해결하는 방법은 finally 블록을 사용하는 것이다.
    }
    
    public static void main(String[] args) {
        m();
    }
}
