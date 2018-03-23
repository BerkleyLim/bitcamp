package bitcamp.java106.pms; // java폴더가 루트

import java.util.Scanner;

import bitcamp.java106.pms.controller.BoardController;
import bitcamp.java106.pms.controller.MemberController;
import bitcamp.java106.pms.controller.TeamController;
import bitcamp.java106.pms.controller.TeamMemberController;
import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.util.Console;

public class App {
    // 클래스 정의
    private static Scanner keyScan = new Scanner(System.in);

    private static String option = null;   // 이것은 view 명령어의 횟수로 지정

    public static void main(String[] args) {
        // 클래스를 사용하기 전에 필수값을 설정
        TeamDao teamDao = new TeamDao();
        MemberDao memberDao = new MemberDao();

        TeamController teamController = new TeamController(keyScan);
        MemberController memberController = new MemberController(keyScan, memberDao);
        BoardController boardController = new BoardController(keyScan);
        TeamMemberController teamMemberController 
            = new TeamMemberController(keyScan, teamDao, memberDao);
       
        
        Console console = new Console(keyScan);
        
        while(true) {
            String[] arr = console.prompt();

            String menu = arr[0]; // case by case : 이 경우 어떤 명령어를 입력했을
                                // 시의 대해 
            option = null;


            // 이것은 view에서 검색 부분, 즉 팀명 or 아이디명 검색용으로
            if(arr.length >= 2) {
                option = arr[1];
            }

            if(menu.equals("help") && option == null) {   // 1) 명령어 정보
                onHelp();
            } else if(menu.equals("quit")
                            && option == null) { // 2) 종료 버튼 누를 시.
                onQuit();
            } else if(menu.startsWith("team/member/")) {
                teamMemberController.service(menu, option);
                
            } else if(menu.startsWith("team/")){ // startsWith("prefix")
                                            // 이것은 처음 친 값만 추출
                teamController.service(menu, option);
           
            } else if(menu.startsWith("member/")) {
                memberController.service(menu, option);

            } else if(menu.startsWith("board/")) {
                boardController.service(menu, option);

            } else {    // 3) 명령어 잘 못 입력 시
                System.out.println("명령어를 잘 못 입력 했습니다.");
            }

            System.out.println();
            
        }
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
        System.out.println("팀 정보 수정 : team/update");
        System.out.println("팀 정보 삭제 : team/delete");
        
        System.out.println("회원 등록 명령 : member/add");
        System.out.println("회원 조회 명령 : member/list");
        System.out.println("회원 상세조회 명령 : member/view 아이디");
        System.out.println("맴버 정보 수정 : member/update");
        System.out.println("맴버 정보 삭제 : member/delete");

        System.out.println("게시판 등록 명령 : board/add");
        System.out.println("게시판 조회 명령 : board/list");
        System.out.println("게시판 상세조회 명령 : board/view 인덱스명");
        System.out.println("게시판 정보 수정 명령 : board/update 인덱스명");
        System.out.println("게시판 정보 삭제 명령 : board/delete 인덱스명");
        System.out.println("종료 : quit");
    }


}

// 

/*
C:\Users\Bit\git\bitcamp\bitcamp-java-project>java -cp bin bitcamp.java106.pms.App
명령> help
팀 등록 명령 : team/add
팀 조회 명령 : team/list
팀 상세조회 명령 : team/view 팀명
팀 정보 수정 : team/update
팀 정보 삭제 : team/delete
회원 등록 명령 : member/add
회원 조회 명령 : member/list
회원 상세조회 명령 : member/view 아이디
맴버 정보 수정 : member/update
맴버 정보 삭제 : member/delete
게시판 등록 명령 : board/add
게시판 조회 명령 : board/list
게시판 상세조회 명령 : board/view 인덱스명
게시판 정보 수정 명령 : board/update 인덱스명
게시판 정보 삭제 명령 : board/delete 인덱스명
종료 : quit

명령> quit
안녕히 가세요!

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
