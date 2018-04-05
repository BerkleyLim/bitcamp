package bitcamp.java106.pms;

import java.sql.Date;
import java.util.HashMap;
import java.util.Scanner;

import bitcamp.java106.pms.controller.BoardController;
import bitcamp.java106.pms.controller.ClassroomController;
import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.controller.MemberController;
import bitcamp.java106.pms.controller.TaskController;
import bitcamp.java106.pms.controller.TeamController;
import bitcamp.java106.pms.controller.TeamMemberController;
import bitcamp.java106.pms.dao.ClassroomDao;
import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.util.Console;

public class App {
    static Scanner keyScan = new Scanner(System.in);
    public static String option = null; 
    
    static void onQuit() {
        System.out.println("안녕히 가세요!");
    }

    static void onHelp() {
        System.out.println("[도움말]");
        System.out.println("팀 등록 명령 : team/add");
        System.out.println("팀 조회 명령 : team/list");
        System.out.println("팀 상세조회 명령 : team/view 팀명");
        System.out.println("회원 등록 명령 : member/add");
        System.out.println("회원 조회 명령 : member/list");
        System.out.println("회원 상세조회 명령 : member/view 아이디");
        System.out.println("종료 : quit");
    }

    public static void main(String[] args) {
        // 클래스를 사용하기 전에 필수 값을 설정한다.
        
        TeamDao teamDao = new TeamDao();
        MemberDao memberDao = new MemberDao();
        TaskDao taskDao = new TaskDao();
        TeamMemberDao teamMemberDao = new TeamMemberDao();
        ClassroomDao  classroomDao = new ClassroomDao();
        
        // 테스트용 데이터를 준비하도록 다음 메서드를 호출한다.
        prepareMemberData(memberDao);
        prepareTeamData(teamDao, teamMemberDao);
        
        TeamController teamController 
            = new TeamController(keyScan, teamDao);
        TeamMemberController teamMemberController 
            = new TeamMemberController(keyScan, teamDao, memberDao, teamMemberDao);
        MemberController memberController 
            = new MemberController(keyScan, memberDao);
        BoardController boardController 
            = new BoardController(keyScan);
        TaskController taskController 
            = new TaskController(keyScan, teamDao, taskDao, teamMemberDao, memberDao);
        ClassroomController classroomController 
            = new ClassroomController(keyScan, classroomDao);
        
        HashMap<String, Controller> controllerMap = new HashMap<>();
        
        // 형식 : controllerMap.put("string형", "Controller형");
        controllerMap.put("board", boardController);
        controllerMap.put("classroom", classroomController);
        controllerMap.put("member", memberController);
        controllerMap.put("task", taskController);
        controllerMap.put("team", teamController);
        controllerMap.put("team/member", teamMemberController);
        
        Console.keyScan = keyScan;

        while (true) {
            String[] arr = Console.prompt();

            String menu = arr[0];
            if (arr.length == 2) {
                option = arr[1];
            } else {
                option = null;
            }
            

            if (menu.equals("quit")) {
                onQuit();
                break;
            } else if (menu.equals("help")) {
                onHelp();
            } else {
                // 또한 명령어 단위로 짜른다.
                // ex) team/member/add 면 team/member 만 인식 
                //     task/list 면 task 만 인식
                // 만일 menu.substring에서 "/" 찾지 못하면 자동으로 정의되지 않는 값 떠서 
                //                      controllerKey 저장 안됨 controller에서 오류 방지를 위해
                //                      예외처리 둠
                try {
                    int slashIndex = menu.lastIndexOf("/");
                    String controllerKey = menu.substring(0, slashIndex);
                    Controller controller = controllerMap.get(controllerKey);
                
                    if (controller != null) { // 요기서 색인 하기
                        controller.service(menu, option);
                    }
                } catch(Exception e) {
                    System.out.println("명령어가 올바르지 않습니다!");
                }
            } 
            System.out.println(); 
        }
    }
    
    
    static void prepareMemberData(MemberDao memberDao) {
        Member member = new Member();
        member.setId("aaa");
        member.setEmail("aaa@test.com");
        member.setPassword("1111");
        
        memberDao.insert(member);
        
        member = new Member();
        member.setId("bbb");
        member.setEmail("bbb@test.com");
        member.setPassword("1111");
        
        memberDao.insert(member);
        
        member = new Member();
        member.setId("ccc");
        member.setEmail("ccc@test.com");
        member.setPassword("1111");
        
        memberDao.insert(member);
        
        member = new Member();
        member.setId("ddd");
        member.setEmail("ddd@test.com");
        member.setPassword("1111");
        
        memberDao.insert(member);
        
        member = new Member();
        member.setId("eee");
        member.setEmail("eee@test.com");
        member.setPassword("1111");
        
        memberDao.insert(member);
    }
    
    static void prepareTeamData(
            TeamDao teamDao, 
            TeamMemberDao teamMemberDao) {
        Team team = new Team();
        team.setName("t1");
        team.setMaxQty(5);
        team.setStartDate(Date.valueOf("2018-1-1"));
        team.setEndDate(Date.valueOf("2018-5-31"));
        teamDao.insert(team);
        teamMemberDao.addMember("t1", "aaa");
        teamMemberDao.addMember("t1", "bbb");
        teamMemberDao.addMember("t1", "ccc");
        
        team = new Team();
        team.setName("t2");
        team.setMaxQty(5);
        team.setStartDate(Date.valueOf("2018-2-1"));
        team.setEndDate(Date.valueOf("2018-6-30"));
        teamMemberDao.addMember("t2", "ccc");
        teamMemberDao.addMember("t2", "ddd");
        teamMemberDao.addMember("t2", "eee");
        teamDao.insert(team);
    }
}

// ver 17 - Task 관리 기능 추가
// ver 15 - TeamDao와 MemberDao 객체 생성. 
//          팀 멤버를 다루는 메뉴 추가.