package bitcamp.java106.pms.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.domain.Board;

@Component
public class BoardDao {
    SqlSessionFactory sqlSessionFactory;
    
    public BoardDao(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
    
    public int delete(int no) throws Exception {
        try(SqlSession sqlSession = this.sqlSessionFactory.openSession()) {
            int count = sqlSession.delete(
                    "bitcamp.java106.pms.dao.BoardDao.delete", no);
            sqlSession.commit();
            return count;
        }
    }
    
    public List<Board> selectList() throws Exception {
        try(SqlSession sqlSession = this.sqlSessionFactory.openSession()) {
            return sqlSession.selectList(
                    "bitcamp.java106.pms.dao.BoardDao.selectList");
        }
    }
    
    public int insert(Board board) throws Exception {
        try(SqlSession sqlSession = this.sqlSessionFactory.openSession()) {

            int count =sqlSession.insert(
                    "bitcamp.java106.pms.dao.BoardDao.insert", board);
            
            sqlSession.commit();
            return count;
        }
        

    }

    public int update(Board board) throws Exception {
        try(SqlSession sqlSession = this.sqlSessionFactory.openSession()) {
            
            int count = sqlSession.update(
                    "bitcamp.java106.pms.dao.BoardDao.update", board);
            sqlSession.commit();
            return count;
        }
    }

    public Board selectOne(int no) throws Exception {
        try(SqlSession sqlSession = this.sqlSessionFactory.openSession()) {
            return sqlSession.selectOne(
                    "bitcamp.java106.pms.dao.BoardDao.selectOne", no);
        }
    }
}

// ver 31 - JDBC API 적용





