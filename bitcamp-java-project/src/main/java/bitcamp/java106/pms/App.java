package bitcamp.java106.pms; // java폴더가 루트

import java.io.InputStream;
import java.util.Scanner;
import bitcamp.java106.pms.domain.*;    // 모든 클래스 포함

public class App {
    public static void main(String[] args) {
        InputStream keyboard = System.in;
        Scanner sc = new Scanner(System.in);
        String casebycase = "";  // 명령어 입력 값 저장

        // 0) 미리 Team / ID 클래스를 만들고,
        //    Team의 인터페이스 TeamInput, 
        //    ID의 인터페이스 IDInput를 만든 후
        //    클래스 정의한다!!
        Team[] t = new Team[1000];
        ID[] i = new ID[1000];

        // 아이디 카운터 및 팀 카운터
        int idCount = 0;
        int teamCount = 0;

        // 팀의 대한 저장용 변수 선언
        String team, description, maxQty, startDate, endDate;
        // 아이디의 대한 저장용 변수 선언
        String id, email, passWord;

        // 1) 무한루프
        while(true) {

            // 2) 처음부터 끝까지 조건을 입력
            System.out.print("명령> ");
            casebycase = sc.nextLine();

            // 3) 다음 조건문 구성하기
            if(casebycase.equals("help")) {
                // 6) help 입력 수행
                System.out.println("팀 등록 명령 : team/add");
                System.out.println("팀 조회 명령 : team/list");
                System.out.println("팀 상세조회 명령 : team/view 팀명");
                System.out.println("회원 등록 명령 : member/add");
                System.out.println("회원 조회 명령 : member/list");
                System.out.println("회원 상세조회 명령 : member/view 아이디");
                System.out.println("종료 : quit");
                System.out.println();
            } else if(casebycase.equals("team/add")) {
                // 7) team/add 명령어 수행
                System.out.print("팀명? ");
                team = sc.nextLine();

                System.out.print("설명? ");
                description = sc.nextLine();

                System.out.print("최대인원? ");
                maxQty = sc.nextLine();

                System.out.print("시작일? ");
                startDate = sc.nextLine();

                System.out.print("종료일? ");
                endDate = sc.nextLine();

                // 클래스 생성
                t[teamCount] = new Team(team, description, 
                            maxQty, startDate, endDate);

                // 먼저 변수 지정
                t[teamCount].setTeam(team);
                t[teamCount].setDescription(description);
                t[teamCount].setMaxQty(maxQty);
                t[teamCount].setStartDate(startDate);
                t[teamCount].setEndDate(endDate);

                teamCount++;

            } else if(casebycase.equals("team/list")) {
                // 8) team/list 명령어 수행
                for(int ir = 0; ir < teamCount; ir++){
                    System.out.println(t[ir].getTeam() + ", " + 
                      t[ir].getMaxQty() + ", " + t[ir].getStartDate()
                      + " ~ " + t[ir].getEndDate());                 
                }

            } else if(casebycase.contains("team/view")) {
                // 11) team/view 팀명 명령어 수행

                // 팀명을 입력하시기 바랍니다.
                if(casebycase.equals("team/view")) {
                    System.out.println("팀명을 입력하시기 바랍니다.");
                    System.out.println();
                    continue;
                } 
                int ir = 0;
                while(ir < teamCount) {
                    if(casebycase.contains(t[ir].getTeam())) {
                        System.out.println("팀명: " + t[ir].getTeam());
                        System.out.println("설명: " + t[ir].getDescription());
                        System.out.println("최대인원: " + t[ir].getMaxQty());
                        System.out.println("기간: " + t[ir].getStartDate()
                             + " ~ " + t[ir].getEndDate()); 
                        System.out.println();

                        break;    
                    }
                    ir++;
                }

                if(ir == teamCount) {
                    System.out.println("해당 이름을 갖는 팀이 없습니다.");
                }


            } else if(casebycase.equals("member/add")) {
                // 9) team/view 팀명 명령어 수행
                System.out.print("아이디? ");
                id = sc.nextLine();

                System.out.print("이메일? ");
                email = sc.nextLine();

                System.out.print("암호? ");
                passWord = sc.nextLine();

                i[idCount] = new ID(id, email, passWord);

                idCount++;

            } else if(casebycase.equals("member/list")) {
                // 10) team/view 팀명 명령어 수행
                for(int ir = 0; ir < idCount; ir++) {
                    System.out.println(i[ir].getID() + ", " +
                        i[ir].getEmail() + ", " + i[ir].getPassWord());
                }
                
            } else if(casebycase.contains("member/view")) {
                // 12) member/view 팀명 명령어 수행

                // 팀명을 입력하시기 바랍니다.
                if(casebycase.equals("member/view")) {
                    System.out.println("아이디를 입력하시기 바랍니다.");
                    System.out.println();
                    continue;
                } 
                int ir = 0;
                while(ir < idCount) {
                    if(casebycase.contains(i[ir].getID())) {
                        System.out.println("아이디: " + i[ir].getID());
                        System.out.println("이메일: " + i[ir].getEmail());
                        System.out.println("암호: " + i[ir].getPassWord());
                        System.out.println();

                        break;    
                    }
                    ir++;
                }

                if(ir == idCount) {
                    System.out.println("해당 아이디의 회원이 없습니다.");
                }

            } else if(casebycase.equals("quit")) {
                // 13) 만일 quit를 입력했을 경우
                System.out.println("안녕히가세요!");
                System.out.println();
                break;
            } else {
                 // 4) 만일 명령어가 올바르지 않을 경우
                System.out.println("명령어가 올바르지 않습니다.");
                System.out.println();
            }

            System.out.println();
                
        }
    }
}

/*
C:\Users\Bit\git\bitcamp\bitcamp-java-project>java -classpath bin bitcamp.java106.pms.App
명령> help
팀 등록 명령 : team/add
팀 조회 명령 : team/list
팀 상세조회 명령 : team/view 팀명
회원 등록 명령 : member/add
회원 조회 명령 : member/list
회원 상세조회 명령 : member/view 아이디
종료 : quit


명령> team/add
팀명? 비트비트1
설명? 자바 프로젝트 팀 중 한명
최대인원? 5
시작일? 2018-05-05
종료일? 2018-08-20

명령> team/add
팀명? 비트비트2
설명? 자바 프로젝트 팀2
최대인원? 5
시작일? 2018-05-05
종료일? 2018-08-20

명령> team/list
비트비트1, 5, 2018-05-05 ~ 2018-08-20
비트비트2, 5, 2018-05-05 ~ 2018-08-20

명령> team/view 비트비트2
팀명: 비트비트2
설명: 자바 프로젝트 팀2
최대인원: 5
기간: 2018-05-05 ~ 2018-08-20


명령> team/view 비트오케이
해당 이름을 갖는 팀이 없습니다.

명령> team/view
팀명을 입력하시기 바랍니다.

명령> member/add
아이디? hong
이메일? hong@test.com
암호? 1111

명령> member/list
hong, hong@test.com, 1111

명령> member/add
아이디? leem
이메일? leem@test.com
암호? 1111

명령> member/list
hong, hong@test.com, 1111
leem, leem@test.com, 1111

명령> member/view leem
아이디: leem
이메일: leem@test.com
암호: 1111


명령> member/view okok
해당 아이디의 회원이 없습니다.

명령> member/view
아이디를 입력하시기 바랍니다.

명령> memeber/list
명령어가 올바르지 않습니다.


명령> qirus a
명령어가 올바르지 않습니다.


명령> help
팀 등록 명령 : team/add
팀 조회 명령 : team/list
팀 상세조회 명령 : team/view 팀명
회원 등록 명령 : member/add
회원 조회 명령 : member/list
회원 상세조회 명령 : member/view 아이디
종료 : quit


명령> quit
안녕히가세요!

*/