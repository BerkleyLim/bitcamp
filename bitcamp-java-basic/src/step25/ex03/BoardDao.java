package step25.ex03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardDao {
    public int delete(int no) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try(
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/java106db?serverTimezone="
                        + "UTC&UseSSL=false",
                        "bitcamp", "1111");
                PreparedStatement stmt = con.prepareStatement(
                        "delete from ex_board where bno=?");) {
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
                    "select bno,titl,cont,rdt from ex_board");
            
            // SQL 실행할 때는 파라미터로 SQL문을 넘겨주지 않는다.
            ResultSet rs = stmt.executeQuery();) {
            
            ArrayList<Board> arr = new ArrayList<>();
            while (rs.next()) {
                Board board = new Board();
                board.setNo(rs.getInt("bno"));
                board.setTitle(rs.getString("titl"));
                board.setRegisteredDate(rs.getDate("rdt"));
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
                    "insert into ex_board(titl,cont,rdt) values(?,?,now())");) {

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
                    "update ex_board set titl=?, cont=?, "
                    + "rdt=now() where bno=?");) {
            
            stmt.setString(1, board.getTitle());
            stmt.setString(2, board.getContent());
            stmt.setInt(3, board.getNo());
            return stmt.executeUpdate();
        }
    }

    public Board view(String no) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try ( // 객체 생성 코드, 객체를 넣을 수 있는 변수만 가능
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/java106db?serverTimezone="
                    + "UTC&UseSSL=false",
                    "bitcamp", "1111");
            
            PreparedStatement stmt = con.prepareStatement(
                    "select bno,titl,cont,rdt from ex_board where bno=?");) {
                
            stmt.setString(1, no);
            
            try (ResultSet rs = stmt.executeQuery();) {
                if (!rs.next())
                    return null;
                
                Board board = new Board();
                board.setNo(rs.getInt("bno"));
                board.setTitle(rs.getString("titl"));
                board.setContent(rs.getString("cont"));
                board.setRegisteredDate(rs.getDate("rdt"));
                return board;
            }
            
        }
    }
}
