// 매서드 : 리팩토리
package step06;

import java.util.Scanner;

public class Exam01_3 {
    
    // 스페이스 출력하는 코드들을
    // 관리하기 쉽도록 별도의 블록에 모아 놓는다.
    // 그리고 그 블록에 대해 이름을 붙인다.
    // => 이렇게 정의한 블록을 "메서드(method)" 또는 
    //    "함수(function)" 이라 불린다.
    // => 자바는 "메서드" 이름을 주로 사용한다.
    public static void printSpaces(int len) {
        for(int i = 0; i < len; i++) {
            System.out.print(" ");
        }
    }

    // * 문자를 출력하는 코드를 관리하기 쉽게 별도의 블록으로 빼둔다.
    // 그리고, 그 블록의 이름을 붙인다.
    // 이렇게 별도로 빼둔 코드 블록에 이름을 붙인 것을 "메서드 = 함수" 라고 부른다.
    public static void printStar(int len) {
        for(int i = 0 ; i < len; i++) {
            System.out.print("*");
        }
    }

    // 코드를 유지보수하기 쉽도록 가능한 기능 별로 묶어 둔다.
    // 그래서 Exam01_2에 있던 코드 중에서 공백을 계산하는 코드를
    // 별도의 블록으로 분리하여 이름을 부여한다.
    public static int getSpaceLength(int totalStar, int displayStar) {
        return (totalStar - displayStar) / 2;
    }
    public static void main(String[] args) {
        int len;    // 밑변 길이를 정의

        Scanner sc = new Scanner(System.in);

        System.out.print("밑변 길이? ");
        len = sc.nextInt();

        for(int starLen = 1; starLen <= len; starLen +=2) {
            // 출력할 스페이스의 개수를 게산하는 코드를
            // 블록에 묶어 놓고 이름을 부여해두고 사용하면
            // 코드를 이해하기 쉽다.
            int spaceLen = getSpaceLength(len, starLen);
            printSpaces(spaceLen);
            printStar(starLen);
            System.out.println();
        }
    }
}