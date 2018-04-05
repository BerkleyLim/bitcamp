// 클래스의 종류 : 중첩 클래스 요약 정리
package step17.ex01;

// 패키지 맴버 클래스
class A{}

public class Exam01_7 {
    
    // static nested class
    static class B {}
    
    // non-static nested class = inner class
    class C {}
    
    public static void main(String[] args) {
        
        // local class
        class D {}
        
        // anonymous class
        Object obj = new Object() {};
    }
}
