package bitcamp.java106.pms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.domain.Board;

@Component
public class BoardDao {
    public int delete(int no) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try(
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/java106db?serverTimezone="
                        + "UTC&UseSSL=false",
                        "bitcamp", "1111");
                PreparedStatement stmt = con.prepareStatement(
                        "delete from pms_board where bno=?");) {
            stmt.setInt(1, no);
            return stmt.executeUpdate();
        }
        
    }
    
    public List<Board> list() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try(
            java.sql.Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/java106db?serverTimezone="
                            + "UTC&UseSSL=false",
                            "bitcamp", "1111");
            // 당장 select 할 때 파라미터 값을 넣지 않는다 하더라도,
            // 나중에 넣을 것을 대비해서 그냥 PreparedStatement를 사용하라!
            PreparedStatement stmt = con.prepareStatement(
                    "select bno,titl,cont,cdt from pms_board");
            
            // SQL 실행할 때는 파라미터로 SQL문을 넘겨주지 않는다.
            ResultSet rs = stmt.executeQuery();) {
            
            ArrayList<Board> arr = new ArrayList<>();
            while (rs.next()) {
                Board board = new Board();
                board.setNo(rs.getInt("bno"));
                board.setTitle(rs.getString("titl"));
                board.setCreatedDate(rs.getDate("cdt"));
                arr.add(board);
            } 
            return arr;
        }
    }
    
    public int insert(Board board) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/java106db?serverTimezone="
                            + "UTC&UseSSL=false",
                            "bitcamp", "1111");
            
            // 값이 들어갈 자리에 in-parameter(?)를 지정한다.
            // => 데이터 타입에 상관없이 ?를 넣는다.
            PreparedStatement stmt = con.prepareStatement(
                    "insert into pms_board(titl,cont,cdt) values(?,?,now())");) {

            // in-parameter에 값을 설정한다.
            // => 설정하는 순서는 상관없다. 하지만 유지보수를 위해 순서대로 나열하라.
            stmt.setString(1, board.getTitle());
            stmt.setString(2, board.getContent());
            
            return stmt.executeUpdate();
        }
        

    }

    public int update(Board board) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/java106db?serverTimezone="
                            + "UTC&UseSSL=false",
                            "bitcamp", "1111");
            
            PreparedStatement stmt = con.prepareStatement(
                    "update pms_board set titl=?, cont=?, "
                    + "cdt=now() where bno=?");) {
            
            stmt.setString(1, board.getTitle());
            stmt.setString(2, board.getContent());
            stmt.setInt(3, board.getNo());
            return stmt.executeUpdate();
        }
    }

    public Board selectOne(int no) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try ( // 객체 생성 코드, 객체를 넣을 수 있는 변수만 가능
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/java106db?serverTimezone="
                    + "UTC&UseSSL=false",
                    "bitcamp", "1111");
            
            PreparedStatement stmt = con.prepareStatement(
                    "select bno,titl,cont,cdt from pms_board where bno=?");) {
                
            stmt.setInt(1, no);
            
            try (ResultSet rs = stmt.executeQuery();) {
                if (!rs.next())
                    return null;
                
                Board board = new Board();
                board.setNo(rs.getInt("bno"));
                board.setTitle(rs.getString("titl"));
                board.setContent(rs.getString("cont"));
                board.setCreatedDate(rs.getDate("cdt"));
                return board;
            }
            
        }
    }
}

// ver 31 - JDBC API 적용
//ver 24 - File I/O 적용
//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - 추상 클래스 AbstractDao를 상속 받는다.
//ver 19 - 우리 만든 ArrayList 대신 java.util.LinkedList를 사용하여 목록을 다룬다. 
//ver 18 - ArrayList를 이용하여 인스턴스(의 주소) 목록을 다룬다. 
// ver 16 - 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
// ver 14 - BoardController로부터 데이터 관리 기능을 분리하여 BoardDao 생성.




