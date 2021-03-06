// 인터페이스 다중 상속
package step14.ex04;

// 인터페이스는 다중 상속이 가능하다.
// 왜? 아직 구현하기 전의 메서드이기 때문에
// 어떤 인터페이스의 메서드를 상속 받더라도 똑같다.
public interface C extends B, A {
    void m2();
    void m3();
    void m1();
}
