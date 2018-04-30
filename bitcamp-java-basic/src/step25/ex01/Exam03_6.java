// JDBC 프로그래밍 개요 - DBMS에 SQL문 보내기 : delete
package step25.ex01;

import java.sql.DriverManager;

public class Exam03_6 {

    public static void main(String[] args) throws Exception {
        // 1) JDBC 드라이버 로딩 
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("JDBC 드라이버 로딩 및 등록 완료!");
        
        // 2) DBMS에 연결하기
        // => DriverManager를 통해 등록된 Driver 객체를 사용하여 DBMS에 연결한다.
        //    jdbc url : DBMS 서버 정보, 예) jdbc:mysql://서버:포트번호/데이터베이스명
        //    username : DBMS 사용자 아이디 
        //    password : DBMS 사용자 암호
        // => 리턴 : Driver가 DBMS와 연결한 후 연결 정보를 다루는 객체를 리턴한다.
        java.sql.Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone="
                + "UTC&UseSSL=false",
                "bitcamp", "1111");
        System.out.println("DBMS와 연결됨!");
        
        // 3) SQL문을 서버에 보낼 객체를 얻는다.
        //    - 리턴 값 : SQL문을 DBMS의 형식에 따라 인코딩하여 서버에 전달하는 일을 하는 객체.
        java.sql.Statement stmt = con.createStatement();
        
        // 4) Statement 객체를 사용하여 DBMS에 SQL문을 보낸다.
        int count = stmt.executeUpdate(
                "delete from ex_board where bno=13");
        System.out.printf("%d 개 입력 성공!", count);
        
        // 자원해제
        // => 파일과 마찬가지로 DBMS에 연결한 후 더이상 사용하지 않으면 연결을 해제해야 한다.
        stmt.close();
        con.close();
        
    }
}







