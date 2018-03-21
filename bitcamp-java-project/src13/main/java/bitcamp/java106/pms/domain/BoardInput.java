package bitcamp.java106.pms.domain; // java폴더가 루트

import java.sql.Date;

public interface BoardInput {
    public void setTitle(String title);
    public void setDetail(String detail);
    public void setRegister(Date register);

    public String getTitle();
    public String getDetail();
    public Date getRegister();
}