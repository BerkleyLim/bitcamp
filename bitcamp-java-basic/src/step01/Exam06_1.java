// 부동 소숫점의 리터럴(literal)
package step01;
public class Exam06_1 {
    public static void main(String[] args) {
         System.out.println(3.14);

         // exponential 기호를 사용하기!
         // => 숫자e지수 or 숫자E지수 표시!
         System.out.println(0.0314e2); // 0.0314 * 10^2
         System.out.println(0.314e1); // 0.314 * 10^1
         System.out.println(31.4e-1); // 31.4 * 10^(-1)
         System.out.println(314e-2); // 314 * 10^(-2)
         // => 이렇게 e 기호를 사용하여 소수점의 위치를 조정할 수 있다.
         //    소수점의 위치를 움직인다고 해서 "부동소숫점" 이라고 부른다.
    }
}


