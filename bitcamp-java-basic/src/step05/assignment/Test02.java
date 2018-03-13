package step05.assignment;

import java.util.Scanner;
public class Test02 {
    public static void main(String[] args) {
        int num;   

        Scanner sc = new Scanner(System.in);

        System.out.print("밑변 길이? ");
        num = sc.nextInt();

        // 직사각형 출력!! - while 문
        int i = 0;
        while(i < num) {
            int j = 0;
            while(j <= i) {
                System.out.print("*");
                j++;
            }
            System.out.println();
            i++;
        }

        i--;

        while(i > 0) {
            int j = 0;
            while(j < i) {
                System.out.print("*");
                j++;
            }
            System.out.println();
            i--;
        }

        System.out.println("--------------------------------------");

        // do ~ while문형
        i = 0;
        do {
            int j = 0;
            do {
                System.out.print("*");
                j++;
            } while(j <= i);
            System.out.println();
            i++;
        } while(i < num);
        
        i--;

        do {
            int j = 0;
            do {
                System.out.print("*");
                j++;
            } while(j < i);
            System.out.println();
            i--;
        } while(i > 0);
    }
}


/*
<강사님 코드>
package step05.assignment;

import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);
        System.out.println("밑변의 길이? ");
        int len = keyScan.nextInt();

        int count = 1;
        while(count <= len) {
            int starCnt = 1;
            while(StarCnt <= count) {
                System.out.print("*");
                StartCnt++;
            }
            System.out.println();
            count++;
        }

        count = len - 1;

        while(count >= 1) {
            int starCnt = 1;
            while(StarCnt <= count) {
                System.out.print("*");
                StartCnt++;
            }
            System.out.println();
            count--;
        }
    }
}
*/

/*
C:\Users\Bit\git\bitcamp\bitcamp-java-basic>java -cp bin step05.assignment.Test01
밑변 길이? 5
*
**
***
****
*****
*/