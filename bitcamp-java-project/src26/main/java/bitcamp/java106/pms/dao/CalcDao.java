package bitcamp.java106.pms.dao;

import java.util.Scanner;

public class CalcDao {
    
    public void plus(String calc, String x, String y) {
        System.out.println(x + " "+ calc + " " + y + " = "
                + (Integer.parseInt(x) + Integer.parseInt(y)));
    }
    
    public void minus(String calc, String x, String y) {
        System.out.println(x + " "+ calc + " " + y + " = "
                + (Integer.parseInt(x) - Integer.parseInt(y)));
    }
    
    public void times(String calc, String x, String y) {
        int sum;
        System.out.println(x + " "+ calc + " " + y + " = "
                + (Integer.parseInt(x) * Integer.parseInt(y)));
    }
    
    public void divide(String calc, String x, String y) {
        int sum;
        System.out.println(x + " "+ calc + " " + y + " = "
                + (Integer.parseInt(x) / Integer.parseInt(y)));
    }
}
