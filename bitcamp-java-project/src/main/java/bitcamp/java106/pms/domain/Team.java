package bitcamp.java106.pms.domain; // java폴더가 루트

import java.sql.Date;

// Team 클래스
// => 팀 정보를 저장할 수 있는 메모리를 구조를 설계한 클래스이다.
// => 즉, 팀 정보를 위해 사용자(자바 언어 사용자. 즉 개발자)가 새로 정의한 데이터 타입이다.
public class Team {
    private String name;        // 팀명
    private String description; // 설명
    private String maxQty;      // 최대 인원
    private Date startDate;   // 시작일
    private Date endDate;     // 종료일
    public Member[] members = new Member[10];
    
    // 메서드 정의
    // => 새 데이터 타입의 값을 다룰 연산자를 정의하는 것을 의미한다.
    
    // 연산자는 외부에서 사용하는 것이기 때문에 공개해야 한다.
    // => 그래서 public modifier를 사용한다.
    public int addMember(Member member) {
        for (int i = 0; i < this.members.length; i++) {
            if (members[i] == null) {
                members[i] = member;
                System.out.println("추가하였습니다.");
                return 1;
            }
        }
        return 0;
    }
    
    public int deleteMember(String memberId) {
        for (int i = 0; i < members.length; i++) {
            if (members[i] == null) continue;
            if (members[i].getID().equals(memberId)) {
                members[i] = null;
                return 1;
            }
        }
        return 0;
    }
    
    public boolean isExist(String memberId) {
        for (int i = 0; i < members.length; i++) {
            if (members[i] == null) continue;
            if (members[i].getID().equals(memberId)) {
                return true;
            }
        }
        return false;
    }
    
    public Team() {
        this.name = "";
        this.description = "";
        this.maxQty = "0";
    }

    public Team(String team, String description, String maxQty, 
          Date startDate, Date endDate) {
        this.name = team;
        this.description = description;
        this.maxQty = maxQty;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // 팀명 설정자 및 반환자

    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    // 설명 설정자 및 반환자
    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }


    // 최대인원 설정자 및 반환자
    public void setMaxQty(String maxQty){
        this.maxQty = maxQty;
    }

    public String getMaxQty(){
        return maxQty;
    }

    // 시작일 설정자 및 반환자
    public void setStartDate(Date startDate){
        this.startDate = startDate;
    }

    public Date getStartDate(){
        return startDate;
    }

    // 종료일 설정자 및 반환자
    public void setEndDate(Date endDate){
        this.endDate = endDate;
    }

    public Date getEndDate(){
        return endDate;
    }
}

// ver 15 - 멤버를 저장할 인스턴수 변수를 추가한다.