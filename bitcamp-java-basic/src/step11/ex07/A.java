package step11.ex07;

// 모든 클래스들은 대부분 Object의 서브 클래스
public class A /* extends Object */{
    protected int v1;
    
    // A 클래스는 기본 생성자가 없다.
    // => int 값을 받는 생성자만 있다.
    // 
    A(int value) {
        this.v1 = value;
        System.out.println("A() 생성자");
    }
}


//