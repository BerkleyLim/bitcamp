package bitcamp.java106.step05;

import java.util.Arrays;

public class Tire {
    String maker;
    int width;
    int radio;
    int wheel;
    Tire[] tires;
    
    @Override
    public String toString() {
        return "Tire [maker=" + maker + ", width=" + width + ", radio=" + radio
                + ", wheel=" + wheel + ", tires=" + Arrays.toString(tires)
                + "]";
    }
    
    public String getMaker() {
        return maker;
    }
    public void setMaker(String maker) {
        this.maker = maker;
    }
    
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    
    public int getRadio() {
        return radio;
    }
    public void setRadio(int radio) {
        this.radio = radio;
    }
    
    public int getWheel() {
        return wheel;
    }
    public void setWheel(int wheel) {
        this.wheel = wheel;
    }
    
    public Tire[] getTires() {
        return tires;
    }
    public void setTires(Tire[] tires) {
        this.tires = tires;
    }
    
    
}
