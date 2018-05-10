package bitcamp.java106.step05;

import java.util.Map;
import java.util.Properties;

public class Car4 {
    String model;
    String maker;
    int cc;
    Properties options;
    
    
    @Override
    public String toString() {
        return "Car3 [model=" + model + ", maker=" + maker + ", cc=" + cc
                + ", options=" + options + "]";
    }


    public Properties getOptions() {
        return options;
    }


    public void setOptions(Properties options) {
        this.options = options;
    }


    public Car4() {
        System.out.println("Car2() 생성자 호출됨!");
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
