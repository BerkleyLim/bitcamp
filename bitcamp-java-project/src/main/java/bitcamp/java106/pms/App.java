package bitcamp.java106.pms; // java폴더가 루트

import java.io.InputStream;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String team;    // 팀명
        String detail;  // 설명
        int people;     // 최대 인원
        String startday; // 시작일
        String endday;   // 종료일

        InputStream keyboard = System.in;
        Scanner sc = new Scanner(keyboard);

        System.out.print("팀명? ");
        team = sc.nextLine();

        System.out.print("설명? ");
        detail = sc.nextLine();

        System.out.print("최대인원? ");
        people = sc.nextInt();
        sc.nextLine();      // 다음 sc.nextLine() 입력 되지 않게 하기 위해 방지
                            // nextInt() 부분에서 숫자 입력 후 Enter의 대한
                            // 특수 문자(\n) 입력된다.

        System.out.print("시작일? ");
        startday = sc.nextLine();

        System.out.print("종료일? ");
        endday = sc.nextLine();

        System.out.println("----------------------");

        System.out.println("팀명: " + team);
        System.out.println("설명: \n" + detail);
        System.out.println("최대인원: " + people);
        System.out.println("일자: " + startday + " ~ " + endday);

    }
}

/*
C:\Users\Bit\git\bitcamp\bitcamp-java-project>java -cp bin bitcamp.java106.pms.App
실행결과 
팀명? 비트비트
설명? 자바 프로젝트 팀
최대인원? 5
시작일? 2018-05-05
종료일? 2018-08-20
----------------------
팀명: 비트비트
설명:
자바 프로젝트 팀
최대인원: 5
일자: 2018-05-05 ~ 2018-08-20

C:\Users\Bit\git\bitcamp\bitcamp-java-project>java -cp bin bitcamp.java106.pms.App
팀명? Classic
설명? 클래식 음악 좋아하는 사람의 모임
최대인원? 10
시작일? 2018-03-02
종료일? 2018-05-06
----------------------
팀명: Classic
설명:
클래식 음악 좋아하는 사람의 모임
최대인원: 10
일자: 2018-03-02 ~ 2018-05-06
*/

/*
<강사님 코드>
package bitcamp.java106.pms;
public class App {
    public static void main(String[] args) {
        InputStream keyboard = System.in;
        Scanner KeyScan = new Scanner(keyboard);

        System.out.print("팀명? ");
        String teamName = KeyScan.nextLine();

        System.out.print("설명? ");
        String description = KeyScan.nextLine();

        System.out.print("최대인원? ");
        String maxQty = KeyScan.nextLine(); 

        System.out.print("시작일? ");
        String startDate = KeyScan.nextLine();

        System.out.print("종료일? ");
        String endDate = KeyScan.nextLine();

        System.out.println("----------------------");
        
        System.out.print("팀명: ");
        System.out.println(teamName);
        System.out.println("설명: ");
        System.out.println(description);
        System.out.print("최대인원: ");
        System.out.println(MaxQty);
        System.out.print("일자: ");
        System.out.print(startDate);
        System.out.print(" ~ ");
        System.out.println(endDate);

    }
}
*/