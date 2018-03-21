package bitcamp.java106.pms.domain; // java폴더가 루트

public interface BoardInput {
    public void setTitle(String title);
    public void setDetail(String detail);
    public void setRegister(String register);

    public String getTitle();
    public String getDetail();
    public String getRegister();
}