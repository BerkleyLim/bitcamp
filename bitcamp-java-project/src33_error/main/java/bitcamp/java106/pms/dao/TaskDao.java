package bitcamp.java106.pms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.domain.Team;

@Component
public class TaskDao{

    SqlSessionFactory sqlSessionFactory;
    public TaskDao(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
    
    public int insert(Task task) throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession()) {
            int count = sqlSession.delete(
                    "bitcamp.java106.pms.dao.TaskDao.insert", task);
            sqlSession.commit();
            return count;
        }
    }
    
    public List<Task> selectList(String teamName) throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession()) {
            return sqlSession.selectList(
                    "bitcamp.java106.pms.dao.TaskDao.selectList");
        }
    }
    
    public Task selectOne(int no) throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession()) {
            return sqlSession.selectOne(
                    "bitcamp.java106.pms.dao.TaskDao.selectOne", no);
        }
    }
    
    public int update(Task task) throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession()) {
            int count = sqlSession.delete(
                    "bitcamp.java106.pms.dao.TaskDao.update", task);
            sqlSession.commit();
            return count;
        }
    }
    
    public int delete(int no) throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession()) {
            int count = sqlSession.delete(
                    "bitcamp.java106.pms.dao.TaskDao.delete", no);
            sqlSession.commit();
            return count;
        } 
    }
    
    
    // 요기는 메소드 필요한 것만 따로 추가
    public int updateState(int no, int state) throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession()) {
            HashMap<String,Object> paramMap = new HashMap<>();
            paramMap.put("no", no);
            paramMap.put("state", state);

            int count = sqlSession.update(
                    "bitcamp.java106.pms.dao.TaskDao.updateState", paramMap);
            sqlSession.commit();
            return count;
        }
    }
}

//ver 24 - File I/O 적용
//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - 추상 클래스 AbstractDao를 상속 받는다.
//ver 19 - 우리 만든 ArrayList 대신 java.util.LinkedList를 사용하여 목록을 다룬다. 
//ver 18 - ArrayList 클래스를 적용하여 객체(의 주소) 목록을 관리한다.
// ver 17 - 클래스 생성





