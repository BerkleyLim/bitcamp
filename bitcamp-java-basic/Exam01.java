// 컴파일과 실행
// 1) 컴파일
// > javac 소스파일명
// > javac Exam01.java
//
//     => 컴파일 후에 생성된 파일명 :
//          - Exam01.class

//     ==> 컴파일할 때 소스 파일을 작성할 때 
//       그 소스 파일이 os의 기본 인코딩으로 되어 있을 것이라 간주!!
//      IF> OS 기본 문자집합이 아닌 다른 문자집합으로 
//          Encoding 되어 있을 시, 컴파일 할 때 컴파일러에게 알려줘야 함!!
//          그래야 제대로 컴파일 가능!!
//      사용 예))
//       > javac -encoding "소스파일의 문자집합" "소스파일명"
//       > javac -encoding UTF-8 Exam01.java


// 2) 실행(run)
// > java 클래스명
// ==> 실행할 때는 클래스 이름을 지정한다.

// 코드 분류 -> class : classification의 약자. 코드 관리 용도.
class Exam01{


    // 메서드 = 함수 : 어떤 작업을 처리할 명령어를 묶어둔 블록
    public static void main(String[] args){


        System.out.println("Hello world!"); // 표준 출력 장치(모니터)로 출력하는 명령어
    }
}