package bitcamp.java106.pms.controller;

import java.util.Scanner;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.dao.CalcDao;

@Component("calc")
public class CalcController implements Controller {

    private Scanner keyScan;
    private CalcDao calcDao = new CalcDao();
    public CalcController() {
        this.keyScan = new Scanner(System.in);
    }
    
    public CalcController(Scanner keyScan) {
        this.keyScan = keyScan;
    }
    
    @Override
    public void service(String menu, String option) {
        System.out.println("식을 입력하세요.");
        String[] arr = keyScan.nextLine().split(" ");
        switch(arr[1]) {
        case "+":
            calcDao.plus(arr[1], arr[0], arr[2]);
            break;
        case "-":
            calcDao.minus(arr[1], arr[0], arr[2]);
            break;
        case "*":
            calcDao.times(arr[1], arr[0], arr[2]);
            break;
        case "/":
            calcDao.divide(arr[1], arr[0], arr[2]);
            break;
        default:
            System.out.println(arr[1]+" 연산은 존재하지 않습니다.");
        }
    }
    

}
