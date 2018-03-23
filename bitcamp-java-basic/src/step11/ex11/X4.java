package step11.ex11;

public class X4 extends X3 {
    @Override
    void m1() {
        System.out.println("X4의 m1()");
    }
    
    void test() {
        this.m1();  // X4의 m1()
        super.m1(); // X3의 m1() 단, X3에 m1()이 없어서 X2의 m1() 으로
        //super.super.m1(); // 컴파일 오류! 이런 문법은 없다! 무협지 문법!
        
        this.m2(); // X3의 m2()
        super.m2(); // X3의 m2()
    }

}
