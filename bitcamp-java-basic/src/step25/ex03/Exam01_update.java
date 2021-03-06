// 게시판 관리 - 변경 + preparedStatement 적용
package step25.ex03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Exam01_update {

    public static void main(String[] args) throws Exception {
        Scanner keyScan = new Scanner(System.in);
        
        Board board = new Board();
        
        System.out.print("변경할 게시물 변호? ");
        board.setNo(Integer.parseInt(keyScan.nextLine()));
        
        System.out.print("제목? ");
        board.setTitle(keyScan.nextLine());
        
        System.out.print("내용? ");
        board.setContent(keyScan.nextLine());
        
        try {
            BoardDao boardDao = new BoardDao();
            int count = boardDao.update(board);
            System.out.printf("%d개 변경 성공!", count);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        keyScan.close();
    }
}







