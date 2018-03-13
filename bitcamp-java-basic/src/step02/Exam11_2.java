// 변수의 범위 - 종류에 따른 사용 범위
package step02;

public class Exam11_2 {
  
    int a; // 인스턴스 변수
    static int b; // 클래스 변수

    public static void main(String[] args /*로컬변수 = 파라미터*/) {
        int c; // 로컬 변수
    }

    public static void m2() {
        // static 이 붙은 블록(스태틱 메서드 = 클래스 메서드)에서는
        // 그 블록 바깥 쪽에 있는 스태틱 변수(클래스 변수)를 사용 할 수 있다.
        b = 20;

        // 그러나 static 붙지 않은 인스턴스 변수는 사용할 수 없다.
        // a = 100; // 컴파일 오류!
    }

    public void m3() {
        // static 이 붙지 않은 블록 (인스턴스 블록)에서는
        // 그 블록 바깥 쪽에 선언된 변수를 모두 접근할 수 있다.
        b = 20; // OK
        a = 100; // OK
    }

    public void m4() {
        b = 20; // OK
        a = 100; // OK
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