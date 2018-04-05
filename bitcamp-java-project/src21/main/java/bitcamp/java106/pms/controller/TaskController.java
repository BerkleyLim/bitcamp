// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.controller;

import java.sql.Date;
import java.util.Scanner;

import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.util.Console;

//TaskController는 Controller 규칙을 이행한다.
//=> Controller 규칙에 따라 메서드를 만든다.
public class TaskController implements Controller {
    
    Scanner keyScan;
    TeamDao teamDao;
    TaskDao taskDao;
    TeamMemberDao teamMemberDao;
    MemberDao memberDao;
    
    public TaskController(Scanner scanner, TeamDao teamDao, 
            TaskDao taskDao, TeamMemberDao teamMemberDao,
            MemberDao memberDao) {
        this.keyScan = scanner;
        this.teamDao = teamDao;
        this.taskDao = taskDao;
        this.teamMemberDao = teamMemberDao;
        this.memberDao = memberDao;
    }
    
    public void service(String menu, String option) {
        if(option == null) {
            System.out.println("팀명을 입력하세요.");
            return;
        }
        
        Team team = teamDao.get(option);
        
        if(team == null) {
            System.out.printf("%s 팀은 존재하지 않습니다.", option);
            return;
        }
        
        Task task = new Task(team);
        
        if (menu.equals("task/add")) {
            this.onTaskAdd(team);
        } else if (menu.equals("task/list")) {
            this.onTaskList(team);
        } else if(menu.equals("task/view")) {
            this.onTaskView(team);
        } else if(menu.equals("task/update")) {
            this.onTaskUpdate(team);
        } else if (menu.equals("task/delete")) {
            this.onTaskDelete(team);
        } else if (menu.equals("task/state")) {
            this.onTaskState(team);
        } else {
            System.out.println("명령어가 올바르지 않습니다.");
        }
    }

    // 팀 작업 추가
    private void onTaskAdd(final Team team) {
        Task task = new Task(team);
        //task.setTeam(team);
        
        System.out.println("[팀 작업 추가]");
        System.out.print("작업명? ");
        task.setTitle(keyScan.nextLine());
        
        System.out.print("시작일? ");
        String str = keyScan.nextLine();
        
        // 1) 시작일 입력 하지 않으면, 2) 시작일을 보다 이전으로 입력시, 3) 시작일을 그 이후에 입력시
        if(str.length() == 0) {
            task.setStartDate(team.getStartDate());
        } else if(Date.valueOf(str).getTime() < team.getStartDate().getTime()){
            task.setStartDate(team.getStartDate());
        } else {
            task.setStartDate(Date.valueOf(str));
        }
        
        System.out.print("종료일? ");
        str = keyScan.nextLine();
        
        // 1) 종료일 입력 하지 않으면, 2) 종료일을 초과 입력시, 3) 종료일을 기준보다 이전으로 입력시
        if(str.length() == 0) {
            task.setEndDate(Date.valueOf(team.getStartDate().toString()));
        } else if(Date.valueOf(str).getTime() > team.getStartDate().getTime()) {
            task.setEndDate(team.getStartDate());
        } else {
            task.setEndDate(Date.valueOf(str));
        }
        
        
        System.out.print("작업자 아이디? ");
        String memberId = keyScan.nextLine();
        // 작업자 지정 안할 시
        if(memberId.length() != 0) {
            if (!teamMemberDao.isExist(team.getName(), memberId)) {
                System.out.printf("'%s'는 이 팀의 회원이 아닙니다. "
                        + "작업자는 비워두겠습니다.", memberId);
            } else {
                task.setWorker(this.memberDao.get(memberId));
            }
        }
        taskDao.insert(task);
    }
    
    // 작업 리스트
    private void onTaskList(final Team team) {
        if(team.getName() == null) {
            System.out.println("팀명을 입력하세요.");
            return;
        }
        
        System.out.println("[팀 작업 목록]");
        
        Task[] tasks = taskDao.list(team.getName());
        
        for(Task task : tasks) {
            System.out.printf("%d, %s, %s, %s, %s\n", 
                    task.getNo(), task.getTitle(), 
                    task.getStartDate(), task.getEndDate(), 
                    (task.getWorker() == null) ? 
                            "-" : task.getWorker().getId());
        }
        
        System.out.println();
    }
    
    // 작업 상세 조회
    private void onTaskView(final Team team) {
        System.out.println("[작업 정보]");
        System.out.print("작업 번호? ");
        int taskNo = Integer.parseInt(keyScan.nextLine());
        
        
        Task task = taskDao.get(taskNo);
        
        if(task == null) {
            System.out.printf("'%s'팀의 %d번 작업을 찾을 수 없습니다. \n",
                    team.getName(), taskNo);
            return;
        }
        
        System.out.println("작업명: " + task.getTitle());
        System.out.println("시작일: " + task.getStartDate());
        System.out.println("종료일: " + task.getEndDate());
        System.out.printf("작업자: %s" ,
                (task.getWorker() == null) ? "-" : task.getWorker().getId()); 
        System.out.printf("작업상태: %s\n", getStateLabel(task.getState()));
    }
    
    // 작업 업데이트
    private void onTaskUpdate(final Team team) {
        System.out.println("[팀 작업 변경]");
        System.out.print("변경할 작업의 번호? ");
        int taskNo = Integer.parseInt(keyScan.nextLine());
        
        Task originTask = taskDao.get(taskNo);
        if(originTask == null) {
            System.out.printf("'%s'팀의 %d번 작업을 찾을 수 없습니다. \n",
                    team.getName(), taskNo);
            return;
        }
        
        Task task = new Task(team);
        task.setNo(originTask.getNo());
        
        System.out.print("작업명(" + originTask.getTitle() + ")? ");
        String str = keyScan.nextLine();
        if(str.length() == 0) {
            task.setTitle(originTask.getTitle());
        } else {
            task.setTitle(str);
        }
        
        System.out.print("시작일(" + originTask.getStartDate() + ")? ");
        str = keyScan.nextLine();
        
        // 1) 시작일 입력 하지 않으면, 2) 시작일을 보다 이전으로 입력시, 3) 시작일을 그 이후에 입력시
        if(str.length() == 0) {
            task.setStartDate(originTask.getStartDate());
        } else if(Date.valueOf(str).getTime() < originTask.getStartDate().getTime()){
            task.setStartDate(originTask.getStartDate());
        } else {
            task.setStartDate(Date.valueOf(str));
        }
        System.out.print("종료일(" + originTask.getEndDate() + ")? ");
        str = keyScan.nextLine();
        
        // 1) 종료일 입력 하지 않으면, 2) 종료일을 초과 입력시, 3) 종료일을 기준보다 이전으로 입력시
        if(str.length() == 0) {
            task.setEndDate(Date.valueOf(originTask.getStartDate().toString()));
        } else if(Date.valueOf(str).getTime() > originTask.getStartDate().getTime()) {
            task.setEndDate(originTask.getStartDate());
        } else {
            task.setEndDate(Date.valueOf(str));
        }
        
        System.out.printf("작업자 아이디(%s)? " ,
                (originTask.getWorker() == null) ? "-" : originTask.getWorker().getId());
        String memberId = keyScan.nextLine();
        // memberId의 null 값 여부 조건 검사
        if (memberId.length() == 0) {
            task.setWorker(originTask.getWorker());
        } else {
            if (!teamMemberDao.isExist(team.getName(), memberId)) {
                System.out.printf("'%s'는 이 팀의 회원이 아닙니다. "
                        + "작업자는 비워두겠습니다.", memberId);
            } else {
                task.setWorker(this.memberDao.get(memberId));
            }
        }

        if(Console.confirm("변경하시겠습니까?")) {
            taskDao.update(task);
            System.out.println("변경하였습니다.");
        } else {
            System.out.println("취소하였습니다.");
        }
    }
    
    // 작업 삭제
    private void onTaskDelete(final Team team) {
        System.out.println("[팀 작업 삭제]");
        System.out.print("삭제할 작업의 번호? ");
        int taskNo = Integer.parseInt(keyScan.nextLine());
        
        Task task = taskDao.get(taskNo);
        if(task == null) {
            System.out.printf("'%s'팀의 %d번 작업을 찾을 수 없습니다. \n",
                    team.getName(), taskNo);
            return;
        }
        
        if(Console.confirm("삭제하겠습니까?")) {
            taskDao.delete(task.getNo());
            System.out.println("삭제하였습니다.");
        } else {
            System.out.println("취소하였습니다.");
        }
        
    }
    
    private void onTaskState(final Team team) {
        System.out.println("[작업 진행 상태]");
        System.out.print("상태를 변경할 작업의 번호? ");
        int taskNo = Integer.parseInt(keyScan.nextLine());
        
        Task task = taskDao.get(taskNo);
        if(task == null) {
            System.out.printf("'%s'팀의 %d번 작업을 찾을 수 없습니다. \n",
                    team.getName(), taskNo);
            return;
        }
        
        System.out.printf("'%s' 작업의 상태: %s\n", 
                task.getTitle(), getStateLabel(task.getState()));
        
        
        System.out.println("변경할 상태? (0: 작업대기, 1: 작업중, 9: 작업완료)");
        int state = Integer.parseInt(keyScan.nextLine());
        
        if (state == Task.READY || state == Task.WORKING || 
                state == Task.COMPLETE) {
            task.setState(state);
            System.out.printf("작업 상태를 '%s'로 변경하였습니다.",
                    getStateLabel(state));
        } else {
            System.out.println("올바르지 않은 값입니다. 이전 상태를 유지합니다.");
        }
    }
    
    // 다음 메서드와 같이 인스턴스 변수를 사용하지 않은 메서드라며,
    // static을 붙여 클래스 메서드로 만들라.
    public static String getStateLabel(int state) {
        switch (state){
        case Task.READY:
            return "작업대기";
        case Task.WORKING:
            return "작업중";
        case Task.COMPLETE:
            return "작업완료";
        default:
            return null;
        }
    }
}

// ver 18 - ArrayList가 적용된 teamDao를 사용
// ver 17 - 클래스 생성
// ver 16 - 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
// ver 15 - 팀 멤버를 등록, 조회, 삭제할 수 있는 기능 추가. 
// ver 14 - TeamDao를 사용하여 팀 데이터를 관리한다.
// ver 13 - 시작일, 종료일을 문자열로 입력 받아 Date 객체로 변환하여 저장.