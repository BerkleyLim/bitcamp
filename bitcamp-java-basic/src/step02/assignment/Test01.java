package step02.assignment;

import java.io.InputStream;
import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {
        String name;    // 이름
        int kor;     // 국어
        int eng;     // 영어
        int math;    // 수학
        int sum;     // 합계
        double avg;  // 평균

        InputStream keyboards = System.in;   // 입력할 키보드
        Scanner sc = new Scanner(keyboards);    // 도구 입력

        System.out.print("이름? ");
        name = sc.nextLine();

        System.out.print("국어? ");
        kor = sc.nextInt();

        System.out.print("영어? ");
        eng = sc.nextInt();

        System.out.print("수학? ");
        math = sc.nextInt();

        System.out.println("-----------------------");

        sum = kor + eng + math;
        avg = sum / 3;

        System.out.println(name + "  " + kor + " "+ eng + " " +
         math + " " + sum + " " + avg);
    }
}

/*
C:\Users\Bit\git\bitcamp\bitcamp-java-basic>java -cp bin step02.assignment.Test01
실행결과 
이름? 홍길동
국어? 100
영어? 90
수학? 80
-----------------------
홍길동  100 90 80 270 90.0

C:\Users\Bit\git\bitcamp\bitcamp-java-basic>java -cp bin step02.assignment.Test01
이름? 임현식
국어? 77
영어? 46
수학? 99
-----------------------
임현식  77 46 99 222 74.0
*/

/* 
<강사님 코드> // 1단계 : 1명의 성적을 입력 받아서 출력하기.
package step02.assignment;

public class Test01 {
    public static void main(String[] args) {
        java.io.InputStream keyboard = System.in;
        java.util.Scanner KeyScan = new java.util.Scanner(keyboard); 

        System.out.print("이름? ");
        String name = KeyScan.nextLine();

        System.out.print("국어? ");
        int kor = KeyScan.nextInt();

        System.out.print("영어? ");
        // 이전에 국어 점수를 입력 받을 때 들어온 줄바꿈 코드는
        // nextInt() 메서드에서 버린다.
        int eng = KeyScan.nextInt();

        System.out.print("수학? ");
        int math = KeyScan.nextInt();

        int sum = kor + eng + math;
        int avg = sum / 3;

        System.out.println("-----------------------");

        System.out.print(name);
        System.out.print("  ");
        System.out.print(kor);
        System.out.print("  ");
        System.out.print(eng);
        System.out.print("  ");
        System.out.print(math);
        System.out.print("  ");
        System.out.print(sum);
        System.out.print("  ");
        System.out.print(avg);
        System.out.println();
    }
}
*/