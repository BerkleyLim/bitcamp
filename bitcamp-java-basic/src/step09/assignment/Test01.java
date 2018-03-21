package step09.assignment;

import java.util.Calendar;
import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year, month, date;   // 년, 월, 일 변수
        // 입력 안내
        System.out.print("년, 월, 일? (예: 2018 3 21) ");
        year = sc.nextInt();
        month = sc.nextInt();
        date = sc.nextInt();
        
        // 캘린더 클래스 생성
        Calendar c = Calendar.getInstance();
        // c.set(Calendar.YEAR, year);
        // c.set(Calendar.MONTH, month -1);
        // c.set(Calendar.DATE, day);
        c.set(year, month-1, date);
        // 출력 결과
        
        /*
        // 1) 요일
        switch(c.get(Calendar.DAY_OF_WEEK)) {
        case 1:
            System.out.println("요일 : 일요일");
            break;
        case 2:
            System.out.println("요일 : 월요일");
            break;
        case 3:
            System.out.println("요일 : 화요일");
            break;
        case 4:
            System.out.println("요일 : 수요일");
            break;
        case 5:
            System.out.println("요일 : 목요일");
            break;
        case 6:
            System.out.println("요일 : 금요일");
            break;
        case 7:
            System.out.println("요일 : 토요일");
            break;
        default:
        }
        */
        
        // 1) 요일
        String[] weeks = {"","일", "월","화","수","목","금","토"};
        
        //int i = c.get(Calendar.DAY_OF_WEEK);
        //System.out.println("요일: " + weeks[i] + "요일");
        System.out.println("요일: " + weeks[c.get(Calendar.DAY_OF_WEEK)] + "요일");
        // 2) 주차
        System.out.println("주차 : "+c.get(Calendar.WEEK_OF_MONTH)+"주차");
        
        // 3) 일자
        System.out.println("일자 : " +c.get(Calendar.DAY_OF_YEAR) + "일차");
    }
}
