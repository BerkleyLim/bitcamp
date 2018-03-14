// 매서드 : 개념 및 기본 문법 2
package step06;

import java.util.Scanner;

public class Exam02_2 {
    // 2) 함수1 : 리턴값(x), 파라미터(O)
    // => 메서드 블록을 실행할 때 값이 필요하다면 파라미터 변수를 선언하라!
    // => "여기 돈 줄테니 밥 먹고 와!", "여기 등록금이다. 학비 내라."
    static void hello(String name, int age) {
        // 파라미터?
        // - 메서드를 실행할 때 사용할 값을 외부로부터 값을 받기 위해 
        //   선언한 로컬 변수.
        // - 메서드를 실행할 때 생성되고 메서드 실행이 끝나면 제거된다.

        System.out.printf("%d살 %s님 반갑습니다.\n", age, name);
    }

    public static void main(String[] args) {
        
        System.out.println("main()111111");
    
        // hello 메서드 호출하기
        hello("홍길동", 20);
        // hello 메서드 실행이 완료되면 다시 이리로 되돌아 와서
        // 다음 명령을 실핸한다.
        System.out.println("main()222222");

        // 메서드는 언제든 필요할 때 마다 반복하여 실행할 수 있다.
        hello("임꺽정", 30);

        System.out.println("main()333333");

        // 또 메서드 호출
        hello("유관순", 16);

        System.out.println("main()444444");
        
        // 파라미터의 타입, 개수, 순서가 일치해야 한다.
        // hello("윤봉길"); //컴파일 오류!
        /*
        src\step06\Exam02_2.java:40: error: method hello in class Exam02_2 cannot be applied to given types;
        hello("윤봉길");
        ^
        required: String,int
        found: String
        reason: actual and formal argument lists differ in length
         */

        //hello(20, "윤봉길"); //컴파일 오류!
        /*
        src\step06\Exam02_2.java:49: error: incompatible types: int cannot be converted to String
        hello(20, "윤봉길"); //컴파일 오류!
        */

        //String r = hello(20, "윤봉길"); //컴파일 오류!
        //void r = hello("안중근", 30); // 컴파일 오류!
        // void 라는 변수 선언을 할 수 없다.

    }
}


// argument(인자)
// => 메서드를 호출할 때 넘겨주는 값
// => 예) hello("홍길동", 20);
//     "홍길동", 20 이 argument 이다.

// 파라미터(parameter)
// => argument를 받는 변수
// => 예) void hello(String name, int age) {....}
//     name과 age 변수가 파라미터이다.

// 현장에서는 "argument"와 "parameter"를 구분하지 않고 사용한다.