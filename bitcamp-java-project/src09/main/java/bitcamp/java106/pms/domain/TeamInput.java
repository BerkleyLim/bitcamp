package bitcamp.java106.pms.domain; // java폴더가 루트

// 팀의 대한 인터페이스 구현
public interface TeamInput {
    public void setName(String name);
    public String getName();
    public void setDescription(String description);
    public String getDescription();
    public void setMaxQty(String maxQty);
    public String getMaxQty();
    public void setStartDate(String startDate);
    public String getStartDate();
    public void setEndDate(String endDate);
    public String getEndDate();
}