// 흐름 제어문 - switch 사용 후
package step05;

import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;

public class Exam02_2 {
    public static void main(String[] args) {
        int no;        // 지원 부서 번호용 변수
        Scanner sc = new Scanner(System.in);    // 입력 변수 생성!!!

        // 안내 메시지
        System.out.println("[지원부서]");
        System.out.println("1. S/W개발");
        System.out.println("2. 일반관리");
        System.out.println("3. 시설경비");
        System.out.print("지원 부서 번호를 입력하세요? : ");
        no = sc.nextInt();
        
        // switch 문 사용
        System.out.println("제출하실 서류는 다음과 같습니다.");
        switch (no) {
        case 1:
            System.out.println("정보처리자격증");
        case 2:
            System.out.println("졸업증명서");
        case 3:
            System.out.println("이력서");
            break;  // 여기까지만 실행한다.
        default:
            System.out.println("올바른 번호를 입력하세요!");
        }
        // no 값이 case에 해당되는 경우
        // break 명령을 만날 때 까지 아래로 계속 실행한다.!!!!!!!!


        /* if문과 switch문 비교
        System.out.println("제출하실 서류는 다음과 같습니다.");
        if(no == 1) {
            System.out.println("정보처리자격증");
            System.out.println("졸업증명서");
            System.out.println("이력서");
        } else if (no == 2) {
            System.out.println("졸업증명서");
            System.out.println("이력서");
        } else if (no == 3) {
            System.out.println("이력서");
        } else {
            System.out.println("올바른 번호를 입력하세요!");
        }
        */
    }
}