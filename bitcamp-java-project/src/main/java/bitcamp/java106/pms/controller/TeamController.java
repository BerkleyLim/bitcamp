package bitcamp.java106.pms.controller; // java폴더가 루트

import java.sql.Date;
import java.util.Scanner;

import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.util.Console;

public class TeamController {
    // 이 클래스를 사용하기 전에 App 클래스에서 준비한 Scanner 객체를
    // sc 변수에 저장하라.
    private Scanner keyScan;
    TeamDao teamDao = new TeamDao(); // 팀 정보 접근 설정
    
    public TeamController(Scanner keyScan) {
        this.keyScan = keyScan;
    }
    
    public void service(String menu, String option) {
        if(menu.equals("team/add") && option == null) { // 4) 팀 생성 명령어
            onTeamAdd();
        } else if(menu.equals("team/list")
                && option == null) { // 5) 팀 정보 간단 출력
            onTeamList();
        } else if(menu.equals("team/view")) { // 6) 해당 팀 상세정보 출력
            onTeamView(option);
        } else if(menu.equals("team/update")) { // 10) 팀 정보 수정
            onTeamUpdate(option);
        } else if(menu.equals("team/delete")) { // 11) 팀 정보 삭제
            onTeamDelete(option);
        } else {
            System.out.println("명령어가 올바르지 않습니다.");
        }
    }

    // 팀 추가 명령어
    private void onTeamAdd() {
        String name, description, maxQty;
        Date startDate, endDate; // 임시 저장 변수
            
        System.out.print("팀명? ");
        name = keyScan.nextLine();
        
        System.out.print("설명? ");
        description = keyScan.nextLine();
        
        System.out.print("인원수? ");
        maxQty = keyScan.nextLine();
        
        System.out.print("시작일? ");
        startDate = Date.valueOf(keyScan.nextLine());
        
        System.out.print("종료일? ");
        endDate = Date.valueOf(keyScan.nextLine());

        // 임시 객체 생성
        Team team = new Team(name, description,maxQty,
            startDate, endDate); // 또 다른 임시 객체 생성
        
        // 임시 객체 생성후 저장
        teamDao.insert(team);   
        // 월래 팀에 저장할 클래스 배열에 저장
    }

    // 팀 정보 조회
    private void onTeamList() {
        System.out.println("[팀 리스트 출력]");
        Team[] team = teamDao.list();  // 리스트 생성
        
        // 여기서 리스트 출력
        for(int i =0; i < team.length; i++) {
            if (team[i] == null) continue;
            System.out.println(team[i].getName() + ", " +
                team[i].getMaxQty() + ", " + team[i].getStartDate() +
                " ~ " + team[i].getEndDate());
        }
    }

    // 해당 팀 상세조회
    private void onTeamView(String name) {
        // team/view만 입력한 경우
        if(name == null) {
            System.out.println("팀명을 입력하세요.");
            System.out.println();
            return; // 값을 리턴하면 안되기 때문에 return 명령만 작성
                    // 의미? 즉시 메서드 실행을 멈추고 이전 위치로 돌아간다.
        }

        Team team = teamDao.getIndex(name);

        if(team == null) {
            System.out.println("해당 이름을 갖는 팀이 없습니다.");
        } else {
            
            System.out.println("팀명 : " + team.getName());
            System.out.println("설명 : " + team.getDescription());
            System.out.println("최대인원 : " + team.getMaxQty());
            System.out.println("기간 : " + team.getStartDate()
            + " ~ " + team.getEndDate());
        }
    }

    // 팀 정보 수정
    private void onTeamUpdate(String name) {
        // 팀명을 입력하지 않았을 때,
        if(name == null) {
            System.out.println("팀명을 입력하세요.");
            return;
        }

        Team team = teamDao.getIndex(name);
        
        if(team == null) {
            System.out.println("해당 이름의 팀이 없습니다.");
        } else {
            String named, description, maxQty;
            Date startDate, endDate;
            
            System.out.printf("팀명(%s)? ", team.getName());
            named = keyScan.nextLine();
            
            System.out.printf("설명(%s)? ", team.getDescription());
            description = keyScan.nextLine();
            
            System.out.printf("최대인원(%s)? ", team.getMaxQty());
            maxQty = keyScan.nextLine();
            
            System.out.printf("시작일(%s)? ", team.getStartDate());
            startDate = Date.valueOf(keyScan.nextLine());
            
            System.out.printf("종료일(%s)? ", team.getEndDate());
            endDate = Date.valueOf(keyScan.nextLine());
            
            // 임시 객체 변수 - try catch문을 사용 했을 때 대비해서
            Team teamUpdate = new Team(named, description, maxQty, 
                    startDate, endDate);
            
            teamDao.update(teamUpdate);

            System.out.println("변경하였습니다.");

            return;
        }

    }

    // 팀 정보 삭제
    private void onTeamDelete(String name) {
        if(name == null) {
            System.out.println("팀을 입력하세요.");
            return;
        }

        Team team = teamDao.getIndex(name);
        // 먼저 해당 아이디 색인
        
        
        if(team == null) {
            System.out.println("해당 이름의 팀이 없습니다.");
        } else {
            
            if(Console.confirm("정말 삭제하시겠습니까?")) {
                teamDao.delete(team);
            }
        }
    }
        
}

// ver 13 - 시작일, 종료일을 문자열로 입력 받아 Date 객체로 변환하여 저장