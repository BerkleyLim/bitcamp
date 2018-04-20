// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.controller.task;

import java.io.PrintWriter;
import java.sql.Date;
import java.util.Iterator;
import java.util.Scanner;

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
import bitcamp.java106.pms.util.Console;

@Component("task/update")
public class TaskUpdateController implements Controller {
    
    TeamDao teamDao;
    TaskDao taskDao;
    MemberDao memberDao;
    TeamMemberDao teamMemberDao;
    
    public TaskUpdateController(TeamDao teamDao, 
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
            System.out.printf("'%s' 팀은 존재하지 않습니다.\n", teamName);
            return;
        }
        
//        System.out.print("변경할 작업의 번호? ");
        int taskNo = Integer.parseInt(request.getParameter("no"));
        
        Task originTask = taskDao.get(taskNo);
        if (originTask == null) {
            out.printf("'%s'팀의 %d번 작업을 찾을 수 없습니다.\n",
                    team.getName(), taskNo);
            return;
        }
        
        Task task = new Task(team);
        task.setNo(originTask.getNo());
        task.setTitle(request.getParameter("title"));
        task.setStartDate(Date.valueOf(request.getParameter("startdate")));
        task.setEndDate(Date.valueOf(request.getParameter("enddate")));
        task.setWorker(memberDao.get(request.getParameter("memberId")));
        
        int index = taskDao.indexOf(task.getNo());
        taskDao.update(index, task);
        System.out.println("변경하였습니다.");
    }

}

// ver 26 - TaskUpdateController에서 update() 메서드를 추출하여 클래스로 정의
// ver 23 - @Component 애노테이션을 붙인다.
// ver 22 - TaskDao 변경 사항에 맞춰 이 클래스를 변경한다.
// ver 18 - ArrayList가 적용된 TaskDao를 사용한다.
// ver 17 - 클래스 생성
