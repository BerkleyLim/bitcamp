// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.controller.board;

import java.io.PrintWriter;
import java.util.Scanner;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.BoardDao;
import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.server.ServerRequest;
import bitcamp.java106.pms.server.ServerResponse;

@Component("/board/view")
public class BoardViewController implements Controller {
    BoardDao boardDao;
    
    public BoardViewController(BoardDao boardDao) {
        this.boardDao = boardDao;
    }
    
    @Override
    public void service(ServerRequest request, ServerResponse response) {
        PrintWriter out = response.getWriter();
        int no = Integer.parseInt(request.getParameter("no"));

        Board board = boardDao.get(no);
        
        if (board == null) {
            out.println("유효하지 않은 게시물 번호입니다.");
        } else {
            out.printf("팀명: %s\n", board.getTitle());
            out.printf("설명: %s\n", board.getContent());
            out.printf("등록일: %s\n", board.getCreatedDate());
        }
    }
}

// ver 26 - BoardController에서 add() 메서드를 추출하여 클래스로 정의
// ver 23 - @Component 애노테이션을 붙인다. BoardDao를 받도록 생성자 변경
// ver 22 - BoardDao에 맞춰서 한다.
// ver 18 - BoardDao 변경 사항에 맞춰 이 클래스를 변경한다.
// ver 16 - 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
// ver 14 - BoardDao를 사용하여 게시물 데이터를 관리한다.
// ver 13 - 게시물 등록할 때 등록일의 문자열을 Date 객체로 만들어 저장.