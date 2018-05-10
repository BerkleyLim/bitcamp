package bitcamp.java106.step05;

public class Engine {
    String maker;
    int valve;
    int cylinder;
    
    public Engine() {
        System.out.println("Engine() 생성자 호출 됨");
    }
    
    @Override
    public String toString() {
        return "Engine [maker=" + maker + ", valve=" + valve + ", cylinder="
                + cylinder + "]";
    }
    
    

    public String getMaker() {
        return maker;
    }
    public void setMaker(String maker) {
        System.out.println("Engine의 setMaker() 생성자 호출 됨");
        this.maker = maker;
    }

    public int getValve() {
        return valve;
    }
    public void setValve(int valve) {
        System.out.println("Engine의 setValve() 생성자 호출 됨");
        this.valve = valve;
    }

    public int getCylinder() {
        return cylinder;
    }
    public void setCylinder(int cylinder) {
        System.out.println("Engine의 setCylinder() 생성자 호출 됨");
        this.cylinder = cylinder;
    }
}
