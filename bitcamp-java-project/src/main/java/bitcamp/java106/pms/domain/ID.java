package bitcamp.java106.pms.domain; // java폴더가 루트


public class ID implements IDInput {
    private String id;
    private String email;
    private String passWord;

    public ID(){
        this.id = "";
        this.email = "";
        this.passWord = "";
        setTeamInformation();
    }

    public ID(String id, String email, String passWord) {
        this.id = id;
        this.email = email;
        this.passWord = passWord;

    }

    // id 설정자 및 반환자
    @Override
    public void setID(String id) {
        this.id = id;
    }

    @Override
    public String getID() {
        return id;
    }

    // email 설정자 및 반환자
    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getEmail() {
        return email;
    }

    // 비밀번호 설정자 및 반환자
    @Override
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String getPassWord() {
        return passWord;
    }
}