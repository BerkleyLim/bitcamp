package bitcamp.java106.pms.controller; // java폴더가 루트

import java.sql.Date;
import java.util.Scanner;

import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.util.Console;

public class TeamMemberController {
    // 이 클래스를 사용하기 전에 App 클래스에서 준비한 Scanner 객체를
    // sc 변수에 저장하라.
    private Scanner keyScan;
    TeamDao teamDao; // 팀 dao
    MemberDao memberDao; // 맴버 dao
    
    public TeamMemberController(Scanner keyScan, TeamDao teamDao, MemberDao memberDao) {
        this.keyScan = keyScan;
        this.teamDao = teamDao;
        this.memberDao = memberDao;
    }
    
    public void service(String menu, String option) {
        if(menu.equals("team/member/add") && option == null) { // 4) 팀 생성 명령어
            onTeamMemberAdd(option);
        } else if(menu.equals("team/member/list")
                && option == null) { // 5) 팀 정보 간단 출력
            onTeamMemberList(option);
        } else if(menu.equals("team/delete")) { // 11) 팀 정보 삭제
            onTeamMemberDelete(option);
        } else {
            System.out.println("명령어가 올바르지 않습니다.");
        }
    }

    // TeamMember 추가
    private void onTeamMemberAdd(String teamName) {
        System.out.println("[팀 정보 입력]");
        
        Team team = teamDao.get(teamName);
        if(team == null) {
            System.out.printf("%s 팀은 존재하지 않습니다.", teamName);
            return;
        }
        
        System.out.print("추가할 멤버의 아이디는?");
        String memberId = keyScan.nextLine();
        Member member = memberDao.get(memberId);
        
        if (member == null) {
            System.out.printf("%s 회원은 없습니다.\n", member);
            return;
        }
        
        if (team.isExist(memberId)) {
            System.out.println("이미 등록된 회원입니다.");
            return;
        }
        
        team.addMember(member);
    }
    
    
    
    // 팀 정보 조회
    private void onTeamMemberList(String teamName) {
        System.out.println("[팀 맴버 목록]");
        Team team = teamDao.get(teamName);  // 리스트 생성
        if(team == null) {
            System.out.printf("%s 팀은 존재하지 않습니다.", teamName);
            return;
        }
        
        System.out.print("회원들: ");
        // 여기서 리스트 출력
        for(int i =0; i < team.members.length; i++) {
            if (team.members[i] == null) continue;
            System.out.print(team.members[i].getID() + ", ");
        }
        System.out.println();
    }

    
    private void onTeamMemberDelete(String teamName) {
        Team team = new Team();
        team = teamDao.get(teamName);
        
        if(team == null) {
            System.out.printf("%s 팀은 존재하지 않습니다.", teamName);
            return;
        }
        
        System.out.print("삭제할 팀원은? ");
        String memberId = keyScan.nextLine();
        
        if (!team.isExist(memberId)) {
            System.out.println("이 팀의 회원이 아닙니다.");
            return;
        }
        
        team.deleteMember(memberId);
        
        System.out.println("[팀 맴버 삭제]");
        System.out.println("삭제하였습니다.");
    }
        
}

// ver 13 - 시작일, 종료일을 문자열로 입력 받아 Date 객체로 변환하여 저장