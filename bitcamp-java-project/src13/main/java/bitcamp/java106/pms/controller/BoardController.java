// 컨트롤러가 작업하는데 필요한 객체를 반드시 준비하도록 생성자를 추가한다.
// => 생성자를 통해 필수 입력 값을 반드시 설정하도록 강제시킬 수 있다.
// => 즉 생성자란, 객체를 사용 하기 전에 유효한 값으로 설정하게 만드는 문법이다.
package bitcamp.java106.pms.controller;

import java.util.Scanner;
import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.util.Console;
import java.sql.Date;

public class BoardController {
    private Board[] boards = new Board[1000]; // board 클래스 정의
    private Scanner keyScan;
    private static int boardCount = 0;  // 이것은 정보 입력 횟수를 나타냄
    //private static int index;
   
    
    public BoardController(Scanner keyScan) {
        // BoardController의 메서드를 이용하려면 반드시 설정해야 하는 값이 있다.
        // Board[] 배열이나 boardIndex 처럼 내부에서 생성하는 값이 있고,
        // Scanner 처럼 외부에서 받아야 하는 값이 있다.
        // 외부에서 반드시 받아야 하는 값은 생성자를 통해 입력 받도록 하면 된다.
        // 이것이 생성자가 필요한 이유이다.
        // 즉 객체가 작업하는데 필수적으로 요구되는 값을 준비시키는 역할을 수행하는 게
        // 바로 "생성자"이다.
        this.keyScan = keyScan;
    }

    // 메뉴 선택 모드
    public void service(String menu, String option) {
        // 이 명령어는 보드 추가
        if (menu.equals("board/add")) {
            this.onBoardAdd();

          // 여기는 리스트 추가!
        } else if (menu.equals("board/list")) {
            this.onBoardList();

          // 여기는 상세 정보 
        } else if (menu.equals("board/view")) {
            this.onBoardView(option);

          // 여기는 갱신 명령어
        } else if (menu.equals("board/update")) {
            this.onBoardUpdate(option);

          // 여기는 삭제 명령어
        } else if (menu.equals("board/delete")) {
            this.onBoardDelete(option);

        } else {
            System.out.println("명령어가 올바르지 않습니다.");
        }
    }

    // 같은 패턴의 반복문을 따로 저장
    private int getBoardIndex(String title) {
        for(int i = 0; i < boardCount; i++) {
            if(this.boards[i] == null) continue; // 이 조건은 delete시 실행하지 않는다
            try {
                if(Integer.parseInt(title) == i) {
                    return i;
                }
            } catch(Exception e) { 
                return -1;
            }

        }
        return -1;
    }

    // 추가 명령어
    private void onBoardAdd() {
        String title, detail;
        Date register;    // 임시 변수 생성
        System.out.println("[게시글 등록]");
        System.out.print("제목? ");
        title = this.keyScan.nextLine();

        System.out.print("내용? ");
        detail = this.keyScan.nextLine();

        System.out.print("등록일? ");
        register = Date.valueOf(this.keyScan.nextLine());

        // 임시 객체 생성
        Board board = new Board(title, detail, register);
        
        this.boards[boardCount++] = board; // 최종적으로 진짜 객체에 저장
    }

    // 보드 리스트 출력
    private void onBoardList() {
        System.out.println("[게시글 목록]");
        for(int i = 0; i < boardCount; i++) {
            if(this.boards[i] == null) continue;
            System.out.println(i + ", " + this.boards[i].getTitle() 
                + ", " + this.boards[i].getRegister());
        }
    } 

    // 해당 보드 상세히 출력
    private void onBoardView(String option) {
        System.out.println("[게시글 조회]");
        // 제목을 입력 받아라.
        if(option == null) {
            System.out.println("제목을 입력하세요");
            return;
        }

        int i = this.getBoardIndex(option);

        if(i == -1) {
            System.out.println("제목을 찾을 수 없습니다.");
        } else {
            System.out.println("제목 : " + this.boards[i].getTitle());
            System.out.println("내용 : " + this.boards[i].getDetail());
            System.out.println("등록일 : " + this.boards[i].getRegister());
        }
    }

    // 게시글 갱신
    private void onBoardUpdate(String option) {
        System.out.println("[게시글 변경]");

        if(option == null) {
            System.out.println("제목을 입력하세요.");
            return;
        }

        int i = this.getBoardIndex(option);

        if(i == -1) {
            System.out.println("해당 제목이 일치하지 않습니다.");
        } else {
            String title, detail;

            System.out.printf("제목(%s)? ", boards[i].getTitle());
            title = this.keyScan.nextLine();

            System.out.printf("내용(%s)? ", boards[i].getDetail());
            detail = this.keyScan.nextLine();

            // 임시 객체 생성
            Board board = new Board(title, detail, this.boards[i].getRegister());

            this.boards[i] = board;            
        }
    }

    private void onBoardDelete(String option) {
        System.out.println("[게시글 삭제]");

        if(option == null) {
            System.out.println("삭제할 게시물을 입력하세요.");
            return;
        }

        int i = this.getBoardIndex(option);

        if(i == -1) {
            System.out.println("삭제할 게시물이 없습니다.");
        } else {
            if(Console.confirm("정말 삭제하시겠습니까?")) {
                this.boards[i] = null;
                System.out.println("삭제하였습니다.");
            }
        }
    }
    
}


/*
C:\Users\Bit\git\bitcamp\bitcamp-java-project>java -cp bin bitcamp.java106.pms.App
명령> board/add
[게시글 등록]
제목? 1
내용? 2
등록일? 3

명령> board/view aa
[게시글 조회]
제목을 찾을 수 없습니다.

명령> board/view 1
[게시글 조회]
제목을 찾을 수 없습니다.

명령> board/view 0
[게시글 조회]
제목 : 1
내용 : 2
등록일 : 3

명령> board/add
[게시글 등록]
제목? goda
내용? alskem
등록일? 2011-1-1

명령> board/add
[게시글 등록]
제목? lsa
내용? minister
등록일? 2018-1-1

명령> board/list
[게시글 목록]
0, 1, 3
1, goda, 2011-1-1
2, lsa, 2018-1-1

명령> board/view goda
[게시글 조회]
제목을 찾을 수 없습니다.

명령> board/view 1
[게시글 조회]
제목 : goda
내용 : alskem
등록일 : 2011-1-1

명령> board/update 1
[게시글 변경]
제목(goda)? 제목2
내용(alskem)? 내용2

명령> board/view 1
[게시글 조회]
제목 : 제목2
내용 : 내용2
등록일 : 2011-1-1

명령> board/delete 1
[게시글 삭제]
정말 삭제하시겠습니까? (Y/N)n

명령> board/list
[게시글 목록]
0, 1, 3
1, 제목2, 2011-1-1
2, lsa, 2018-1-1

명령> board/delete 1
[게시글 삭제]
정말 삭제하시겠습니까? (Y/N)y
삭제하였습니다.

명령> board/list
[게시글 목록]
0, 1, 3
2, lsa, 2018-1-1

명령> quit
안녕히 가세요!
*/