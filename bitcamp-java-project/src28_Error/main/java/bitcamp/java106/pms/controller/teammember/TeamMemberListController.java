// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.controller.teammember;

import java.io.PrintWriter;
import java.util.Iterator;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.server.ServerRequest;
import bitcamp.java106.pms.server.ServerResponse;

@Component("/team/member/list")
public class TeamMemberListController implements Controller {
    
    TeamDao teamDao;
    MemberDao memberDao;
    TeamMemberDao teamMemberDao;
    
    public TeamMemberListController(TeamDao teamDao, 
            MemberDao memberDao, TeamMemberDao teamMemberDao) {
        this.teamDao = teamDao;
        this.memberDao = memberDao;
        this.teamMemberDao = teamMemberDao;
    }
    
    @Override
    public void service(ServerRequest request, ServerResponse response) {
        PrintWriter out = response.getWriter();
        String teamName = request.getParameter("name");
        
        Team team = teamDao.get(teamName);
        if (team == null) {
            out.printf("%s 팀은 존재하지 않습니다.\n", teamName);
            return;
        }

        System.out.print("회원들: ");
        
        Iterator<String> iterator = teamMemberDao.getMembers(teamName);
        
        if (iterator != null) {
            while(iterator.hasNext()) {
                System.out.printf("%s, ", iterator.next());
            }
        }

        System.out.println();
    }
}

// ver 26 - TeamMemberAddController에서 add() 메서드를 추출하여 클래스로 정의
// ver 23 - @Component 애노테이션을 붙인다.
// ver 17 - TeamMemberDao 클래스를 사용하여 팀 멤버의 ID를 관리한다.
// ver 16 - 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
// ver 15 - 팀 멤버를 등록, 조회, 삭제할 수 있는 기능 추가. 
// ver 14 - TeamDao를 사용하여 팀 데이터를 관리한다.
// ver 13 - 시작일, 종료일을 문자열로 입력 받아 Date 객체로 변환하여 저장.