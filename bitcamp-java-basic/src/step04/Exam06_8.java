// 증감 연산자 : 전위(pre-fix) 증감 연산자 응용2
package step04;


public class Exam06_8 {
    public static void main (String[] args) {
        int i = 2;
        int result = ++i + ++i * ++i;
        // 1) int result = 3 + 4 * 5;
        //        result = 3 + 20;
        //        result = 23;
        // 2) i = 5

        System.out.println(result);  // 23

        // 주의!
        // 1) pre-fix 연산자나 post-fix 연산자를 리터럴에 적용 불가
        //int x = ++100; // 컴파일 오류
        //x = 100++; // 컴파일 오류

        // 2) 변수에 동시에 적용할 수 없다.
        int y = 100;
        //++y++;  // 컴파일 오류
        //(++y)++;  // 컴파일 오류, 값의 대한 에러, 즉 전위 후의 연산자 사용 못함
        //++(y++); // 컴파일 오류
    }
}