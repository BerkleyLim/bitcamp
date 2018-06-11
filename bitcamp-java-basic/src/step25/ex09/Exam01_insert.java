// Mybatis + spring IoC - 트랜잭션 적용 후
package step25.ex09;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import step25.ex09.Board;

public class Exam01_insert {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext iocContainer =
                new ClassPathXmlApplicationContext(
                        "step25/ex09/application-context.xml");
        
        // 트랜잭션 적용
        // 1) 트랜잭션 관리자를 등록해야 한다.
        //    => application-context.xml 객체를 등록
        // 2) 트랜잭션 관리자가 동작하려면 DAO를 사용하는 객체도
        //    트랜잭션 관리자와 같은 컨테이너에 객체가 있어야 한다.
        //    즉 DAO의 메서드를 사용하는 객체 또한 Spring IoC 컨테이너에 있어야 한다.
        //    => DAO 메서드를 호출하는 Service 객체를 만든다.
        //    => BoardService 클래스 추가
        //
        BoardDao boardDao = iocContainer.getBean(BoardDao.class);
        
        Board board = new Board();
        board.setContent("xxxx");
        
        board.setNo(141);
        board.setTitle("1111");
        board.setContent("xxxx");
        boardDao.insert(board);
        System.out.printf("%d번 게시물 입력!\n", board.getNo());
        
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







