// 키보드 입력 받기2 - 응용

// 자바 = 패키지, 타 언어 = 네임스페이스 로 많이 쓰임
package step02;
//import java.util.Scanner;
//import java.io.InputStream;

public class Exam02_2 {
    public static void main(String[] args) {
        // 키보드 정보를 가져온다.  = InputStream
        // 키보드에서 값을 꺼내주는 도구를 연결한다. = Scanner
        java.io.InputStream keyboard = System.in;
        java.util.Scanner KeyScan = new java.util.Scanner(keyboard); 

        // 문제 : 팀 멤버의 정보를 입력 받아 출력하라.
        // 이름, 전화, 이메일, 나이, 재직여부
        System.out.print("이름을 입력하세요 : ");
        System.out.println(KeyScan.nextLine());

        System.out.print("전화를 입력하세요 : ");
        System.out.println(KeyScan.nextLine());

        System.out.print("이메일을 입력하세요 : ");
        System.out.println(KeyScan.nextLine());

        System.out.print("나이를 입력하세요 : ");
        System.out.println(KeyScan.nextLine());

        System.out.print("재직여부를 입력하세요 : ");
        System.out.println(KeyScan.nextLine());
    }
}

// 실행 결과
/*
이름을 입력하세요 : 임현식
임현식
전화를 입력하세요 : 010-6264-7643
010-6264-7643
이메일을 입력하세요 : hunsik416@naver.com
hunsik416@naver.com
나이를 입력하세요 : 26
26
재직여부를 입력하세요 : no
no
*/