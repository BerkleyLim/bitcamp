// 메서드 분류 - 인스턴스 변수와 메소드 타입
package step07;

public class ExamY_4 {
    public static void main(String[] args) {
        // 두 개의 식의 계산 결과를 따로 관리하기 위해서는
        // result 변수를 개별적으로 생성해야 한다.
        Calculator4 c1 = new Calculator4();  // 식1의 계산 결과를 보관할 메모리 준비
        Calculator4 c2 = new Calculator4();  // 식2의 계산 결과를 보관할 메모리 준비

        // 계산을 수행 시 계산 결과를 보관할 메모리를 전달하라!
        c1.plus(2); // + 2
        c2.plus(3); // + 3

        c1.plus(3); // + 2 + 3
        c2.multiple(2); // +3 * +2
        
        c1.minus(1); // + 2 + 3 - 1
        c2.plus(7); // + 3 * + 2 + 7
        
        c1.multiple(7); //
        c2.divide(4);  //

        c1.divide(3);
        c2.divide(4);


        // 식 1의 계산 결과 c1 인스턴스의 result에 들어 있고
        // 식 2의 계산 결과 c2 인스턴스의 result에 들어 있다.
        System.out.printf("c1.result = %d\n", c1.result);
        System.out.printf("c2.result = %d\n", c2.result);
    }
}