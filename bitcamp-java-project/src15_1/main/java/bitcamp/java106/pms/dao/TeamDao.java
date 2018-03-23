// Data Access Object
package bitcamp.java106.pms.dao;

import bitcamp.java106.pms.domain.Team;

public class TeamDao {
    private Team[] teams = new Team[1000]; // 팀 클래스 배열 생성
    private int teamIndex = 0; // 팀 입력 갯수 설정
    private static int i = 0; // 반복자 설정
    
    public TeamDao() { }
    
    // Team 정보 생성
    public void insert(Team team) {
        // TeamController 클래스에서 입력 받아온 내용을 그대로 teams에 저장
        teams[teamIndex++] = team;
    }
    
    // Team 리스트 생성
    public Team[] list() {
        // 입력한 Team 정보만 반환하기 위해 arr를 생성한다.
        Team[] arr = new Team[teamIndex];
        for(int i = 0; i < teamIndex; i++) {
            arr[i] = teams[i];
        }
        return arr;
    }
    
    // 입력한 Team의 해당 정보 내용을 색인한다.
    public Team getIndex(String option) {
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
    
}
