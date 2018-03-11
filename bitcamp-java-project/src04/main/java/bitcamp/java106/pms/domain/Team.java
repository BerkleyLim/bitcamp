package bitcamp.java106.pms.domain; // java폴더가 루트

public class Team implements TeamInput {
    private String team;        // 팀명
    private String description; // 설명
    private String maxQty;      // 최대 인원
    private String startDate;   // 시작일
    private String endDate;     // 종료일


    public Team() {
        this.team = "";
        this.description = "";
        this.maxQty = "0";
        this.startDate = "";
        this.endDate = "";
    }

    public Team(String team, String description, String maxQty, 
          String startDate, String endDate) {
        this.team = team;
        this.description = description;
        this.maxQty = maxQty;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // 팀명 설정자 및 반환자
    @Override
    public void setTeam(String team) {
        this.team = team;
    }
    
    @Override
    public String getTeam() {
        return team;
    }

    // 설명 설정자 및 반환자
    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }


    // 최대인원 설정자 및 반환자
    @Override
    public void setMaxQty(String maxQty){
        this.maxQty = maxQty;
    }

    @Override
    public String getMaxQty(){
        return maxQty;
    }

    // 시작일 설정자 및 반환자
    @Override
    public void setStartDate(String startDate){
        this.startDate = startDate;
    }

    @Override
    public String getStartDate(){
        return startDate;
    }

    // 종료일 설정자 및 반환자
    @Override
    public void setEndDate(String endDate){
        this.endDate = endDate;
    }

    @Override
    public String getEndDate(){
        return endDate;
    }

}