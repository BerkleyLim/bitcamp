package bitcamp.java106.pms.domain; // java폴더가 루트


public class Member{
    private String id;
    private String email;
    private String passWord;

    public Member(){
        this.id = "";
        this.email = "";
        this.passWord = "";
    }

    public Member(String id, String email, String passWord) {
        this.id = id;
        this.email = email;
        this.passWord = passWord;

    }

    // id 설정자 및 반환자
    public void setID(String id) {
        this.id = id;
    }

    public String getID() {
        return id;
    }

    // email 설정자 및 반환자
    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    // 비밀번호 설정자 및 반환자
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPassWord() {
        return passWord;
    }
}