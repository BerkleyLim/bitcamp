package bitcamp.java106.pms; // java폴더가 루트

import java.io.InputStream;
import java.nio.channels.MembershipKey;
import java.util.Scanner;
import bitcamp.java106.pms.domain.*;    // 모든 클래스 포함

// ver0.5 - member/add,list,view 명령어를 처리하는 코드를 메서드로 분리한다.
// ver0.4 - team/add,list,view 명령어를 처리하는 코드를 메서드로 분리한다.
// ver0.3 - help 명령어를 처리하는 코드를 메서드로 분리한다.
// ver0.2 - quit 명렁어를 처리하는 코드를 메서드로 분리한다.
// ver0.1 - 명령어를 입력 받는 코드를 메서드로 분리한다.
public class App {
    // 클래스 정의
    private static Team[] teams = new Team[1000];
    private static int teamCount = 0;  // 팀 입력 횟수
    private static Member[] members = new Member[1000];
    private static int memberCount = 0;  // 맴버 입력 횟수
    private static String option = null;   // 이것은 view 명령어의 횟수로 지정

    // 클래스 변수 = 스태틱 변수
    // => 클래스 안에서 어디에서나 사용할 수 있는 변수이다.
    private static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        // 변수 정의(생성자용)
        //int name, description, maxQty, startDate, endDate;
        //int id, email, password;
        
        while(true) {
            String[] arr = prompt();

            String csc = arr[0];
            
            // 이것은 view에서 검색 부분, 즉 팀명 or 아이디명 검색용으로
            if(arr.length >= 2) {
                option = arr[1];
            }

            if(csc.equals("help")) {      // 1) 명령어 정보
                onHelp();
            } else if(csc.equals("quit")) { // 2) 종료 버튼 누를 시.
                onQuit();
            } else if(csc.equals("team/add")) { // 4) 팀 생성 명령어
                onTeamAdd();
            } else if(csc.equals("team/list")) { // 5) 팀 정보 간단 출력
                onTeamList();
            } else if(csc.equals("team/view")) { // 6) 해당 팀 상세정보 출력
                onTeamView();
            } else if (csc.equals("member/add")) { // 7) 회원 생성 명령어
                onMemberAdd();
            } else if(csc.equals("member/list")) { // 8) 회원 정보 간단 출력
                onMemberList();
            } else if(csc.equals("member/view")) { // 9) 해당 회원 상세정보 출력
                onMemberView();
            } else {    // 3) 명령어 잘 못 입력 시
                System.out.println("명령어를 잘 못 입력 했습니다.");
            }

            System.out.println();
        }
    }

    // 명령 프롬프트
    private static String[] prompt() {
        System.out.print("명령> ");
        return sc.nextLine().toLowerCase().split(" ");
    }

    // 종료 명령
    private static void onQuit() {
        System.out.println("안녕히 가세요!");
        System.exit(0);
    }

    // 도움말 명령
    private static void onHelp() {
        System.out.println("팀 등록 명령 : team/add");
        System.out.println("팀 조회 명령 : team/list");
        System.out.println("팀 상세조회 명령 : team/view 팀명");
        System.out.println("회원 등록 명령 : member/add");
        System.out.println("회원 조회 명령 : member/list");
        System.out.println("회원 상세조회 명령 : member/view 아이디");
        System.out.println("종료 : quit");
    }

    // 팀 추가 명령어
    private static void onTeamAdd() {
        Team team = new Team(); // 또 다른 임시 객체 생성

        System.out.print("팀명? ");
        team.setName(sc.nextLine());

        System.out.print("설명? ");
        team.setDescription(sc.nextLine());

        System.out.print("인원수? ");
        team.setMaxQty(sc.nextLine());

        System.out.print("시작일? ");
        team.setStartDate(sc.nextLine());

        System.out.print("종료일? ");
        team.setEndDate(sc.nextLine());

        teams[teamCount++] = team;   
        // 월래 팀에 저장할 클래스 배열에 저장
    }

    // 팀 정보 조회
    private static void onTeamList() {
        for(int i =0; i < teamCount; i++) {
            System.out.println(teams[i].getName() + ", " +
                teams[i].getMaxQty() + ", " + teams[i].getStartDate() +
                " ~ " + teams[i].getEndDate());
        }
    }

    // 해당 팀 상세조회
    private static void onTeamView() {
        // team/view만 입력한 경우
        if(option == null) {
            System.out.println("팀명을 입력하세요.");
            System.out.println();
            return; // 값을 리턴하면 안되기 때문에 return 명령만 작성
                    // 의미? 즉시 메서드 실행을 멈추고 이전 위치로 돌아간다.
        }

        Team team = null;

        // 반복문으로 색인하여 팀명과 일치한 경우와 일치하지 않은 경우
        for(int i = 0; i < teamCount; i++) {
            // 일치한 경우
            if(option.equals(teams[i].getName().toLowerCase())) {
                team = teams[i];
                break;
            }
        }

        if(team == null) {
            System.out.println("해당 이름을 갖는 팀이 없습니다.");
        } else {
            System.out.println("팀명 : " + team.getName());
            System.out.println("설명 : " + team.getDescription());
            System.out.println("최대인원 : " + team.getMaxQty());
            System.out.println("기간 : " + team.getStartDate()
            + " ~ " + team.getEndDate());
        }
    }

    // 회원 추가
    private static void onMemberAdd() {
        Member member = new Member(); // 또 다른 임시 객체 생성

        System.out.print("아이디? ");
        member.setID(sc.nextLine());

        System.out.print("이메일? ");
        member.setEmail(sc.nextLine());

        System.out.print("암호? ");
        member.setPassWord(sc.nextLine());

        members[memberCount++] = member;  
        // 월래 팀에 저장할 클래스 배열에 저장
    }

    // 회원 정보 조회
    private static void onMemberList() {
        for(int i =0; i < memberCount; i++) {
            System.out.println(members[i].getID() + ", "
             + members[i].getEmail() + ", " + members[i].getPassWord());
        }
    }

    // 해당 회원 상세조회
    private static void onMemberView() {
        // team/view만 입력한 경우
        if(option == null) {
            System.out.println("아이디를 입력하세요.");
            System.out.println();
            return;
        }

        Member member = null;

        // 반복문으로 색인하여 팀명과 일치한 경우와 일치하지 않은 경우
        for(int i = 0; i < memberCount; i++) {
            // 일치한 경우
            if(option.equals(members[i].getID().toLowerCase())) {
                member = members[i];
                break;
            }
        }

        if(member == null) {
            System.out.println("해당 이름을 갖는 아이디가 없습니다.");
        } else {
            System.out.println("아이디 : " + member.getID());
            System.out.println("이메일 : " 
                        + member.getEmail());
            System.out.println("암호 : " 
                        + member.getPassWord());
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
