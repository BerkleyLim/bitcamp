// 논리 값 리터럴
package step01;
public class Exam08_2 {
    public static void main(String[] args) {

        // 다음과 같이 개별적으로 논리 값을 표현할 때는
        // 내부적으로 각 논리 값을 4byte 메모리에 보관한다.
        System.out.println(true);
        System.out.println(false);
        
        // 그러나 다음과 같이 여러 개의 논리 값을 배열에 보관할 때는
        // 내부적으로 각 논리 값을 1바이트 메모리에 보관한다.
        boolean[] arr = {true, true, true, false, false};
        System.out.println(arr[0]); // 비교 연산의 결과는 논리값이다.
        System.out.println(arr[1]); // 비교 연산의 결과는 논리값이다.
        System.out.println(arr[2]); // 비교 연산의 결과는 논리값이다.
    }
}

