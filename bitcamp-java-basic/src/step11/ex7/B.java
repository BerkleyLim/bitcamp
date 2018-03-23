// 기존의 클래스를 손대지 않고 새 기능만 추가한다.
// 어떻게? 상속 문법을 이용한다.
package step11.ex7;

public class B extends A {
    int v2;

    B() {
        // 수퍼 클래스의 어떤 생성자를 호출할지 지정하지 않으면 컴파일러는
        // 다음과 같이 수퍼 클래스의 기본 생성자를 호출하라는 명령을 붙인다.
        //super();
        // 만약 수퍼 클래스에 기본 생성자가 없으면 컴파일 오류가 발생한다.
        // super()라는 메서드 없이 사용하고 싶다면,
        // A로 상속을 받으면 A의 대한 기본 생성자 A()가 있어야만이 한다.
        
        // 해결방법?
        // => 개발자가 직접 수퍼 클래스에 있는 다른 생성자를 호출하라!
        super(100);
        System.out.println("B() 생성자");
    }
    

}
