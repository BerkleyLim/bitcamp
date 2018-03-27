// Task 작업 하기 시작!!
package bitcamp.java106.pms.controller;

import java.sql.Date;
import java.util.Scanner;

import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.util.Console;

public class TaskController {
    
    private Scanner keyScan;
    TeamDao teamDao;
    MemberDao memberDao;
    TaskDao taskDao;
    Team[] team = new Team[1000];
    private static int teamIndex = 0;
    
    // 생성자 
    public TaskController(Scanner keyScan, TeamDao teamDao,
            MemberDao memberDao, TaskDao taskDao) {
        this.keyScan = keyScan;
        this.teamDao = teamDao;
        this.memberDao = memberDao;
        this.taskDao = taskDao;
    }
    
    // 서비스 메뉴
    public void service(String menu, String option) {
        if(menu.equals("task/add")) {
            onTaskAdd(option);
        } else if (menu.equals("task/list")) {
            onTaskList(option);
        } else if (menu.equals("task/view")) {
            onTaskView(option);
        } else if (menu.equals("task/update")) {
            onTaskUpdate(option);
        } else if (menu.equals("task/delete")) {
            onTaskDelete(option);
        } else if (menu.equals("task/state")){
            onTaskState(option);
        } else {
            System.out.println("명령어가 올바르지 않습니다.");
        }
    }
    
    // 팀을 입력하지 않는 경우 조건문 검사
    public boolean isNotExistTeamName(String option) {
        try {
            if(option == null) {
                System.out.println("팀명을 입력하세요. ");
                return true;
            } else if(!option.equals(teamDao.get(option).getName())) {
                System.out.println("해당 팀이 존재하지 않습니다.");
                return true;
            } else {
                team[teamIndex] = new Team(); 
                team[teamIndex++].setName(option);
                return false;
            }
        } catch(Exception e) {
            System.out.println("해당 팀이 존재하지 않습니다.");
            return true;
        }
    }
    
    // 작업명 추가
    public void onTaskAdd(String option) {
        // 팀명 입력하지 않을 때 혹은 잘 못 입력했을 대 조건문 검사
        if(isNotExistTeamName(option)) {
            return;
        }
        
        Task task = new Task();
        //
        System.out.print("작업명? ");
        task.setTaskTitle(keyScan.nextLine());
        
        System.out.print("시작일? ");
        Date startDate = Date.valueOf(keyScan.nextLine());
        
        Date startDateCalc = teamDao.get(option).getStartDate();

        // 시작 날짜 계산
        if(startDate == null || (startDate.getTime() - startDateCalc.getTime()) < 0){
            task.setStartDate(teamDao.get(option).getStartDate());
        } else {
            task.setStartDate(startDate);
        }
        
        System.out.print("종료일? ");
        Date endDate = Date.valueOf(keyScan.nextLine());
        Date endDateCalc = teamDao.get(option).getEndDate();
        
        // 종료 날짜 계산
        if(endDate == null || (endDate.getTime() - endDateCalc.getTime()) > 0){
            task.setEndDate(teamDao.get(option).getStartDate());
        } else {
            task.setEndDate(endDate);
        }
        
        System.out.print("작업자? ");
        String id = keyScan.nextLine();
        
        if(memberDao.get(id) != null) {
            task.setMember(id);
        } else {
            task.setMember(null);
        }
        
        taskDao.taskAdd(task, option);
    }
    
    public void onTaskList(String option) {
     // 팀명 입력하지 않을 때 혹은 잘 못 입력했을 대 조건문 검사
        if(isNotExistTeamName(option)) {
            return;
        }
        
        Task[] task = taskDao.taskList();
        
        for(int i = 0; i < task.length; i++) {
            if(task[i] == null) continue;
            System.out.println(i + " " + task[i].getTaskTitle() + " "
                    + task[i].getStartDate() + " " + task[i].getEndDate()
                    + " " + task[i].getMember());
        }
    }
    
    public void onTaskView(String option) {
        // 팀명 입력하지 않을 때 혹은 잘 못 입력했을 대 조건문 검사
        if(isNotExistTeamName(option)) {
            return;
        }
        System.out.print("작업번호?");
        Task task = taskDao.get(keyScan.nextInt());
        keyScan.nextLine();
        
        if(task == null) {
            System.out.println("작업번호를 잘 못 입력하였습니다.");
        } else {
            System.out.println("작업명: " + task.getTaskTitle());
            System.out.println("시작일: " + task.getStartDate());
            System.out.println("종료일: " + task.getEndDate());
            System.out.println("작업자: " + task.getMember());
        }
        
    }
    
    public void onTaskUpdate(String option) {
        // 팀명 입력하지 않을 때 혹은 잘 못 입력했을 대 조건문 검사
        if(isNotExistTeamName(option)) {
            return;
        }
        
        System.out.print("작업번호?");
        Task task = taskDao.get(keyScan.nextInt());
        keyScan.nextLine();
        
        if(task == null) {
            System.out.println("작업번호를 잘 못 입력하였습니다.");
        } else {
            System.out.print("작업명? ");
            task.setTaskTitle(keyScan.nextLine());
            
            System.out.print("시작일? ");
            Date startDate = Date.valueOf(keyScan.nextLine());
            
            Date startDateCalc = teamDao.get(option).getStartDate();

            // 시작 날짜 계산
            if(startDate == null || (startDate.getTime() - startDateCalc.getTime()) < 0){
                task.setStartDate(teamDao.get(option).getStartDate());
            } else {
                task.setStartDate(startDate);
            }
            
            System.out.print("종료일? ");
            Date endDate = Date.valueOf(keyScan.nextLine());
            Date endDateCalc = teamDao.get(option).getEndDate();
            
            // 종료 날짜 계산
            if(endDate == null || (endDate.getTime() - endDateCalc.getTime()) > 0){
                task.setEndDate(teamDao.get(option).getStartDate());
            } else {
                task.setEndDate(endDate);
            }
            
            System.out.print("작업자? ");
            String id = keyScan.nextLine();
            
            if(memberDao.get(id) != null) {
                task.setMember(id);
            } else {
                task.setMember(null);
            }
            
            System.out.println("변경하시겠습니까? (Y/N)");
            String ch = keyScan.nextLine().toUpperCase();
            if(ch.equals("y")) {
                taskDao.update(task);
                System.out.println("저장하였습니다.");
            } else {
                System.out.println("취소하였습니다.");
            }
        }
        
    }
    
    public void onTaskDelete(String option) {
        // 팀명 입력하지 않을 때 혹은 잘 못 입력했을 대 조건문 검사
        if(isNotExistTeamName(option)) {
            return;
        }
        
        System.out.println("삭제할 작업의 번호? ");
        int num = keyScan.nextInt();
        keyScan.nextLine();
        
        Task task = taskDao.get(num);
        
        if(task == null) {
            System.out.println("해당 작업의 번호가 없습니다.");
        } else {
            if (Console.confirm("정말 삭제하시겠습니까?")) {
                taskDao.delete(num);
                System.out.println("삭제되었습니다.");
            } else {
                System.out.println("취소하였습니다.");
            }
        }
    }
    
    public void onTaskState(String option) {
        // 팀명 입력하지 않을 때 혹은 잘 못 입력했을 대 조건문 검사
        if(isNotExistTeamName(option)) {
            return;
        }
        
        System.out.print("상태를 변경할 작업의 번호? ");
        int status = keyScan.nextInt();  // 작업번호
        keyScan.nextLine();
        
        String key = taskDao.status(status);  // 작업번호의 대한 상태
        
        if(key.equals("")) {
            System.out.println("해당 작업이 없습니다.");
        } else {
            String[] str = taskDao.titleStatus(); // 해당 팀명의 작업 내역
            for(int i =0; i< str.length; i++) {
                
                System.out.printf("\'%s\' 작업의 상태: %s(%d)",str[i],key,status);
            }
            
            // 마저 상태 변경하기
            System.out.println("변경할 상태? (0:작업대기, 1:작업중, 9:작업완료) ");
            status = keyScan.nextInt();
            keyScan.nextLine();
            key = taskDao.status(status);
            if(key.equals("")) {
                System.out.println("올바르지 않은 값입니다. 이전 생태를 유지합니다!");
            } else {
                System.out.printf("작업의 상태를 \'%s\'(으로) 변경하였습니다.",key);
            }
        }
        
        
    }
}
