// 게시물 관리 - JDBC 코드를 별도의 클래스로 캡슐화시킴. DAO 적용
// => Data 영속성(지속성)을 관리하는 클래스를 DAO(Data Access Object)라 부른다.
// => Data 영속성(지속성)
//    - 데이터를 저장하고 유지하는 것.
//    - "데이터 퍼시스턴스(persistence)" 라 부른다.
package step25.ex03;

import java.util.List;

public class Exam01_list {

    public static void main(String[] args) throws Exception {
        BoardDao boardDao = new BoardDao();
        
        try {
            List<Board> list = boardDao.list();

            for (Board board : list){
                System.out.printf("%d,%s,%s\n",
                        board.getNo(),
                        board.getTitle(),
                        board.getRegisteredDate());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}







