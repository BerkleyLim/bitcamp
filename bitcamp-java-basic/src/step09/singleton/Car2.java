// singleton 패턴 적용 후
package step09.singleton;

public class Car2 {
    // Car2 객체를 생성하면 다음 스태틱 변수에 보관해둔다
    private static Car2 instance;
    
    // 외부에서 생성자를 호출하지 못하도록 private으로 접근을 제한한다.
    private Car2() {
        System.out.println("Car2()");
    }
    
    // 생성자 호출을 막고 대신 해당 클래스를 메서드로 이용하여 외부에서 생성 가능
    public static Car2 getInstance() {
        // 여기서 한번만 instance를 생성하고자 할때의 조건
        if(instance == null)
            instance = new Car2();
        return instance;
    }
}
