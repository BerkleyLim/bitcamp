package bitcamp.java106.pms.domain; // java폴더가 루트

// ID의 대한 인터페이스 생성
public interface MemberInput {
    public void setID(String id);
    public String getID();
    public void setEmail(String email);
    public String getEmail();
    public void setPassWord(String passWord);
    public String getPassWord();
}