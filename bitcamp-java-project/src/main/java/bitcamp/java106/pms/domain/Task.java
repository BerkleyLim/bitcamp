package bitcamp.java106.pms.domain;

import java.io.Serializable;
import java.sql.Date;

public class Task implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    public static final int READY = 0;
    public static final int WORKING = 1;

    public static final int COMPLETE = 9;
    
    public static int count = 1;
    private int no;         // 내부적으로 쓰이는 작업번호(작업상태 조작 아님)


    private String title;    // 작업명
    private Date startDate;  // 시작일
    private int state;       // 작업상태 -> 0: 작업대기, 1: 작업중, 9: 완료
    private Date endDate;    // 종료일
    private Member worker;   // Member
    private Team team;       // Team
    
    public Task(Team team) {
        this.team = team;
        this.no = count++;
    }
    
    public Task(Team team, String title, Date startDate, Date endDate) {
        this(team);
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.state = READY;
    }
    
    // 
    public int getState() {
        return state;
    }
    public void setState(int state) {
        this.state = state;
    }
    public String getTitle() {
        return title;
    }
    public Member getWorker() {
        return worker;
    }
    public void setWorker(Member worker) {
        this.worker = worker;
    }
    public Team getTeam() {
        return team;
    }
    public void setTeam(Team team) {
        this.team = team;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Task [title=" + title + ", startDate=" + startDate + ", state=" + state + ", endDate=" + endDate
                + ", worker=" + worker + ", team=" + team + "]";
    }
    
}

// ver17 - 사용자 정의 데이터 타입 생성