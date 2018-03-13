// 흐름 제어문 - if~ else if ~ else if ~ else
package step05;

import java.util.Scanner;

public class Exam01_7 {
    public static void main(String[] args) {
        int age;        // 나이 변수
        Scanner sc = new Scanner(System.in);    // 입력 변수 생성!!!

        // 안내 메시지
        System.out.print("나이 입력 : ");
        age = sc.nextInt();

        // if ~ else ~ 는 한 문장이기 때문에
        // if ~ else ~ 만 있다면 블록으로 묶지 않아도 된다.
        if (age < 8)
            System.out.println("아동입니다.");
        else 
            if (age < 14)
                System.out.println("어린이입니다.");
            else 
                if (age < 19)
                    System.out.println("청소년입니다.");
                else 
                    if (age < 65)
                        System.out.println("성인입니다.");
                    else
                        System.out.println("노인입니다.");
                        
                        
        // if ~ else를 보기 좋게 정렬하자!!
        // 실무에서는 다음과 같이 정렬한다!!!
        // 주의!
        // else if 라는 문법은 없다.
        // 그냥 다음과 같이 정렬한 것이다.
        if (age < 8)
            System.out.println("아동입니다.");
        else if (age < 14)
            System.out.println("어린이입니다.");
        else if (age < 19)
            System.out.println("청소년입니다.");
        else if (age < 65)
            System.out.println("성인입니다.");
        else
            System.out.println("노인입니다.");
    }
}