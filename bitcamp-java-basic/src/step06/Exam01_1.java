// 매서드 : 사용 전
package step06;

import java.util.Scanner;

public class Exam01_1 {
    public static void main(String[] args) {
        int len;    // 밑변 길이를 정의

        Scanner sc = new Scanner(System.in);

        System.out.print("밑변 길이? ");
        len = sc.nextInt();

        int starLen = 1;
        while(starLen <= len) {
            int spaceCnt = 1;
            int spaceLen = (len - starLen) / 2;
            // 공백
            while(spaceCnt <= spaceLen) {
                System.out.print(" ");
                spaceCnt++;
            }

            int starCnt = 1;
            // 별
            while(starCnt <= starLen) {
                System.out.print("*");
                starCnt++;
            }
            starLen += 2;
            System.out.println();
        }
    }
}