package step19.ex09;

@Component // 기본 이름으로 (클래스) 이름으로 저장해주세요
public class Engine {

    public Engine() {
        System.out.println("===> Engine()");
    }
    
    public void run() {
        System.out.println("엔진을 가동");
    }
}
