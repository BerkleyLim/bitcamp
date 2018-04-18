package step22.ex09;

public class Member2 {
    String name;
    int age;
    boolean gender; // true(여자), false(남자)
    
 // Exam02_4.java 를 실행 전 3다음 변수를 추가하고, toString을 객체로 보낸다.
    String tel;

    @Override
    public String toString() {
        return "Member2 [name=" + name + ", age=" + age + ", gender=" + gender
                + ", tel=" + tel + "]";
    }
    

}
