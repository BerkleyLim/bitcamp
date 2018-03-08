package bitcamp.java106.pms; // java폴더가 루트

import java.io.InputStream;
import java.util.Scanner;

// 컴파일러에게 클래스의 위치 정보를 알려준다.
// => 컴파일한 후 import 명령은 제거된다.
//    즉, .class 파일에 포함되지 않는다.
// => 그러니 import 문장이 많으면 .class 파일이 커지지 않을까 걱정말라!
import bitcamp.java106.pms.domain.InfList;

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
                // ch = sc.nextLine();  // 다음 조건문에 ch.equal("n") 사용시

            }

            if('n' == ch || 'N' == ch) {  // 또는 ch.toLowerCase().equal("n");
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

/*
<강사님 코드>

// 1단계 : 클래스 적용
packabe bitcamp.java106.pms.domain; // 이것은 domain


// 메모리 설계도 만든다. (메모리 설계도 = 클래스, 만든다. = 정의한다.)
// 참고로 Team.java 따로 만들어서 넣는다. (domain 폴더에 만들어서 넣기)
public class Team { // public 부분 : modifier이라 부른다.
                    // modifier : 원래의 특징이나 성질을 변경
    public String name;   
    public String description;
    public int maxQty;
    public String startDate;
    public String endDate;
}

public class App {
    public static void main(String[] args) {
        java.io.InputStream keyboard = System.in;
        java.util.Scanner keyScan = new java.util.Scanner(keyboard);

        bitcamp.java106.pms.domain.Team team = 
            new bitcamp.java106.pms.domain.Team();

            System.out.print("팀명? ");
            team.name = sc.nextLine();
            
            System.out.print("설명? ");
            team.description = sc.nextLine();

            System.out.print("최대인원? ");
            team.maxQty = sc.nextInt();
                    sc.nextLine();

            System.out.print("시작일? ");
            team.startDate = sc.nextLine();

            System.out.print("종료일? ");
            team.endDate = sc.nextLine();

            System.out.println("--------------------------------");

            System.out.printf("%s, %d명, %s ~ %s\n",
                  team.name, team.maxQty, team.startDate, team,endDate);
    }
}
// 1단계 끝



// 2단계 : 배열 적용
packabe bitcamp.java106.pms.domain; // 이것은 domain

import bitcamp.java106.pms.domain.Team;
import java.io.InputStream;
import java.util.Scanner;

// 메모리 설계도 만든다. (메모리 설계도 = 클래스, 만든다. = 정의한다.)
// 참고로 Team.java 따로 만들어서 넣는다. (domain 폴더에 만들어서 넣기)
public class Team { // public 부분 : modifier이라 부른다.
                    // modifier : 원래의 특징이나 성질을 변경
    public String name;   
    public String description;
    public int maxQty;
    public String startDate;
    public String endDate;
}

public class App {
    public static void main(String[] args) {
        InputStream keyboard = System.in;
        Scanner keyScan = new Scanner(keyboard);

        Team[] team = new Team[100];
        team[0] = new Team();

            System.out.print("팀명? ");
            team[0].name = sc.nextLine();
            
            System.out.print("설명? ");
            team[0].description = sc.nextLine();

            System.out.print("최대인원? ");
            team[0].maxQty = sc.nextInt();
                    sc.nextLine();

            System.out.print("시작일? ");
            team[0].startDate = sc.nextLine();

            System.out.print("종료일? ");
            team[0].endDate = sc.nextLine();

            System.out.println("--------------------------------");

            System.out.printf("%s, %d명, %s ~ %s\n",
              team[0].name, team[0].maxQty, team[0].startDate, team[0],endDate);
    }
}
// 2단계 끝



// 3단계 : 반복문 적용
packabe bitcamp.java106.pms.domain; // 이것은 domain

import bitcamp.java106.pms.domain.Team;
import java.io.InputStream;
import java.util.Scanner;

// 메모리 설계도 만든다. (메모리 설계도 = 클래스, 만든다. = 정의한다.)
// 참고로 Team.java 따로 만들어서 넣는다. (domain 폴더에 만들어서 넣기)
public class Team { // public 부분 : modifier이라 부른다.
                    // modifier : 원래의 특징이나 성질을 변경
    public String name;   
    public String description;
    public int maxQty;
    public String startDate;
    public String endDate;
}

public class App {
    public static void main(String[] args) {
        InputStream keyboard = System.in;
        Scanner keyScan = new Scanner(keyboard);

        Team[] team = new Team[100];

        for(int i = 0; i < 3; i++) {
            team[i] = new Team();

            System.out.print("팀명? ");
            team[i].name = sc.nextLine();
            
            System.out.print("설명? ");
            team[i].description = sc.nextLine();

            System.out.print("최대인원? ");
            team[i].maxQty = sc.nextInt();
                    sc.nextLine();

            System.out.print("시작일? ");
            team[i].startDate = sc.nextLine();

            System.out.print("종료일? ");
            team[i].endDate = sc.nextLine();

           
        }

        System.out.println("--------------------------------");

        for(int i =0; i < 3; i++) {
            System.out.printf("%s, %d명, %s ~ %s\n",
              team[i].name, team[i].maxQty, team[i].startDate, team[i],endDate);
        }

        
            
    }
}
// 3단계 끝



// 4단계 : 조건문 적용
packabe bitcamp.java106.pms.domain; // 이것은 domain

import bitcamp.java106.pms.domain.Team;
import java.io.InputStream;
import java.util.Scanner;

// 메모리 설계도 만든다. (메모리 설계도 = 클래스, 만든다. = 정의한다.)
// 참고로 Team.java 따로 만들어서 넣는다. (domain 폴더에 만들어서 넣기)
public class Team { // public 부분 : modifier이라 부른다.
                    // modifier : 원래의 특징이나 성질을 변경
    public String name;   
    public String description;
    public int maxQty;
    public String startDate;
    public String endDate;
}

public class App {
    public static void main(String[] args) {
        InputStream keyboard = System.in;
        Scanner keyScan = new Scanner(keyboard);

        Team[] team = new Team[100];
        int count = 0;

        for(int i = 0; i < teams.length; i++) {
            count++;

            team[i] = new Team();

            System.out.print("팀명? ");
            team[i].name = sc.nextLine();
            
            System.out.print("설명? ");
            team[i].description = sc.nextLine();

            System.out.print("최대인원? ");
            team[i].maxQty = sc.nextInt();
                    sc.nextLine();

            System.out.print("시작일? ");
            team[i].startDate = sc.nextLine();

            System.out.print("종료일? ");
            team[i].endDate = sc.nextLine();

            if(count == teams.length) { // i == teams.length -1 도 조건 됨
                break;
            }

            System.out.print("계속하시겠습니까?(Y/n) ");
            String str = keyScan.nextLine();

            if(str.toLowerCase().equals("n")) { // 대 소문자 구분 없이 비교
                break;  // 반복문 탈출!!
            }
           
        }

        System.out.println("--------------------------------");

        for(int i =0; i < count; i++) {
            System.out.printf("%s, %d명, %s ~ %s\n",
              team[i].name, team[i].maxQty, team[i].startDate, team[i],endDate);
        }

        
            
    }
}
// 4단계 끝


코드 컴파일
> javac -encoding UTF-8 -d bin -sourcepath src/main/java 
src/main/java/bitcamp/java106/pms/App.java

-sourcepath "root 경로" "컴파일할 java main 파일"

코드 실행
> java -cp bin bitcamp.java106.pms.App
*/