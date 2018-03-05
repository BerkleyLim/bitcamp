// 자바는 대문자.
// 키보드 입력 받기

// 자바 = 패키지, 타 언어 = 네임스페이스 로 많이 쓰임
package step02;
//import java.util.Scanner;
//import java.io.InputStream;

public class Exam02_1 {
    public static void main(String[] args) {
        // 키보드 정보를 가져온다.  = InputStream
        java.io.InputStream keyboard = System.in;

        // 키보드에서 값을 꺼내주는 도구를 연결한다. = Scanner
        java.util.Scanner KeyScan = new java.util.Scanner(keyboard); 

        // print()는 문자열을 출력 후 줄바꿈 X
        System.out.print("팀명? "); 

        // nextLine() : 
        // - Scanner 도구를 사용하여 키보드로부터 입력된 데이터를 읽어서
        //   한 줄의 문자열을 가져올 때 사용하는 명령이다.
        // - 동작은?
        //   사용자가 한 출 입력할 때 까지,
        //   즉 입력 데이터에 줄바꿈을 의미하는 0d0a 2바이트가 들어올 때까지
        //   대기한다.
        //   사용자가 Enter 키를 누르면,
        //   입력값으로 0d0a가 2바이트 값이 들어오고,
        //   (0d : Carrage Return(CR) , 0a : Line Feed(LF))
        //   nextLine() 비로서 사용자가 입력한 값을 return함
        //   그 리턴 값을 println() 명령을 사용하여 콘솔로 출력한다.
        System.out.println(KeyScan.nextLine());
    }
}

// System.out
// - 표준 출력 장치
// - 즉 콘솔(모니터, 명령창) 가리킨다.

// System.in
// - 표준 입력 장치
// - 즉 키보드 가리킨다.