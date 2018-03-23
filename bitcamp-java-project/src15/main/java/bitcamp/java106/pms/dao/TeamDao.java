// Data Access Object
package bitcamp.java106.pms.dao;

import java.util.Scanner;

import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Team;

public class TeamDao extends MemberDao {
    private Team[] teams = new Team[1000]; // 팀 클래스 배열 생성
    private int teamIndex = 0; // 팀 입력 갯수 설정
    private static int i = 0; // 반복자 설정
    static Scanner sc = new Scanner(System.in);  // 상속용으로 생성자 두기 위해 사용
    // 이것을 2차원 배열을 쓰는 이유는
    // String[팀단위][팀이름 : 회원이름] 각각 따로 저장하도록 해야 한다!!!!!
    // 여기서 teamMembers[팀명용][0] = 팀이름
    // teamMembers[팀명용][1부터는] = 회원이름
    private String[][] teamMembers = new String[1000][1000];
    // 해당 팀의 회원 수 저장 용도 arrMember[0] : 0번째 팀명, arrMember[1부터] = 회원 숫자
    // teamMembers[팀명][arrMember[]] 용
    private int[] arrMember = new int[1000]; // 
    
    
    public TeamDao() { 
        //super(sc);
    }
    
    // Team 정보 생성
    public void insert(Team team) {
        // TeamController 클래스에서 입력 받아온 내용을 그대로 teams에 저장
        teamMembers[teamIndex][0] = team.getName();  // 미리 팀을 저장
        arrMember[teamIndex] = 1;
        teams[teamIndex++] = team;
    }
    
    // Team 리스트 생성
    public Team[] teamList() {
        // 입력한 Team 정보만 반환하기 위해 arr를 생성한다.
        Team[] arr = new Team[teamIndex];
        for(int i = 0; i < teamIndex; i++) {
            arr[i] = teams[i];
            
        }
        return arr;
    }
    
    // 입력한 Team의 해당 정보 내용을 색인한다.
    public Team getTeamIndex(String option) {
        for(i =0; i < teamIndex; i++) {
            if(teams[i] == null) continue;
            if(option.equals(teams[i].getName())) {
                return teams[i];
            }
        }
        return null;
    }
    
    // 팀 갱신
    public void update(Team team) {
        teams[i] = team;
    }
    
    // 팀 삭제
    public void delete(Team team) {
        teams[i] = null;
    }
    
    // ---- 유지 보수 시작 ------
    // team/member 부터
    // 팀 검사!
    public Team searchTeam(String option) {
        if(option == null) {
            System.out.println("팀명 입력!");
            return null;
        }
        
        // 해당팀 여부 검사
        Team team = getTeamIndex(option);
        
        // 팀을 찾지 못하면
        if(team == null) {
            System.out.println(option +" 팀은 존재하지 않습니다.");
            return null;
            
          // 팀을 찾으면
        } else {
            return team;
        }
    }
    
    // 보류
    public void teamMemberInsert(String name, String id) {
        // 회원 정보 색인
        Member members = getMemberIndex(id);

        // 먼저 팀 색인
        for(int i = 0; i < teamIndex; i++) {
            // 팀 색인이 되어 지면, 회원 넣기
            if(teamMembers[i][0].equals(name)) {
                if(members == null) {
                    System.out.println(id + " 회원이 없습니다.");
                    return;
                } else {
                    for(int j = 1; j <= arrMember[i]; j++) {
                        if(teamMembers[i][j] != null) {
                            if (teamMembers[i][j].equals(id)) {
                                System.out.println("이미 존재하는 회원입니다.");
                                return;
                            }
                        } else {
                            teamMembers[i][j] = new String();
                            teamMembers[i][j] = id;
                            arrMember[i]++;

                            System.out.println("생성되었습니다.");
                            return;
                        }
                    }
                    
                }

            }
            
        }
    }
    
    // 팀 맴버 리스트
    public String[] teamMemberLists(String name) {
        if(name == null) return null;
        for(int i = 0; i < teamIndex; i++) {
            // 팀 색인이 되어 지면, 회원 넣기
            if(teamMembers[i][0].equals(name)) {
                // 리스트 저장
                String[] str = new String[arrMember[i]];
                for(int j = 1; j < arrMember[i]; j++) {
                    //if(teamMembers[i][j] == null) continue;
                    str[j] = teamMembers[i][j];
                }
                
                return str;
            }
        }
        return null;
    }
    
    // 팀 삭제
    public void teamMemberDeletes(String name) {
        if(name == null) return;
        for(int i = 0; i < teamIndex; i++) {
            // 팀 색인이 되어 지면, 회원 넣기
            if(teamMembers[i][0].equals(name)) {
                System.out.print("삭제할 팀원은? ");
                String str = sc.nextLine();
                // 리스트 삭제!!
                for(int j = 1; j < arrMember[i]; j++) {
                    if(teamMembers[i][j] == null) continue;
                    if(teamMembers[i][j].equals(str)) {
                        System.out.println("삭제하였습니다.");
                        teamMembers[i][j] = null;
                        return;
                    }
                }
                System.out.println("해당 팀이 아닙니다.");
                return;
            }
        }
    }
    
}
