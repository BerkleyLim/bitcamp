package bitcamp.java106.pms.domain; // java폴더가 루트

import java.sql.Date;

public class Board {
    private String title;
    private String detail;
    private Date register;

    public Board() {
        this.title = "";
        this.detail = "";
        
    }

    public Board(String title, String detail, Date register) {
        this.title = title;
        this.detail = detail;
        this.register = register;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setRegister(Date register) {
        this.register = register;
    }

    public String getTitle() {

        return title;
    }

    public String getDetail() {

        return detail;
    }

    public Date getRegister() {

        return register;
    }
}