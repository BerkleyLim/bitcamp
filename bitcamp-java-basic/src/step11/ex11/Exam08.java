// 오버라이딩(Overriding) - this와 super로 메서드를 찾는 호출하는 원리
package step11.ex11;

public class Exam08 {
    public static void main(String[] args) {
        X4 obj = new X4();
        obj.m1();
        obj.m2();
        obj.test();
    }
}

// this.메서드() 호출?
// => 현재 클래스부터 호출할 메서드를 찾는다.

// super.메서드() 호출?
// => 부모 클래스부터 호출할 메서드를 찾는다.