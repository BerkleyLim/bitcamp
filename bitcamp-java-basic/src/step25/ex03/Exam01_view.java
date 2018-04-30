// 게시물 관리 - JDBC 코드를 별도로 분리시켜 적용
package step25.ex03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Exam01_view {

    public static void main(String[] args) throws Exception {
        Scanner keyScan = new Scanner(System.in);
        System.out.print("조회할 게시물 번호? ");
        String no = keyScan.nextLine();
        
        try {
            BoardDao boardDao = new BoardDao();
            Board board = boardDao.view(no);
            if (board != null) {
                System.out.printf("번호 : %d\n", board.getNo());
                System.out.printf("제목 : %s\n", board.getContent());
                System.out.printf("내용 : %s\n", board.getContent());
                System.out.printf("등록일 : %s\n", board.getRegisteredDate());
            } else {
                System.out.println("해당 번호의 게시물이 없습니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        keyScan.close();
    }
}







