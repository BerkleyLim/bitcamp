package bitcamp.java106.pms.dao;

import bitcamp.java106.pms.util.ArrayList;

public class TeamMemberDao {
    // 여기서 2차원 배열 대신
    // Object[][] teamMembers = new Object[1000][2];
    private ArrayList teamCollection = new ArrayList();
    private ArrayList memberCollection = new ArrayList();
    
    private int getIndex(String teamName, String memberId) {
        for (int i = 0; i < teamCollection.size(); i++) {
            // 팀과 멤버가 둘다 일치시!!
            String tn = teamCollection.get(i).toString().toLowerCase();
            String mi = memberCollection.get(i).toString().toLowerCase();

            if (teamName.toLowerCase().equals(tn.toLowerCase())
                    && memberId.toLowerCase().equals(mi.toLowerCase())) {
                return i;
            }
        }
        return -1;
    }
    
    // 연산자는 외부에서 사용하는 것이기 때문에 공개해야 한다.
    // => 그래서 public modifier를 사용한다.
    public void addMember(String teamName, String memberId) {
        // 팀과 회원이 존재시
        if (isExist(teamName, memberId)) {
            return;
        }
        
        // 각 teamName과 memberId 생성
        teamCollection.add(teamName);
        memberCollection.add(memberId);
        
    }
    
    public int deleteMember(String teamName, String memberId) {
        int index = this.getIndex(teamName, memberId);
        
        // 존재하지 않은 멤버라면? 
        if (index < 0) {
            return 0;
        } else {
            teamCollection.remove(index);
            memberCollection.remove(index);
            return 1;
        }
        
    }
    
    public boolean isExist(String teamName, String memberId) {
        if(getIndex(teamName,memberId) < 0) {
            return false;
        } else {
            return true;
        }
    }
    
    private int getMemberCount(String teamName) {
        int cnt = 0;
        for (int i = 0; i < memberCollection.size(); i++) {
            String tn = ((String)teamCollection.get(i)).toLowerCase();
            if (tn.equals(teamName.toLowerCase())) {
                cnt++;
            }
        }
        return cnt;
    }

    // 메소드 시그너쳐
    public String[] getMembers(String teamName) {
        // 맴버 변수 선언
        String[] member = new String[getMemberCount(teamName)];
        
        // 리스트 검사
        for(int i = 0, x = 0 ; i < memberCollection.size(); i++) {
            String tn = ((String) teamCollection.get(i)).toLowerCase();
            if (teamName.toLowerCase().equals(tn)) {
                member[x++] = (String) memberCollection.get(i);
            }
        }
        return member;
    }
    
}
// 용어 정리!
// 메서드 시그너처(method signature) = 함수 프로토타입(function prototype)
// => 메서드의 이름과 파라미터 형식, 리턴 타입에 대한 정보를 말한다.


// ver 18 - ArrayList 적용
// ver 17 - 클래스 추가
