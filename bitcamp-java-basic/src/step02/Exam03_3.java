// 변수 - 메모리에 값 저장하기!!

package step02;
//import java.util.Scanner;
//import java.io.InputStream;

public class Exam03_3 {
    public static void main(String[] args) {
        int a;
        // 할당(assignment; 배정) 연산자(연산을 수행하는 명령)
        // - 오른쪽을 지정된 값을 왼쪽에 가리키는 이름의 메모리에
        //   저장을 시키는 명령어.
        //
        a = 100; // 왼쪽에 a라는 이름을 가진 메모리에
                 // 100이라는 값을 저장한다.
                 
        int b;
        b = a;   // 왼쪽에 b라는 이름의 메모리에 
                 // a라는 이름의 메모리에 들어있는 값을 저장한다.
        
        System.out.println("a의 값 " + a);  // a의 값, 실행 결과 : 100
        System.out.println("b의 값 " + b);  // b의 값, 실행 결과 : 100
    }
}

// 변수에 값 할당(assignment)
// - 메모리에 값을 저장하는 것을 말한다.

// 문법
// - 변수명 = 변수 or 리터럴(literal) 

// 용어
// - '=' 왼쪽에 있는 변수를 'l-value' 라고 부름
// - '=' 오른쪽에 있는 변수는 'r-value' 라고 부름

// l-value : 변수만 올 수 있음
// r-value : 리터럴 or 변수가 올 수 있음