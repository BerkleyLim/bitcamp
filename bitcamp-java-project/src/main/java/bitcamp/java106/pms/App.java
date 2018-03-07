package bitcamp.java106.pms; // java폴더가 루트

import java.io.InputStream;
import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        final int members = 5;   // 최대 5명 입력 가능
        InfList[] il = new InfList[members];
        int inputCount=members; // 최대 입력 갯수
        char ch = 0;

        InputStream keyboard = System.in;
        Scanner sc = new Scanner(keyboard);

        for(int i=0; i < members ; i++) {
            il[i] = new InfList();
            
            System.out.print("팀명? ");
            il[i].team = sc.nextLine();
            
            System.out.print("설명? ");
            il[i].detail = sc.nextLine();

            System.out.print("최대인원? ");
            il[i].member = sc.nextLine();

            System.out.print("시작일? ");
            il[i].startDay = sc.nextLine();

            System.out.print("종료일? ");
            il[i].endDay = sc.nextLine();

            // 조건문 적용
            if(i != members - 1) {
                System.out.print("계속 입력하시겠습니까? (Y/n)  ");
                ch = sc.nextLine().charAt(0);
            }

            if('n' == ch || i == members -1) {
                inputCount = i + 1;
                break;
            } 
                
        }

        System.out.println("--------------------------------");

        for(int i =0 ; i < inputCount; i++) {
            System.out.println(il[i].team + ", " + il[i].member + 
                ", " + il[i].startDay + " ~ " + il[i].endDay);
        }
    }
}

/*
<실행결과>
C:\Users\Bit\git\bitcamp\bitcamp-java-project>java -cp bin bitcamp.java106.pms.App
팀명? 비트비트
설명? 자바 프로젝트팀
최대인원? 5
시작일? 2018-05-05
종료일? 2018-08-20
계속 입력하시겠습니까? (Y/n)  Y
팀명? Classic
설명? 클래식 좋아하는 사람 모임
최대인원? 10
시작일? 2018-01-02
종료일? 2018-03-05
계속 입력하시겠습니까? (Y/n)  Y
팀명? Chopin
설명? 쇼팽을 좋아하는 사람들의 모임
최대인원? 20
시작일? 2018-01-01
종료일? 2018-10-31
계속 입력하시겠습니까? (Y/n)  n
--------------------------------
비트비트, 5, 2018-05-05 ~ 2018-08-20
Classic, 10, 2018-01-02 ~ 2018-03-05
Chopin, 20, 2018-01-01 ~ 2018-10-31
*/