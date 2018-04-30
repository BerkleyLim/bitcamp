// 게시물 관리 - 목록
package step25.ex02;

import java.sql.DriverManager;

public class Exam01_list {

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        java.sql.Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone="
                + "UTC&UseSSL=false",
                "bitcamp", "1111");
        
        java.sql.Statement stmt = con.createStatement();
        
        java.sql.ResultSet rs = stmt.executeQuery(
                "select bno,titl,cont,rdt from ex_board");

        while (rs.next()) {
            System.out.printf("%d,%s,%s\n",
                    rs.getInt("bno"),    // select 결과의 컬럼 번호이다. 1부터 시작!
                    rs.getString("titl"), // 'titl' 컬럼 값
                    rs.getDate("rdt")); // 'cont' 컬럼 값
        } 

        rs.close();
        stmt.close();
        con.close();
        
    }
}







