package bitcamp.java106.pms.domain;

import java.sql.Date;

public class Classroom {
    private static int count;
    
    private int no;            // 인덱스 번호
    private String className;  // 수업명
    private Date startDate;    // 시작일
    private Date endDate;      // 종료일
    private String classNumber;  // 교실번호
    
    public Classroom() {
        this.no = ++count;
    }
    
    @Override
    public String toString() {
        return "Classroom [no=" + no + ", className=" + className + ", startDate=" + startDate + ", endDate=" + endDate
                + ", classNumber=" + classNumber + "]";
    }

    // 설정자 반환자
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
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
    public String getClassNumber() {
        return classNumber;
    }
    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }
    
    
}
