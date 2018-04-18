package bitcamp.java106.pms.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import bitcamp.java106.pms.annotation.Component;

@Component
public class TeamMemberDao {
    private HashMap<String, ArrayList<String>> collection = new HashMap<>();
    
    private ArrayList<String> getTeamMembers(String teamName) {
        // 팀 이름으로 멤버 아이디가 들어 있는 ArrayList를 가져온다.
        ArrayList<String> members = collection.get(teamName);
        
        if (members == null) { // 해당 팀의 맴버가 추가된 적이 없다면,
            members = new ArrayList<>();
            collection.put(teamName, members);
        }
        
        return members;
    }
    
    public int addMember(String teamName, String memberId) {
        String teamNameLC = teamName.toLowerCase();
        String memberIdLC = memberId.toLowerCase();
        
        // 팀 이름으로 멤버 아이디가 들어 있는 ArrayList를 가져온다.
        ArrayList<String> members = collection.get(teamNameLC);
        
        if (members == null) { // 해당 팀의 맴버가 추가된 적이 없다면,
            members = new ArrayList<>();
            members.add(memberIdLC);
            collection.put(teamNameLC, members);
            return 1;
        }
        
        // ArrayList에 해당 아이디를 가진 맴버가 들어 있다면,
        if (members.contains(memberIdLC)) {
            return 0;
        }
        
        // 각 teamName과 memberId 생성
        members.add(memberIdLC);
        collection.put(teamName.toLowerCase(), members);
        return 1;
    }
    
    public int deleteMember(String teamName, String memberId) {
        String teamNameLC = teamName.toLowerCase();
        String memberIdLC = memberId.toLowerCase();
        
        ArrayList<String> members = collection.get(teamNameLC);
        if (members == null || members.contains(memberIdLC)) {  // 존재하지 않는 멤버라면,
            return 0;
        }
        
        members.remove(memberIdLC);
        return 1;
    }
    

    public Iterator<String> getMembers(String teamName) {
        ArrayList<String> members = collection.get(teamName.toLowerCase());
        if (members == null)
            return null;
        return members.iterator();
    }
    
    public boolean isExist(String teamName, String memberId) {
        String teamNameLC = teamName.toLowerCase();
        String memberIdLC = memberId.toLowerCase();
        
        ArrayList<String> members = collection.get(teamNameLC);
        
        if (members == null || members.contains(memberIdLC)) {  // 존재하지 않는 멤버라면,
            return false;
        } else {
            return true;
        }
    }
    
}

//ver 23 - @Component 애노테이션을 붙인다.
// ver 19 - 우리 만든 ArrayList 대신 java.util.LinkedList를 사용하여 목록을 다룬다.
// ver 18 - ArrayList 적용
// ver 17 - 클래스 추가
