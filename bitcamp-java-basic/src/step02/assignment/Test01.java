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