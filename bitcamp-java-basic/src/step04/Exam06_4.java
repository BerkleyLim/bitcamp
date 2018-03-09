// 증감 연산자 : 후위(post-fix) 증감 연산자 응용 2
package step04;

public class Exam06_4 {
    public static void main (String[] args) {
        int i = 2;
        int result = i++ + i++ * i++;   // result = 14
        // 첫번째 i++ => 2넣고 이후 3로 증가
        // 두번째 i++ => 3넣고 이후 4로 증가
        // 세번째 i++ => 4넣고 이후 5로 증가
        // i 의 값 : 5
        // result = 2 + 3 * 4;
        // result = 2 + 12;
        // result = 14;

        // 연산자 우선순위:
        // 1) ++. --
        // 2) *, /, %
        // 3) +, -
        // 4) =

        System.out.printf("%d %d \n", i , result);
    }
}