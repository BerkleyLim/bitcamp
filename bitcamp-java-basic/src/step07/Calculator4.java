// 메서드 분류 - 인스턴스 메서드 사용
package step07;

public class Calculator4 {
    int result = 0;
    
    
    // 인스턴스 변수
    // 인스턴스 변수를 다룰 때 인스턴스 메서드 사용하는 것이 편함!
    // 왜?
    // => 파라미터로 따로 인스턴스의 주소를 받을 필요가 없기 때문
    public void plus (int value) { 
        // 인스턴스 변수를 다루는 메서드는 작업을 수행할 때 그 인스턴스 주소를 받아야 한다.
        this.result += value; 
    }

    public  void minus (int value) {
        this.result -= value; 
    }

    public void multiple (int value) {
        this.result *= value;
    }
    
    public void divide (int value) {
        this.result /=value;
    }


}