// 흐름 제어문 - break와 continue
package step05;

import java.util.Scanner;

public class Exam03_2 {
    public static void main(String[] args) {
        int count = 0;
        int sum = 0;

        // 1부터 100까지의 합은?
        while (count < 100) {
            count++;

            sum += count;
        }

        System.out.printf("sum=%d, count=%d\n",sum,count);
    }
}