// 레퍼런스 - 가비지와 가비지 컬렉터
package step03;

public class Exam03_1 {
    public static void main(String[] args) {
        // 여러개의 인스턴스 주소 저장하기

        class Score {
            String name;
            int kor;
            int eng;
            int math;
            int sum;
            float aver;  
        }

        // Score 레퍼런스 선언
        Score s1 = new Score();

        // 인스턴스를 만들어 그 주소를 레퍼런스에 저장한다.
        s1 = new Score();

        // 새 인스턴스를 만들어 s1에 주소를 저장한다.
        s1 = new Score();

        // 그러면 기존에 들어 있던 주소는 잃어 버린다.
        // 주소를 잃어버려 사용할 수 없는 메모리를 "가바지(garbage)"라 부른다.

        // 가비지는 가비지 컬렉터에 의해 메모리에서 해제된다.
        // 가비지 컬렉터(garbage collector)의 실행
        // - 메모리 부족할 때
        // - CPU가 한가할 때
        // - System.gc()를 호출하여 가비지 실행을 요청할 때
        //   물론 이 경우에 바로 실행하는 것이 아니라
        //   빠른 시간 내에 실행할 것으로 종용하는 것이다.
        //   아무래도 원래의 시간보다는 앞 당겨 청소를 하게 될 것이다.
        

    }
}

// 클래스(class)
// - 여러 타입을 묶어서 사용자 정의 데이터 타입을 만드는 문법이다.
// - 관련된 기능(메서드, 함수)을 관리하기 편하게 묶는 문법이다.

// 배열(Array)
// - 단일한 타입의 메모리를 묶는 문법이다.

// primitive 변수와 레퍼런스
// - primitive type(byte, short, int, long, float, double, boolean, char)의 
//   메모리를 만들 때 변수 선언 만으로 완료된다.
//   변수 이름이 곧 메모리를 가리키는 이름이 된다.
//   예) int age;
// - class(사용자 정의 데이터 타입)으로 메모리를 만들 때는
//   반드시 new 명령을 사용해야 한다.
// - 메모리를 만든 후에는 그 주소를 변수에 저장해서 메모리를 사용한다.
//   예) Score s; <==== 메모리의 주소를 저장하는 변수
//       s = new Score(); <==== 메모리를 확보한 후 그 주소를 s에 저장.

// 인스턴스의 항목 접근하기
// - 문법
//   레퍼런스명.항목명 = 값;
//   예) Score s = new Score();
//       s.name = "홍길동";
