// 정수의 리터럴 2번째 - 자리수 표기!
package step01;
public class Exam05_2 {
    public static void main(String[] args) {
        // _를 사용하여 읽기 쉽도록 숫자의 자릿수를 표시 가능!
        // 물론 위치는 작성자 마음 (한마대로 내 마음이다!)
        System.out.println(12783406);
        System.out.println(1278_3406);
        System.out.println(12_783_406);

        // - 0b 또는 .0B 로 시작한다.
        System.out.println(0b1100100);
        System.out.println(0b110_0100);
        //System.out.println(0b_110_0100);// 언더바가 0b 앞에 있으면 error

    }
}

// 10진수
// - 일반적으로 값을 알려주고 싶을 때 사용한다.

// 8진수
// - 코드에서 거의 사용하지 않는다.

// 2진수
// - 메모리 상태를 알려주고 싶을 때 사용한다.

// 16진수
// - 2진수로 표기하면 너무 길어지기 때문에
//   주로 16진수로 표기한다.

// 결론!
// - 코드를 작성할 때 주로 10진수로 표기한다.
// - 간혹 메모리 상태에 집중하라고 강조하고 싶을 때 16진수로 표기!

