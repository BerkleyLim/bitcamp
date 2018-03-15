package bitcamp.java106.pms.controller;

import java.util.Scanner;
import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.util.Console;


public class BoardController {
    private static Board[] boards = new Board[1000]; // board 클래스 정의
    public static Scanner keyScan = new Scanner(System.in);
    private static int boardCount = 0;  // 이것은 정보 입력 횟수를 나타냄
    private static int index;

    // 메뉴 선택 모드
    public static void service(String menu, String option) {
        // 이 명령어는 보드 추가
        if (menu.equals("board/add")) {
            onBoardAdd();

          // 여기는 리스트 추가!
        } else if (menu.equals("board/list")) {
            onBoardList();

          // 여기는 상세 정보 
        } else if (menu.equals("board/view")) {
            onBoardView(option);

          // 여기는 갱신 명령어
        } else if (menu.equals("board/update")) {
            onBoardUpdate(option);

          // 여기는 삭제 명령어
        } else if (menu.equals("board/delete")) {
            onBoardDelete(option);

        } else {
            System.out.println("명령어가 올바르지 않습니다.");
        }
    }

    // 같은 패턴의 반복문을 따로 저장
    private static int getBoardIndex(String title) {
        for(int i = 0; i < boardCount; i++) {
            if(boards[i] == null) continue; // 이 조건은 delete시 실행하지 않는다
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
    private static void onBoardAdd() {
        String title, detail, register;    // 임시 변수 생성
        System.out.println("[게시글 등록]");
        System.out.print("제목? ");
        title = keyScan.nextLine();

        System.out.print("내용? ");
        detail = keyScan.nextLine();

        System.out.print("등록일? ");
        register = keyScan.nextLine();

        // 임시 객체 생성
        Board board = new Board(title, detail, register);
        board.setTitle(title);
        board.setDetail(detail);
        board.setRegister(register);

        boards[boardCount++] = board; // 최종적으로 진짜 객체에 저장
    }

    // 보드 리스트 출력
    private static void onBoardList() {
        System.out.println("[게시글 목록]");
        for(int i = 0; i < boardCount; i++) {
            if(boards[i] == null) continue;
            System.out.println(i + ", " + boards[i].getTitle() 
                + ", " + boards[i].getRegister());
        }
    } 

    // 해당 보드 상세히 출력
    private static void onBoardView(String option) {
        System.out.println("[게시글 조회]");
        // 제목을 입력 받아라.
        if(option == null) {
            System.out.println("제목을 입력하세요");
            return;
        }

        int i = getBoardIndex(option);

        if(i == -1) {
            System.out.println("제목을 찾을 수 없습니다.");
        } else {
            System.out.println("제목 : " + boards[i].getTitle());
            System.out.println("내용 : " + boards[i].getDetail());
            System.out.println("등록일 : " + boards[i].getRegister());
        }
    }

    // 게시글 갱신
    private static void onBoardUpdate(String option) {
        System.out.println("[게시글 변경]");

        if(option == null) {
            System.out.println("제목을 입력하세요.");
            return;
        }

        int i = getBoardIndex(option);

        if(i == -1) {
            System.out.println("해당 제목이 일치하지 않습니다.");
        } else {
            String title, detail;

            System.out.printf("제목(%s)? ", boards[i].getTitle());
            title = keyScan.nextLine();

            System.out.printf("내용(%s)? ", boards[i].getDetail());
            detail = keyScan.nextLine();

            // 임시 객체 생성
            Board board = new Board(title, detail, boards[i].getRegister());
            board.setTitle(title);
            board.setDetail(detail);

            boards[i] = board;            
        }
    }

    private static void onBoardDelete(String option) {
        System.out.println("[게시글 삭제]");

        if(option == null) {
            System.out.println("삭제할 게시물을 입력하세요.");
            return;
        }

        int i = getBoardIndex(option);

        if(i == -1) {
            System.out.println("삭제할 게시물이 없습니다.");
        } else {
            if(Console.confirm("정말 삭제하시겠습니까?")) {
                boards[i] = null;
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