// 회원 데이터 관리를 위한 클래스
package bitcamp.java106.pms.dao;

import bitcamp.java106.pms.domain.Member;

public class MemberDao {
    private static int i = 0;   // 색인 후 결과용 인덱스
    private Member[] members = new Member[1000];
    private int memberIndex = 0;
    
    public MemberDao() { }
    
    // 회원 생성 메서드
    public void insert(Member member) {
        members[memberIndex++] = member;
    }
    
    // 회원 리스트 
    public Member[] list() {
        Member[] arr = new Member[memberIndex];
        // null pointer exception 방지를 위해 arr에 따로 저장한다.
        for(int i = 0 ; i < memberIndex ; i++) {
            arr[i] = members[i];
        }
        return arr;
    }
    
    // 회원의 대한 정보 색인 하는 메서드, 찾으면 해당 members[i]의 방을 리턴, 못찾으면 null로 리턴
    public Member get(String option) {
        int i = this.getMemberIndex(option);
        if (i == -1)
            return null;
        return this.members[i];
    }
    
    // 회원의 대한 업데이트 하기!!
    public void update(Member member) {
        int i = this.getMemberIndex(member.getID());
        if (i != -1)
            this.members[i] = member;
    }
    
    /*
     * 또 다른 업데이트 함수 지정방법 - 여기서는 그냥 비효율적이라 
     * public void update(Member member) {
     *     for (int i = 0; i < memberIndexl i++) {
     *         if (members[i] == null) continue;
     *         if (member.equals(this.members[i].getID())) {
     *             this.members[i] = member;
     *             break;
     *         } 
     *     }
     * }
     */
    
    // 회원 삭제!!
    public void delete(String id) {
        int i = this.getMemberIndex(id);
        if (i != -1)
            this.members[i] = null;
    }
    
    // 다음 메서드는 내부에서만 사용할 것이기 때문에 공개하지 않는다.
    private int getMemberIndex(String id) {
        for (int i = 0; i < this.memberIndex; i++) {
            if (this.members[i] == null) continue;
            if (id.equals(this.members[i].getID().toLowerCase())) {
                return i;
            }
        }
        return -1;
    }
    
}
