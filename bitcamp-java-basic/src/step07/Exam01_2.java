package step07;




public class Exam01_2 {
    public static void main(String[] args) {
        int result = 0;

        // 2 + 3 - 1 * 7 / 3 = ?
        // => 연산자 우선 순위 고려하지 않고 순서대로 계산!!
        result = Calculator.plus(2,3);
        result = Calculator.minus(result,1);
        result = Calculator.multiple(result, 7);
        result = Calculator.divide(result, 3);
    }
}
