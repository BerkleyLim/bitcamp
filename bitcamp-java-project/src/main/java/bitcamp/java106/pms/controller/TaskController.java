// 팀 멤버 관리 기능을 모아 둔 클래스
package bitcamp.java106.pms.controller;

import java.sql.Date;
import java.util.Scanner;

import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.domain.Team;

public class TaskController {
    
    Scanner keyScan;
    TeamDao teamDao;
    TaskDao taskDao;
    
    
    public TaskController(Scanner scanner, TeamDao teamDao, TaskDao taskDao) {
        this.keyScan = scanner;
        this.teamDao = teamDao;
        this.taskDao = taskDao;
    }
    
    public void service(String menu, String option) {
        if (menu.equals("task/add")) {
            this.onTaskAdd(option);
        } else if (menu.equals("task/list")) {
            this.onTaskList(option);
        } else if(menu.equals("task/view")) {
            this.onTaskView(option);
        } else if(menu.equals("task/update")) {
            this.onTaskUpdate(option);
        } else if (menu.equals("task/delete")) {
            this.onTaskDelete(option);
        } else {
            System.out.println("명령어가 올바르지 않습니다.");
        }
    }

    // 팀 작업 추가
    public void onTaskAdd(String teamName) {
        if(teamName == null) {
            System.out.println("팀명을 입력하세요.");
            return;
        }
        
        Team team = teamDao.get(teamName);
        
        if(team == null) {
            System.out.printf("%s 팀은 존재하지 않습니다.", teamName);
            return;
        }
        
        Task task = new Task(team);
        //task.setTeam(team);
        
        System.out.println("[팀 작업 추가]");
        System.out.print("작업명? ");
        task.setTitle(keyScan.nextLine());
        
        System.out.print("시작일? ");
        task.setStartDate(Date.valueOf(keyScan.nextLine()));
        
        System.out.print("종료일? ");
        task.setEndDate(Date.valueOf(keyScan.nextLine()));
        
        System.out.print("작업자? ");
        String memberId = keyScan.nextLine();
        Member member = team.getMember(memberId);
        
        if (member == null) {
            System.out.printf("'%s'는 이 팀의 회원이 아닙니다.", memberId);
            return;
        }
        task.setWorker(member);
        
        taskDao.insert(task);
    }
    
    // 작업 리스트
    public void onTaskList(String option) {
        System.out.println("[작업 리스트]");
    }
    
    // 작업 상세 조회
    public void onTaskView(String option) {
        System.out.println("[작업 조회]");
    }
    
    // 작업 업데이트
    public void onTaskUpdate(String option) {
        System.out.println("[작업 업데이트]");
    }
    
    // 작업 삭제
    public void onTaskDelete(String option) {
        System.out.println("[작업 삭제]");
    }
}

// ver 17 - 클래스 생성
// ver 16 - 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
// ver 15 - 팀 멤버를 등록, 조회, 삭제할 수 있는 기능 추가. 
// ver 14 - TeamDao를 사용하여 팀 데이터를 관리한다.
// ver 13 - 시작일, 종료일을 문자열로 입력 받아 Date 객체로 변환하여 저장.