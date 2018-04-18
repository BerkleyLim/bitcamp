// 의존 객체 Engine을 자체적으로 만들지 않고 외부에서 주입 받는다.
package step19.ex09;

@Component(value="car") // 이름으로 저장해주세요
public class Car {
    Engine engine;

    public Car(Engine engine) {
        System.out.println("===> Car(Engine)");
        this.engine = engine;
    }
    
    public void move() {
        engine.run();
    }
}
