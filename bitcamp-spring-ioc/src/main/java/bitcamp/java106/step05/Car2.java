package bitcamp.java106.step05;

import java.util.List;

public class Car2 {
    String model;
    String maker;
    int cc;
    Engine engine;
    List<Tire> tires;
    
    public Car2() {
        System.out.println("Car2() 생성자 호출됨!");
    }
    

    @Override
    public String toString() {
        return "Car2 [model=" + model + ", maker=" + maker + ", cc=" + cc
                + ", engine=" + engine + ", tires=" + tires + "]";
    }

    public List<Tire> getTires() {
        return tires;
    }


    public void setTires(List<Tire> tires) {
        this.tires = tires;
    }


    public Engine getEngine() {
        return engine;
    }
    public void setEngine(Engine engine) {
        System.out.println("Engine의 setEngine() 생성자 호출 됨");
        this.engine = engine;
    }


    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        System.out.println("setModel() 생성자 호출됨!");
        this.model = model;
    }
    public String getMaker() {
        return maker;
    }
    public void setMaker(String maker) {
        System.out.println("setMaker() 생성자 호출됨!");
        this.maker = maker;
    }
    public int getCc() {
        return cc;
    }
    public void setCc(int cc) {
        System.out.println("setCc() 생성자 호출됨!");
        this.cc = cc;
    }
    
    
}
