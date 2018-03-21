package bitcamp.java106.pms.domain; // java폴더가 루트

public class Board implements BoardInput {
    private String title;
    private String detail;
    private String register;

    public Board() {
        this.title = "";
        this.detail = "";
        this.register = "";
    }

    public Board(String title, String detail, String register) {
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
    public void setRegister(String register) {
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
    public String getRegister() {

        return register;
    }
}