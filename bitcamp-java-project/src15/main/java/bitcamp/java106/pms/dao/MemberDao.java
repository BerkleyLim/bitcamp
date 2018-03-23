// 회원 데이터 관리를 위한 클래스
package bitcamp.java106.pms.dao;

import bitcamp.java106.pms.domain.Member;

public class MemberDao {
    private static int i = 0;   // 색인 후 결과용 인덱스
    private static Member[] members = new Member[1000]; // TeamDao에서 함께 사용 할 수 있도록 
    protected static int memberIndex;  // TeamDao에서 함께 사용할 수 있도록
    
    public MemberDao() { }
    
    // 회원 생성 메서드
    public void insert(Member member) {
        members[memberIndex] = new Member();
        members[memberIndex++] = member;
    }
    
    // 회원 리스트 
    public Member[] memberList() {
        Member[] arr = new Member[memberIndex];
        // null pointer exception 방지를 위해 arr에 따로 저장한다.
        for(int i = 0 ; i < memberIndex ; i++) {
            arr[i] = members[i];
        }
        return arr;
    }
    
    // 회원의 대한 정보 색인 하는 메서드, 찾으면 해당 members[i]의 방을 리턴, 못찾으면 null로 리턴
    public Member getMemberIndex(String option) {
        for(i = 0; i < memberIndex; i++) {
            if (members[i] == null) continue;
            if (option.toString().equals(members[i].getID().toString())) {
                return members[i];
            }
        }
        return null;
    }
    
    // 회원의 대한 업데이트 하기!!
    public void update(Member member) {
        members[i] = member;
    }

    
    // 회원 삭제!!
    public void delete() {
        members[i] = null;
    }
    
}
