// 주석
package step01;
/**
 * javadoc 주석
 * => 소스파일에서 추출하여 HTML 문서를 만들 때 사용하는 주석이다.
 * => 클래스 앞에, 메서드 앞에, 변수 선언 앞에 붙인다.
 * 
 */
public class Exam03 {
    /**
     * 변수 선언 앞에 설명을 붙여 놓으면
     * 나중에 HTML 문서를 만들 때 추출할 수 있다.
     */
    int var;

    /**
     * 메서드에 대한 설명을 여기에 붙여 놓으면
     * 나중에 HTML 문서를 만들 때 추출 가능하다.
     */
    public static void main(String[] args) {
        // 한줄 주석
        // => 줄이 끝날 때까지 주석으로 간주한다.
        /*
            여러줄 주석
            => 주석의 끝을 만날 때 까지 주석으로 간주한다.
        */
        System.out.println("src/step01/Exam03");
    }

    // 에노테이션(annotation)?
    // => @이름 형태로 된 주석이다.
    // => 컴파일러나 JVM에게 특별한 명령을 전달할 때 사용한다.
    // => 컴파일한 후에도 .class 파일에 존재할 수 있다.
    // 
    @Override
    public String toString() {
        return "Exam03";
    }

}

// 주석?
// ==> 소스 코드에 대한 설명이다.
//     소스 코드를 해석하는데 돕기 위해 작성한다.
// ==> 컴파일하면 제거된다.
//     즉 .class 파일에는 존재하지 않는다.
