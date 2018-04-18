// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.controller.team;

import java.io.PrintWriter;
import java.sql.Date;
import java.util.Iterator;
import java.util.Scanner;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.server.ServerRequest;
import bitcamp.java106.pms.server.ServerResponse;
import bitcamp.java106.pms.util.Console;

@Component("/team/update")
public class TeamUpdateController implements Controller {
    TeamDao teamDao;
    
    public TeamUpdateController(TeamDao teamDao) {
        this.teamDao = teamDao;
    }

    @Override
    public void service(ServerRequest request, ServerResponse response) {
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        
        Team team = teamDao.get(name);

        if (team == null) {
            out.println("해당 이름의 팀이 없습니다.");
        } else {
            Team updateTeam = new Team();
            updateTeam.setName(name);
            updateTeam.setDescription(request.getParameter("description"));
            updateTeam.setMaxQty(Integer.parseInt(request.getParameter("maxqty")));
            updateTeam.setStartDate(Date.valueOf(request.getParameter("startdate")));
            updateTeam.setEndDate(Date.valueOf(request.getParameter("enddate")));
            
            int index = teamDao.indexOf(name);
            teamDao.update(index, updateTeam);
            out.println("변경하였습니다.");
        }
    }

}

// ver 26 - TaskUpdateController에서 update() 메서드를 추출하여 클래스로 정의
// ver 23 - @Component 애노테이션을 붙인다.
// ver 18 - ArrayList 클래스를적용하여 객체(의 주소) 목록을 관리한다.
// ver 16 - 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
// ver 15 - TeamDao를 생성자에서 주입 받도록 변경.
// ver 14 - TeamDao를 사용하여 팀 데이터를 관리한다.
// ver 13 - 시작일, 종료일을 문자열로 입력 받아 Date 객체로 변환하여 저장.