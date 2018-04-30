// 게시판 관리 - 삭제
package step25.ex02;

import java.sql.DriverManager;
import java.util.Scanner;

public class Exam01_delete {

    public static void main(String[] args) throws Exception {
        Scanner keyScan = new Scanner(System.in);
        System.out.print("삭제할 게시물 번호? ");
        String no = keyScan.nextLine();
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        java.sql.Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone="
                + "UTC&UseSSL=false",
                "bitcamp", "1111");
        System.out.println("DBMS와 연결됨!");
        
        java.sql.Statement stmt = con.createStatement();
        
        int count = stmt.executeUpdate(
                "delete from ex_board where bno=" + no);
        System.out.printf("%d 개 입력 성공!", count);
        
        stmt.close();
        con.close();
        keyScan.close();
    }
}







