package bitcamp.java106.pms.domain; // java폴더가 루트

import java.sql.Date;

public class Board implements BoardInput {
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

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public void setRegister(Date register) {
        this.register = register;
    }

    @Override
    public String getTitle() {

        return title;
    }

    @Override
    public String getDetail() {

        return detail;
    }

    @Override
    public Date getRegister() {

        return register;
    }
}