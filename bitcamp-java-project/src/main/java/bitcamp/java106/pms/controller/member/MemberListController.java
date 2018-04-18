// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.controller.member;

import java.io.PrintWriter;
import java.util.Iterator;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.server.ServerRequest;
import bitcamp.java106.pms.server.ServerResponse;

@Component("/member/list")
public class MemberListController implements Controller {
    MemberDao memberDao;

    public MemberListController(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    
    
    @Override
    public void service(ServerRequest request, ServerResponse response) {
        PrintWriter out = response.getWriter();
        Iterator<Member> iterator = memberDao.list();
        while(iterator.hasNext()) {
            Member member = (Member) iterator.next();
            out.printf("%s, %s, %s\n", 
                member.getId(), member.getEmail(), member.getPassword());
        }
    }
}

// ver 26 - MemberListController에서 list() 메서드를 추출하여 클래스로 정의
// ver 23 - @Component 애노테이션을 붙인다.
// ver 18 - ArrayList가 적용된 MemberDao를 사용한다.
//          onMemberList()에서 배열의 각 항목에 대해 null 값을 검사하는 부분을 제거하였다.
// ver 16 - 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
// ver 15 - MemberDao를 생성자에서 주입 받도록 변경.
// ver 14 - MemberDao를 사용하여 회원 데이터를 관리한다.
