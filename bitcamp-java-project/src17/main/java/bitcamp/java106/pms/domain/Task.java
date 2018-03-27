package bitcamp.java106.pms.domain;

import java.sql.Date;

public class Task {
    public String getTaskTitle() {
        return taskTitle;
    }
    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
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
    public String getMember() {
        return id;
    }
    public void setMember(String id) {
        this.id = id;
    }
    
    public void setNo(int no) {
        this.no= no;
    }
    
    public int getNo() {
        return no;
    }
    
    private String taskTitle;
    private Date startDate;
    private Date endDate;
    private String id;
    private int no; // 작업번호
    private Team[] team = new Team[1000];
    
    // 팀 색인
    /*
    public Team teamName(String name) {
        for(int i = 0; i < team.length; i++) {
            if(name == null) continue;
            if(name.equals(anObject))
            return team[i];
        }
    }
    */
}
