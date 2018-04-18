// Reflection API : 클래스 로딩과 "class"라는 스태틱 변수
package step18.ex01;

public class Exam05 {
    
    static class A {
        void m() {
            System.out.println("Hello!");
        }
        
        static {
            System.out.println("A 클래스 로딩");
        }
    }
    
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("step18.ex01.Exam05$A");
        
        // 타입(클래스) 클래스 정보만 있다면 인스턴스 생성할 수 있다.
        A obj = (A) clazz.newInstance();
        obj.m();
    }
}
