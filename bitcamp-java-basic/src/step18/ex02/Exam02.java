// 클래스 정보 추출 - 클래스의 수퍼 클래스 정보 알아내기
package step18.ex02;

public class Exam02 {
    static class A {}
    static class B extends A {}
    static class C extends B {}
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("step18.ex02.Exam02$C");
        
        Class superClazz = clazz.getSuperclass(); // 슈퍼클래스 정보 나타냄 OK!!
        System.out.println(superClazz.getName());
        
    }
}
