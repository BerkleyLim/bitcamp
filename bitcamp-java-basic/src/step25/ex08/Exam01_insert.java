// Mybatis + spring IoC - 트랜잭션 적용 전
package step25.ex08;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam01_insert {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext iocContainer =
                new ClassPathXmlApplicationContext(
                        "step25/ex08/application-context.xml");
        
        Board board = new Board();
        board.setNo(141);
        board.setTitle("1111");
        board.setContent("xxxx");
        System.out.printf("%d번 게시물 입력!\n", board.getNo());
        
        BoardDao boardDao = iocContainer.getBean(BoardDao.class);
        boardDao.insert(board);
        
        board.setNo(142);
        board.setTitle("2222");
        boardDao.insert(board);
        System.out.printf("%d번 게시물 입력!\n", board.getNo());
        
        board.setNo(143);
        board.setTitle("3333");
        boardDao.insert(board); 
        System.out.printf("%d번 게시물 입력!\n", board.getNo());
        
    }
}







