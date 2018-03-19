// 사용자 정의 데이터 타입 - 클래스 변수 단점
package step07;

public class ExamY_3 {
    public static void main(String[] args) {
        // 클래스 변수는 오직 한 개만 존재하기 때문에
        // 여러 개의 작업을 불리하여 진행할 수 없다.

        // 다음 두 개의 식을 분리하여 계산해 보자.
        // 식1) 2 + 3 - 1 * 7 / 3 = ?
        // 식2) 3 * 2 + 7 / 4 - 5 = ?
        // 다음은 Score의 값을 다루는 연산자가 없을 대의 예이다.

        // 두 개의 식의 계산 결과를 따로 관리하기 위해서는
        // result 변수를 개별적으로 생성해야 한다.
        Calculator3 c1 = new Calculator3();  // 식1의 계산 결과를 보관할 메모리 준비
        Calculator3 c2 = new Calculator3();  // 식2의 계산 결과를 보관할 메모리 준비

        // 계산을 수행 시 계산 결과를 보관할 메모리를 전달하라!
        Calculator3.plus(c1, 2); // + 2
        Calculator3.plus(c2, 3); // + 3

        Calculator3.plus(c1, 3); // + 2 + 3
        Calculator3.multiple(c2, 2); // +3 * +2
        
        Calculator3.minus(c1, 1); // + 2 + 3 - 1
        Calculator3.plus(c2, 7); // + 3 * + 2 + 7
        
        Calculator3.multiple(c1, 7); //
        Calculator3.divide(c2, 4);  //

        Calculator3.divide(c1, 3);
        Calculator3.divide(c2, 4);


        // 식 1의 계산 결과 c1 인스턴스의 result에 들어 있고
        // 식 2의 계산 결과 c2 인스턴스의 result에 들어 있다.
        System.out.printf("c1.result = %d\n", c1.result);
        System.out.printf("c2.result = %d\n", c2.result);
    }
}