// 생성자 활용 예 - java.util.Date 클래스와 생성자
package step09;

import java.util.Date;

public class Exam01_2 {

    public static void main(String[] args) throws Exception {
        // java.util.Date 클래스는 날짜 데이터를 다루는 클래스이다.
        // => 이 클래스에는 날짜 데이터를 다룰 수 있는 다양한 메서드가 들어 있다.
        
        // Date() 기본 생성자는 메모리르 오늘 날짜 값으로 초기화시긴다.
        Date d1 = new Date();
        System.out.println(d1);
        
        // 년 월, 일 값으로 날짜 인스턴스를 초기화 시킨다.
        // 생성자는 년도에서는 1900 + x (x는 자기가 입력한 숫자)
        Date d2 = new Date(2018-1900, 3, 20); // @Deprecated <- 신호로 취소선으로 표시
                                            // 자세한 것은 java.util.Date 클래스 참조
                                            // 이 방법은 사용을 가급적 자제해라!
        System.out.println(d2);
        
        // 1970년 1월 1일 0시 0분 0초부터 측정된 밀리초를 가지고 
        // 날짜 인스턴스(객체=메모리) 초기화 시킨다.
        // 1초(1000m/sec) * 1분(60sec) * 1시간(60min) * 1일(24h) * 1년(365day) * 50년후
        Date d3 = new Date(1000L * 60 * 60 * 24 * 365 * 50);
        System.out.println(d3);
        
    }
}

