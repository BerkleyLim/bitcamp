// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.controller.task;

import java.io.PrintWriter;
import java.sql.Date;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.server.ServerRequest;
import bitcamp.java106.pms.server.ServerResponse;

@Component("/task/add")
public class TaskAddController implements Controller {
    TeamDao teamDao;
    TaskDao taskDao;
    MemberDao memberDao;
    TeamMemberDao teamMemberDao;
    
    public TaskAddController(TeamDao teamDao, 
            TaskDao taskDao, TeamMemberDao teamMemberDao, MemberDao memberDao) {
        this.teamDao = teamDao;
        this.taskDao = taskDao;
        this.teamMemberDao = teamMemberDao;
        this.memberDao = memberDao;
    }

    
    @Override
    public void service(ServerRequest request, ServerResponse response) {
        PrintWriter out = response.getWriter();
        String teamName = request.getParameter("teamName");
        Team team = teamDao.get(teamName);
        
        if (team == null) {
            out.printf("'%s' 팀은 존재하지 않습니다.\n", teamName);
            return;
        }
        
        Task task = new Task(team);
        task.setTitle(request.getParameter("title"));
        task.setStartDate(Date.valueOf(request.getParameter("startdate")));
        //나머지 자바스크립트에서 해결할 것들
        //System.out.print("시작일? ");
        //String str = keyScan.nextLine();
        //if (str.length() == 0) {
        //    task.setStartDate(team.getStartDate());
        //} else {
        //    Date date = Date.valueOf(str);
        //    if (date.getTime() < team.getStartDate().getTime()) {
        //        task.setStartDate(team.getStartDate());
        //    } else {
        //        task.setStartDate(date);
        //    }
        //}
        task.setStartDate(Date.valueOf(request.getParameter("enddate")));
        //System.out.print("종료일? ");
        //str = keyScan.nextLine();
        //if (str.length() == 0) {
        //    task.setEndDate(team.getEndDate());
        //} else {
        //    Date date = Date.valueOf(str);
        //    if (date.getTime() > team.getEndDate().getTime()) {
        //        task.setEndDate(team.getEndDate());
        //    } else {
        //        task.setEndDate(date);
        //   }
        //}
        
        task.setWorker(memberDao.get(request.getParameter("memberId")));
        
        taskDao.insert(task);
        out.println("등록 성공!");
    }
}

// ver 26 - TaskAddController에서 add() 메서드를 추출하여 클래스로 정의
// ver 23 - @Component 애노테이션을 붙인다.
// ver 22 - TaskDao 변경 사항에 맞춰 이 클래스를 변경한다.
// ver 18 - ArrayList가 적용된 TaskDao를 사용한다.
// ver 17 - 클래스 생성
