// 배열 - 배열 선언과 사용
package step02;

public class Exam09_1 {
    public static void main(String[] args) {
        // 배열 사용 전
        int i1, i2, i3, i4, i5;

        // 배열 선언 방식
        int[] arr1 = new int[5];    // OK
        int arr2[] = new int[5];    // Ok -> C언어 스타일

        // 배열 메모리에 접근
        arr1[0] = 100;
        arr1[1] = 200;
        arr1[2] = 300;
        arr1[3] = 400;
        arr1[4] = 500;

        // 유효하지 않은 인데스를 지정한다면??
        arr1[5] = 600;  // 컴파일만 가능, 단 인덱스가 유효한지 알수 없음
                        // 따라서 실행할 시 오류 발생
        
    }
}

// 배열
// - 같은 종류의 메모리를 쉽게 만드는 방법

// - 문법
//   메모리종류[] 메모리이름 = new 메모리 종류[갯수];
//   (데이터타입[] 변수명 = new 데이터타입[갯수];)
//   ex) int[] arr = new int[5];  // <- 이 방법으로 사용

// - C언어 스타일
//   데이터타입 변수명[] = new 데이터타입[갯수];
//   ex) int arr[] = new int[5];


// 배열 메모리의 접근
// - 문법
//   베열변수[인덱스] = 값;
//   ex) arr1[0] = 100;

// - 배열의 인덱스는 0부터 시작한다.

// - 따라서 인덱스의 범위는 0 ~ (배열 갯수 - 1) 이다.


