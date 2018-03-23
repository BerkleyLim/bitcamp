package bitcamp.java106.pms.domain; // java폴더가 루트

import java.sql.Date;

public class Team {
    private String name;        // 팀명
    private String description; // 설명
    private String maxQty;      // 최대 인원
    private Date startDate;   // 시작일
    private Date endDate;     // 종료일

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