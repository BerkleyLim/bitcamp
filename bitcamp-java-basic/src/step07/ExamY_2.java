// 사용자 정의 데이터 타입 - 클래스 변수 사용
package step07;

public class ExamY_2 {
    public static void main(String[] args) {
        // 클래스 변수는 오직 한 개만 존재하기 때문에
        // 여러 개의 작업을 불리하여 진행할 수 없다.

        // 다음 두 개의 식을 분리하여 계산해 보자.
        // 식1) 2 + 3 - 1 * 7 / 3 = ?
        // 식2) 3 * 2 + 7 / 4 - 5 = ?
        // 다음은 Score의 값을 다루는 연산자가 없을 대의 예이다.
        Calculator2.plus(2); // + 2
        Calculator2.plus(3); // + 3

        Calculator2.plus(3); //
        Calculator2.multiple(2);
        
        Calculator2.minus(1);
        Calculator2.plus(7);
        
        Calculator2.multiple(7);
        Calculator2.divide(4);

        Calculator2.divide(3);
        Calculator2.divide(5);


        System.out.printf("result = %d\n", Calculator2.result);
    }
}