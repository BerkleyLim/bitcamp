// 사용자 정의 데이터 타입 - 메서드 = 연산자
package step07;

public class Exam02_2 {
    public static void main(String[] args) {
        // 계산 결과를 보관할 변수는 더이상 필요 없음
        // Calculator2 내부에서 계산 결과를 관리한다.
        // int result =0;

        // 다음은 Score의 값을 다루는 연산자가 없을 대의 예이다.
        Calculator2.plus(2);
        Calculator2.plus(3);
        Calculator2.minus(1);
        Calculator2.multiple(7);
        Calculator2.divide(7);

        System.out.printf("result = %d\n", Calculator2.result);
    }
}