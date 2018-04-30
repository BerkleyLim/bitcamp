package step25.ex04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardDao {
    DataSource dataSource;
    
    public BoardDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    public int delete(int no) throws Exception {
        try (
            Connection con = dataSource.getConnection();
            PreparedStatement stmt = con.prepareStatement(
                "delete from ex_board where bno=?")) {
            
            stmt.setInt(1, no);
            return stmt.executeUpdate();
        }
    }
    
    public List<Board> list() throws Exception {
        try (
            Connection con = dataSource.getConnection();
            PreparedStatement stmt = con.prepareStatement(
                "select bno,titl,rdt from ex_board");
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
        try (
            Connection con = dataSource.getConnection();
            PreparedStatement stmt = con.prepareStatement(
                "insert into ex_board(titl,cont,rdt) values(?,?,now())");) {
            
            stmt.setString(1, board.getTitle());
            stmt.setString(2, board.getContent());
        
            return stmt.executeUpdate();
        }
    }

    public int update(Board board) throws Exception {
        try (
            Connection con = dataSource.getConnection();
            PreparedStatement stmt = con.prepareStatement(
                "update ex_board set titl=?, cont=?, rdt=now() where bno=?");) {
            
            stmt.setString(1, board.getTitle());
            stmt.setString(2, board.getContent());
            stmt.setInt(3, board.getNo());
            return stmt.executeUpdate();
        }
    }

    public Board view(String no) throws Exception {
        try (
            Connection con = dataSource.getConnection();
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
