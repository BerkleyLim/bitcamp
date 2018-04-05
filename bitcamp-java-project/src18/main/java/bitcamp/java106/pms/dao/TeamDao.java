package bitcamp.java106.pms.dao;

import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.util.ArrayList;

public class TeamDao {
    ArrayList collection = new ArrayList();
    
    public void insert(Team team) {
        collection.add(team);
    }
    
    public Team[] list() {
        Team[] teams = new Team[collection.size()];
        for(int i = 0; i < collection.size(); i++) {
            teams[i] = (Team) collection.get(i);
        }
        return teams;
    }
    
    public Team get(String name) {
        int i;
        if ((i = this.getTeamIndex(name)) != -1)
            return (Team) collection.get(i);
        return null;
    }
    
    public void update(Team team) {
        int i;
        if ((i = this.getTeamIndex(team.getName())) != -1)
            collection.set(i, team);
    }
    
    public void delete(String name) {
        int i;
        if ((i = this.getTeamIndex(name)) != -1) 
            collection.remove(i);
    }
    
    private int getTeamIndex(String name) {
        for (int i = 0; i < collection.size(); i++) {
            Team tm = (Team) collection.get(i);
            if (name.equals(tm.getName().toLowerCase())) {
                return i;
            }
        }
        return -1;
    }
}

//ver 18 - ArrayList 클래스를적용하여 객체(의 주소)를 사용한다.
//ver 16 - 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
//ver 14 - TeamController로부터 데이터 관리 기능을 분리하여 TeamDao 생성.




