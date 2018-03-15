package bitcamp.java106.pms; // java폴더가 루트

import java.util.Scanner;
import bitcamp.java106.pms.domain.*;    // 모든 클래스 포함

// ver0.2 - 사용자에게 yes/no를 묻는 코드를 메서드로 분리한다.
//          => confirm() 추가
// ver0.1 - 팀명으로 배열에서 팀 정보를 찾는 코드를 함수로 분리한다. 
//          => getTeamIndex() 추가
//          회원 아이디로 배열에서 회원 정보를 찾는 코드를 함수로 분리한다.
//          => getMemberIndex() 추가
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

            String csc = arr[0]; // case by case : 이 경우 어떤 명령어를 입력했을
                                // 시의 대해 
            option = null;
            // 이것은 view에서 검색 부분, 즉 팀명 or 아이디명 검색용으로
            if(arr.length >= 2) {
                option = arr[1];
            }


            if(csc.equals("help") && option == null) {      // 1) 명령어 정보
                onHelp();
            } else if(csc.equals("quit")
                            && option == null) { // 2) 종료 버튼 누를 시.
                onQuit();
            } else if(csc.equals("team/add")
                            && option == null) { // 4) 팀 생성 명령어
                onTeamAdd();
            } else if(csc.equals("team/list")
                            && option == null) { // 5) 팀 정보 간단 출력
                onTeamList();
            } else if(csc.equals("team/view")) { // 6) 해당 팀 상세정보 출력
                onTeamView();
            } else if (csc.equals("member/add")
                            && option == null) { // 7) 회원 생성 명령어
                onMemberAdd();
            } else if(csc.equals("member/list")
                            && option == null) { // 8) 회원 정보 간단 출력
                onMemberList();
            } else if(csc.equals("member/view")) { // 9) 해당 회원 상세정보 출력
                onMemberView();

                // 여기서부터 유지보수 시작!!
            } else if(csc.equals("team/update")) { // 10) 팀 정보 수정
                onTeamUpdate();
            } else if(csc.equals("team/delete")) { // 11) 팀 정보 삭제
                onTeamDelete();
            } else if(csc.equals("member/update")) { // 12) 회원 정보 수정
                onMemberUpdate();
            } else if(csc.equals("member/delete")) { // 12) 회원 정보 삭제
                onMemberDelete();
            } else {    // 3) 명령어 잘 못 입력 시
                System.out.println("명령어를 잘 못 입력 했습니다.");
            }

            System.out.println();
            
        }
    }

    private static int getTeamIndex(String name) {
        for(int i = 0; i < teamCount; i++) {
            if(teams[i] == null) continue;
            if(name.equals(teams[i].getName().toLowerCase())) {
                return i;
            }
        }
        return -1;
    }

    private static int getMemberIndex(String id) {
        for(int i = 0; i < memberCount; i++) {
            if(members[i] == null) continue;
            if(id.equals(members[i].getID().toLowerCase())) {
                return i;
            }
        }
        return -1;
    }

    // 조건식 yes/no
    private static boolean confirm(String message) {
        System.out.printf("%s (Y/N)", message);
        String input = sc.nextLine().toLowerCase();
        if (input.equals("y"))
            return true;
        else 
            return false;
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
        // 유지보수 추가
        System.out.println("팀 정보 수정 : team/update");
        System.out.println("팀 정보 삭제 : team/delete");
        System.out.println("맴버 정보 수정 : member/update");
        System.out.println("맴버 정보 삭제 : member/delete");
        System.out.println("종료 : quit");
    }

    // 팀 추가 명령어
    private static void onTeamAdd() {
        String name, description, maxQty, startDate, endDate; // 임시 저장 변수
        

        System.out.print("팀명? ");
        name = sc.nextLine();
        
        System.out.print("설명? ");
        description = sc.nextLine();
       
        System.out.print("인원수? ");
        maxQty = sc.nextLine();
        
        System.out.print("시작일? ");
        startDate = sc.nextLine();
        
        System.out.print("종료일? ");
        endDate = sc.nextLine();

        // 임시 객체 생성
        Team team = new Team(name, description,maxQty,
            startDate, endDate); // 또 다른 임시 객체 생성
        
        team.setName(name);
        team.setDescription(description);
        team.setMaxQty(maxQty);
        team.setStartDate(startDate);
        team.setEndDate(endDate);

        // 임시 객체 생성후 저장
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

        int i = getTeamIndex(option);

        if(i == -1) {
            System.out.println("해당 이름을 갖는 팀이 없습니다.");
        } else {
            Team team = teams[i];
            System.out.println("팀명 : " + team.getName());
            System.out.println("설명 : " + team.getDescription());
            System.out.println("최대인원 : " + team.getMaxQty());
            System.out.println("기간 : " + team.getStartDate()
            + " ~ " + team.getEndDate());
        }
    }

    // 회원 추가
    private static void onMemberAdd() {
        String id, email, passWord; // 임시 변수 지정
        
        System.out.print("아이디? ");
        id = sc.nextLine();

        System.out.print("이메일? ");
        email = sc.nextLine();

        System.out.print("암호? ");
        passWord = sc.nextLine();

        // 또 다른 임시 객체 생성
        Member member = new Member(); 
        member.setID(id);
        member.setEmail(email);
        member.setPassWord(passWord);

        // 임시 객체에 저장 한 것을 월래 배열에 저장
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

    
        int i = getMemberIndex(option);
        
        if(i == -1) {
            System.out.println("해당 이름을 갖는 아이디가 없습니다.");
        } else {
            Member member = members[i];
            System.out.println("아이디 : " + member.getID());
            System.out.println("이메일 : " 
                        + member.getEmail());
            System.out.println("암호 : " 
                        + member.getPassWord());
            System.out.println();
        }
    }

    // ----------------------------------------------
    // 유지보수 추가

    // 팀 정보 수정
    private static void onTeamUpdate() {
        // 팀명을 입력하지 않았을 때,
        if(option == null) {
            System.out.println("팀명을 입력하세요.");
            return;
        }

        int i = getTeamIndex(option);


        if(i == -1) {
            System.out.println("해당 이름의 팀이 없습니다.");
        } else {
            String name, description, maxQty, startDate, endDate;
            
            System.out.printf("팀명(%s)? ", teams[i].getName());
            name = sc.nextLine();
            
            System.out.printf("설명(%s)? ", teams[i].getDescription());
            description = sc.nextLine();
            
            System.out.printf("최대인원(%s)? ", teams[i].getMaxQty());
            maxQty = sc.nextLine();
            
            System.out.printf("시작일(%s)? ", teams[i].getStartDate());
            startDate = sc.nextLine();
            
            System.out.printf("종료일(%s)? ", teams[i].getEndDate());
            endDate = sc.nextLine();
            
            // 임시 객체 변수 - try catch문을 사용 했을 때 대비해서
            Team team = new Team(name, description, maxQty, startDate,
                            endDate);
            team.setName(name);
            team.setDescription(description);
            team.setMaxQty(maxQty);
            team.setStartDate(startDate);
            team.setEndDate(endDate);
            
            teams[i] = team;

            System.out.println("변경하였습니다.");

            return;
        }

    }

    // 팀 정보 삭제
    private static void onTeamDelete() {
        if(option == null) {
            System.out.println("팀을 입력하세요.");
            return;
        }

        int i = getTeamIndex(option);
        // 먼저 해당 아이디 색인

        if(i == -1) {
            System.out.println("해당 이름의 팀이 없습니다.");
        } else {
            if(confirm("정말 삭제하시겠습니까?")) {
                teamCount--;
                while(i < teamCount) {
                    teams[i] = teams[i+1];
                    i++;
                }
                teams[teamCount+1] = null;
            }
        }
    }

    // 회원 정보 수정
    private static void onMemberUpdate() {
        // 회원명을 입력하지 않았을 때,
        if(option == null) {
            System.out.println("회원명을 입력하세요.");
            return;
        }

        int i = getMemberIndex(option);

        if(i == memberCount) {
            System.out.println("해당 회원이 없습니다.");
        } else {
            String id, email, passWord;
            System.out.printf("아이디(%s)? ", members[i].getID());
            id = sc.nextLine();
            
            System.out.printf("이메일(%s)? ", members[i].getEmail());
            email = sc.nextLine();
            
            System.out.printf("암호(%s)? ", members[i].getPassWord());
            passWord = sc.nextLine();

            // member 임시 객체 만들어서 최종적으로 원 members에 저장
            // try ~ catch문 사용하고, 유지보수를 위해 만든다.
            Member member = new Member(id, email, passWord);
            member.setEmail(email);
            member.setID(id);
            member.setPassWord(passWord);
            
            members[i] = member;

            System.out.println("변경하였습니다.");
            return;
        }
    }

    // 회원 정보 삭제
    private static void onMemberDelete() {
        if(option == null) {
            System.out.println("아이디를 입력하세요.");
            return;
        }

        int i = getMemberIndex(option);

        if(i == -1) {
            System.out.println("해당 아이디가 없습니다.");
        } else {
            if(confirm("정말 삭제하시겠습니까?")) {
                memberCount--;
                while(i < memberCount) {
                    members[i] = members[i+1];
                    i++;
                }
                members[memberCount+1] = null;
            }
        }
    }
}

/*
C:\Users\Bit\git\bitcamp\bitcamp-java-project>java -classpath bin bitcamp.java106.pms.App
명령> member/add
아이디? aal
이메일? 1
암호? 3

명령> member/add
아이디? eeel
이메일? al
암호? 33

명령> member/delete
아이디를 입력하세요.

명령> member/delete 11
해당 이름의 팀이 없습니다.

명령> member/list
aal, 1, 3
eeel, al, 33

명령> member/delete aal
정말 삭제하시겠습니까?(Y/N)Y

명령> member/list
eeel, al, 33

명령>
C:\Users\Bit\git\bitcamp\bitcamp-java-project>java -cp bin bitcamp.java106.pms.App
명령> help
팀 등록 명령 : team/add
팀 조회 명령 : team/list
팀 상세조회 명령 : team/view 팀명
회원 등록 명령 : member/add
회원 조회 명령 : member/list
회원 상세조회 명령 : member/view 아이디
팀 정보 수정 : team/update
팀 정보 삭제 : team/delete
맴버 정보 수정 : member/update
맴버 정보 삭제 : member/delete
종료 : quit

명령> team/add
팀명? 자바자바
설명? 자바 프로그래밍 팀
인원수? 31
시작일? 2018-5-5
종료일? 2018-7-31

명령> team/add
팀명? 안녕히
설명? 끝나는 날
인원수? 100
시작일? 2018-6-31
종료일? 2018-8-30

명령> team/add
팀명? good mort
설명? 반가워요
인원수? 11
시작일? 2018-9-30
종료일? 2018-10-31

명령> team/list
자바자바, 31, 2018-5-5 ~ 2018-7-31
안녕히, 100, 2018-6-31 ~ 2018-8-30
good mort, 11, 2018-9-30 ~ 2018-10-31

명령> team/view "good mort"
해당 이름을 갖는 팀이 없습니다.

명령> team/view good mort
해당 이름을 갖는 팀이 없습니다.

명령>
C:\Users\Bit\git\bitcamp\bitcamp-java-project>java -cp bin bitcamp.java106.pms.App
명령> team/add
팀명? 반가워
설명? 13
인원수? 11
시작일? 18-03-01
종료일? 18-05-04

명령> team/add
팀명? aaaaa
설명? absck
인원수? 13
시작일? 18
종료일? 03

명령> team/add
팀명? makeup
설명? minister
인원수? 31
시작일? 18-09-03
종료일? 18-10-31

명령> team/list
반가워, 11, 18-03-01 ~ 18-05-04
aaaaa, 13, 18 ~ 03
makeup, 31, 18-09-03 ~ 18-10-31

명령> team/view aaaaa
팀명 : aaaaa
설명 : absck
최대인원 : 13
기간 : 18 ~ 03

명령> team/view
팀명을 입력하세요.


명령> team/view 111111
해당 이름을 갖는 팀이 없습니다.

명령> team/update
팀명을 입력하세요.

명령> team/update 13
해당 이름의 팀이 없습니다.

명령> team/update aaaaa
팀명(aaaaa)? 게임반
설명(absck)? 게임 제작하는 반
최대인원(13)? 4
시작일(18)? 18-03-04
종료일(03)? 18-05-03

명령> team/list
반가워, 11, 18-03-01 ~ 18-05-04
게임반, 4, 18-03-04 ~ 18-05-03
makeup, 31, 18-09-03 ~ 18-10-31

명령> team/view 게임반
팀명 : 게임반
설명 : 게임 제작하는 반
최대인원 : 4
기간 : 18-03-04 ~ 18-05-03

명령> team/delete
팀을 입력하세요.

명령> team/delete aaaaa
해당 이름의 팀이 없습니다.

명령> team/delete makeup
정말 삭제하시겠습니까?(Y/N)n
해당 이름의 팀이 없습니다.

명령> team
C:\Users\Bit\git\bitcamp\bitcamp-java-project>javac -encoding utf-8 -d bin -sourcepath src/main/java src/main/java/bitcamp/java106/pms/App.java

C:\Users\Bit\git\bitcamp\bitcamp-java-project>javac -encoding utf-8 -d bin -sourcepath src/main/java src/main/java/bitcamp/java106/pms/App.java

C:\Users\Bit\git\bitcamp\bitcamp-java-project>java -cp bin bitcamp.java106.pms.App
명령> help
팀 등록 명령 : team/add
팀 조회 명령 : team/list
팀 상세조회 명령 : team/view 팀명
회원 등록 명령 : member/add
회원 조회 명령 : member/list
회원 상세조회 명령 : member/view 아이디
팀 정보 수정 : team/update
팀 정보 삭제 : team/delete
맴버 정보 수정 : member/update
맴버 정보 삭제 : member/delete
종료 : quit

명령> team/list

명령>
C:\Users\Bit\git\bitcamp\bitcamp-java-project>javac -encoding utf-8 -d bin -sourcepath src/main/java src/main/java/bitcamp/java106/pms/App.java

C:\Users\Bit\git\bitcamp\bitcamp-java-project>java -cp bin bitcamp.java106.pms.App
명령> help
팀 등록 명령 : team/add
팀 조회 명령 : team/list
팀 상세조회 명령 : team/view 팀명
회원 등록 명령 : member/add
회원 조회 명령 : member/list
회원 상세조회 명령 : member/view 아이디
팀 정보 수정 : team/update
팀 정보 삭제 : team/delete
맴버 정보 수정 : member/update
맴버 정보 삭제 : member/delete
종료 : quit

명령> team/add
팀명? aaa
설명? 13
인원수? 2
시작일? 1
종료일? 10-3-3

명령> team/add
팀명? 자바106기
설명? 웹/앱 개발자 과정
인원수? 28
시작일? 18-02-26
종료일? 18-08-20

명령> team/add
팀명? classic
설명? 클래식 좋아하는 사람 모임
인원수? 10
시작일? 18-02-02
종료일? 19-02-01

명령> team/list
aaa, 2, 1 ~ 10-3-3
자바106기, 28, 18-02-26 ~ 18-08-20
classic, 10, 18-02-02 ~ 19-02-01

명령> team/view
팀명을 입력하세요.


명령> team/view 11
해당 이름을 갖는 팀이 없습니다.

명령> team/view 자비106기
해당 이름을 갖는 팀이 없습니다.

명령> team/view 자바106기
팀명 : 자바106기
설명 : 웹/앱 개발자 과정
최대인원 : 28
기간 : 18-02-26 ~ 18-08-20

명령> team/update
팀명을 입력하세요.

명령> team/update 11
해당 이름의 팀이 없습니다.

명령> team/update aaa
팀명(aaa)? 비트비트
설명(13)? 자바프로젝트작성
최대인원(2)? 5
시작일(1)? 18-02-02
종료일(10-3-3)? 18-05-05

명령> team/list
비트비트, 5, 18-02-02 ~ 18-05-05
자바106기, 28, 18-02-26 ~ 18-08-20
classic, 10, 18-02-02 ~ 19-02-01

명령> team/view 비트비트
팀명 : 비트비트
설명 : 자바프로젝트작성
최대인원 : 5
기간 : 18-02-02 ~ 18-05-05

명령> member/add
아이디? mysoul
이메일? mysoul@test.com
암호? wish

명령> member/add
아이디? july
이메일? july@music.com
암호? cash

명령> member/add
아이디? 11
이메일? 3
암호? 2

명령> member/list
mysoul, mysoul@test.com, wish
july, july@music.com, cash
11, 3, 2

명령> member/view
아이디를 입력하세요.


명령> member/view 1133
해당 이름을 갖는 아이디가 없습니다.

명령> member/view mysoul
아이디 : mysoul
이메일 : mysoul@test.com
암호 : wish


명령> member/view 11
아이디 : 11
이메일 : 3
암호 : 2


명령> member/update
회원명을 입력하세요.

명령> member/update 13
해당 회원이 없습니다.

명령> member/update 11
아이디(11)? chopin
이메일(3)? chopin@classic.com
암호(2)? chopinlove

명령> member/list
mysoul, mysoul@test.com, wish
july, july@music.com, cash
chopin, chopin@classic.com, chopinlove

명령> member/view chopin
아이디 : chopin
이메일 : chopin@classic.com
암호 : chopinlove


명령> member/delete
아이디를 입력하세요.

명령> member/delete 1
해당 아이디가 없습니다.

명령> member/delete mysoul
정말 삭제하시겠습니까?(Y/N)n

명령> member/list
mysoul, mysoul@test.com, wish
july, july@music.com, cash
chopin, chopin@classic.com, chopinlove

명령> member/delete mysoul
정말 삭제하시겠습니까?(Y/N)y

명령> member/list
july, july@music.com, cash
chopin, chopin@classic.com, chopinlove

명령> help
팀 등록 명령 : team/add
팀 조회 명령 : team/list
팀 상세조회 명령 : team/view 팀명
회원 등록 명령 : member/add
회원 조회 명령 : member/list
회원 상세조회 명령 : member/view 아이디
팀 정보 수정 : team/update
팀 정보 삭제 : team/delete
맴버 정보 수정 : member/update
맴버 정보 삭제 : member/delete
종료 : quit

명령> good
명령어를 잘 못 입력 했습니다.

명령> quit
안녕히 가세요!


*/
