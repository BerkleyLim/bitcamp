// 예외 처리 문법을 적용하기 전 - 리턴 값을 이용한 오류 알림
package step21.ex01;

public class Exam01_1 {
    public static void main(String[] args) {
     // 유효하지 않은 연산자를 지정할 때,
        int result = Calculator.compute("+", 100, 200);
        System.out.println(result);
        
        
     
    }
}
