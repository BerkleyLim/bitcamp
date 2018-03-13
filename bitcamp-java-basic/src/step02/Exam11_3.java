// 변수의 범위 - 변수의 중복
package step02;

public class Exam11_3 {
  
    int a; // 인스턴스 변수
    static int b; // 클래스 변수

    // 클래스 블록 안에 선언된 변수는 종류에 상관없이 중복 선언 불가!
    //int a; // 컴파일 오류!!
    //static int a; // 컴파일 오류!
    //int b;  // 컴파일 오류
    //static int b; // 컴파일 오류!

    public static void main(String[] args /*로컬변수 = 파라미터*/) {
        // 그러나 메서드 블록에서는 클래스에 선언된 변수의 이름과
        // 같은 변수를 선언할 수 있다.
        // 왜? 영역이 다르니깐
        int a;
        int b;

        // 마찬가지로 이 블록 안에서는 같은 이름의 변수를 만들 수 없다.
        //String a;   // 컴파일 오류! 데이터 타입에 상관없이 이름 중복 불가!
    }

    public static void m2() {
        // 여기에 선언된 변수는 main() 블록에 선언된 변수와 다른 변수이다.
        int a;
        int b;


    }

}

// 인스턴스 변수 (instance variable)
// - new 명령을 사용하여 인스턴스 준비할 때 생성되는 변수

// 클래스 변수 (class variable = static variable)
// - 클래스가 로딩될 때 생성되는 변수

// 로컬 변수 (local variable)
// - 블록을 실행할 때 생성되는 변수
// - 로컬 변수 중에서 메서드의 argument 받는 변수는 
//   "파라미터(parameter)" 라 부른다.
//   예) 위의 코드에서 main()의 args 변수가 파라미터이다.