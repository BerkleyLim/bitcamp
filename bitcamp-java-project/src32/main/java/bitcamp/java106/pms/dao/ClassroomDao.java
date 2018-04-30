package bitcamp.java106.pms.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.domain.Classroom;
import bitcamp.java106.pms.jdbc.DataSource;

@Component
public class ClassroomDao {
    
    DataSource dataSource;
    
    public ClassroomDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    public int delete(int no) throws Exception {
        try(
            Connection con = dataSource.getConnection();
            PreparedStatement stmt = con.prepareStatement(
                    "delete from pms_classroom where cno=?");) {
            stmt.setInt(1, no);
            return stmt.executeUpdate();
        }
        
    }
    
    public List<Classroom> list() throws Exception {
        try(
            Connection con = dataSource.getConnection();
            // 당장 select 할 때 파라미터 값을 넣지 않는다 하더라도,
            // 나중에 넣을 것을 대비해서 그냥 PreparedStatement를 사용하라!
            PreparedStatement stmt = con.prepareStatement(
                    "select cno,title,sdt,edt,room from pms_classroom");
            
            // SQL 실행할 때는 파라미터로 SQL문을 넘겨주지 않는다.
            ResultSet rs = stmt.executeQuery();) {
            
            ArrayList<Classroom> arr = new ArrayList<>();
            while (rs.next()) {
                Classroom classroom = new Classroom();
                classroom.setNo(rs.getInt("cno"));
                classroom.setTitle(rs.getString("title"));
                classroom.setStartDate(rs.getDate("sdt"));
                classroom.setEndDate(rs.getDate("edt"));
                classroom.setRoom(rs.getString("room"));
                arr.add(classroom);
            } 
            return arr;
        }
    }
    
    public int insert(Classroom classroom) throws Exception {
        try(
            Connection con = dataSource.getConnection();
            
            // 값이 들어갈 자리에 in-parameter(?)를 지정한다.
            // => 데이터 타입에 상관없이 ?를 넣는다.
            PreparedStatement stmt = con.prepareStatement(
                    "insert into pms_board(cno,title,sdt,edt,room)"
                    + " values(?,?,?,?,?)");) {

            // in-parameter에 값을 설정한다.
            // => 설정하는 순서는 상관없다. 하지만 유지보수를 위해 순서대로 나열하라.
            stmt.setInt(1, classroom.getNo());
            stmt.setString(2, classroom.getTitle());
            stmt.setDate(3, classroom.getStartDate(), Calendar.getInstance(Locale.KOREA));
            stmt.setDate(4, classroom.getEndDate(), Calendar.getInstance(Locale.KOREA));
            stmt.setString(5, classroom.getRoom());
            
            return stmt.executeUpdate();
        }
        

    }

    public int update(Classroom classroom) throws Exception {
        try(
            Connection con = dataSource.getConnection();
            
            PreparedStatement stmt = con.prepareStatement(
                    "update pms_board set title=?, sdt=?, "
                    + "edt=? room=? where cno=?");) {
            
            stmt.setString(1, classroom.getTitle());
            stmt.setDate(2, classroom.getStartDate(), Calendar.getInstance(Locale.KOREA));
            stmt.setDate(3, classroom.getEndDate(), Calendar.getInstance(Locale.KOREA));
            stmt.setString(4, classroom.getRoom());
            return stmt.executeUpdate();
        }
    }

    public Classroom selectOne(int no) throws Exception {
        try(
            Connection con = dataSource.getConnection();
            
            PreparedStatement stmt = con.prepareStatement(
                    "select cno,title,sdt,edt,room pms_classroom where cno=?");) {
                
            stmt.setInt(1, no);
            
            try (ResultSet rs = stmt.executeQuery();) {
                if (!rs.next())
                    return null;
                
                Classroom classroom = new Classroom();
                classroom.setNo(rs.getInt("cno"));
                classroom.setTitle(rs.getString("title"));
                classroom.setStartDate(rs.getDate("sdt"));
                classroom.setEndDate(rs.getDate("edt"));
                classroom.setRoom(rs.getString("room"));
                return classroom;
            }
            
        }
    }

}

//ver 24 - File I/O 적용
//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - 추상 클래스 AbstractDao를 상속 받는다.
//ver 20 - 클래스 추가




