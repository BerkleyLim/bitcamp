// 리터럴(literal)
package step01;
public class Exam04 {
    public static void main(String[] args) {
        // 정수
        // => 4byte size 정수 -> 자료형 : int형
        System.out.println(10);
        System.out.println(+10);
        System.out.println(-10);
        
        // => 8byte size 정수 -> 자료형 : long 형
        //    숫자 뒤에 l, L을 붙인다.!!!!!!!
        System.out.println(10L);
        System.out.println(+10L);
        System.out.println(-10L);


        // 부동소숫점
        // => 4byte size -> 자료형 : float 형
        //    숫자 뒤에 F, f를 붙인다.
        System.out.println(3.14F);
        System.out.println(3.14f); 

        // => 8byte size 정수 -> 자료형 : double 형
        System.out.println(3.14);
        System.out.println(31.4e-1);    // value : 3.14 


        // 문자열
        System.out.println("오호라....");

        // 한 개의 문자
        System.out.println('가');

        // 논리값
        System.out.println(true);
        System.out.println(false);

    }
}

// 자바 코드로 값을 표현하는 것

