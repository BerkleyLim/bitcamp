// 6단계 : 형식을 갖춘 문자열 출력하기!!
package step02.assignment;

import java.io.InputStream;
import java.util.Scanner;

public class Test02 {
    public static void main(String[] args) {
        final int people = 5;                   // 기호 상수 지정
        String[] name = new String[people];     // 이름 선언
        int[] kor = new int[people];            // 국어 성적 선언
        int[] eng = new int[people];            // 영어 성적 선언
        int[] math = new int[people];           // 수학 성적 선언
        int sum;                                // 총합계 성적 선언
        double avg;                             // 평균 선언

        InputStream keyboard = System.in;       // 입력 받을 키보드 선언
        Scanner sc = new Scanner(keyboard);     // 입력 도구 선언

        // 각각 5명의 성적을 입력한다.
        for(int i = 0 ; i < people ; i++) {
            System.out.print("입력? ");

            name[i] = sc.next();
            kor[i] = sc.nextInt();
            eng[i] = sc.nextInt();
            math[i] = sc.nextInt();
            //sc.next();    // 빈칸 및 줄바꿈 스킵용
        }

        System.out.println("----------------------------------");

        for(int i = 0; i < people ; i++) {
            sum = kor[i] + eng[i] + math[i];
            avg = sum / 3; //
            System.out.println(name[i] + "  " + kor[i] + " " + eng[i] 
                       + " " + math[i] + " " + sum + " " + avg);
            
            // 또는
            //System.out.printf("%s  %d %d %d %d %lf\n", 
            //  name[i], kor[i], eng[i], math[i], sum, avg);
        }
    }
}

/*
C:\Users\Bit\git\bitcamp\bitcamp-java-basic>javac -encoding UTF-8 -d bin src/step02/assignment/Test02.java

C:\Users\Bit\git\bitcamp\bitcamp-java-basic>java -cp bin step02.assignment.Test02
입력? 홍길동 100 90 80
입력? 임꺽정 100 100 100
입력? 유관순 90 90 90
입력? 안중근 80 80 80
입력? 윤봉길 70 70 70
----------------------------------
홍길동  100 90 80 270 90.0
임꺽정  100 100 100 300 100.0
유관순  90 90 90 270 90.0
안중근  80 80 80 240 80.0
윤봉길  70 70 70 210 70.0
*/

/* 
<강사님 코드> // 2단계 : 5명의 성적을 입력 받아서 출력하기.
package step02.assignment;

public class Test01 {
    public static void main(String[] args) {
        java.io.InputStream keyboard = System.in;
        java.util.Scanner KeyScan = new java.util.Scanner(keyboard); 

        System.out.print("입력? ");
        String name1 = KeyScan.nextLine();
        int kor1 = KeyScan.nextInt();
        int eng1 = KeyScan.nextInt();
        int math1 = KeyScan.nextInt();

        int sum1 = kor1 + eng1 + math1;
        int avg1 = sum1 / 3;


        String name2 = KeyScan.nextLine();
        int kor2 = KeyScan.nextInt();
        int eng2 = KeyScan.nextInt();
        int math2 = KeyScan.nextInt();

        int sum2 = kor2 + eng2 + math2;
        int avg2 = sum2 / 3;

        String name3 = KeyScan.nextLine();
        int kor3 = KeyScan.nextInt();
        int eng3 = KeyScan.nextInt();
        int math3 = KeyScan.nextInt();


        int sum3 = kor3 + eng3 + math3;
        int avg3 = sum3 / 3;

        String name4 = KeyScan.nextLine();
        int kor4 = KeyScan.nextInt();
        int eng4 = KeyScan.nextInt();
        int math4 = KeyScan.nextInt();

        int sum4 = kor4 + eng4 + math4;
        int avg4 = sum4 / 3;

        String name5 = KeyScan.nextLine();
        int kor5 = KeyScan.nextInt();
        int eng5 = KeyScan.nextInt();
        int math5 = KeyScan.nextInt();

        int sum5 = kor5 + eng5 + math5;
        int avg5 = sum5 / 3;

        System.out.println("-----------------------");

        System.out.print(name1);
        System.out.print("  ");
        System.out.print(kor1);
        System.out.print("  ");
        System.out.print(eng1);
        System.out.print("  ");
        System.out.print(math1);
        System.out.print("  ");
        System.out.print(sum1);
        System.out.print("  ");
        System.out.print(avg1);
        System.out.println();

        System.out.print(name2);
        System.out.print("  ");
        System.out.print(kor2);
        System.out.print("  ");
        System.out.print(eng2);
        System.out.print("  ");
        System.out.print(math2);
        System.out.print("  ");
        System.out.print(sum2);
        System.out.print("  ");
        System.out.print(avg2);
        System.out.println();

        System.out.print(name3);
        System.out.print("  ");
        System.out.print(kor3);
        System.out.print("  ");
        System.out.print(eng3);
        System.out.print("  ");
        System.out.print(math3);
        System.out.print("  ");
        System.out.print(sum3);
        System.out.print("  ");
        System.out.print(avg3);
        System.out.println();

        System.out.print(name4);
        System.out.print("  ");
        System.out.print(kor4);
        System.out.print("  ");
        System.out.print(eng4);
        System.out.print("  ");
        System.out.print(math4);
        System.out.print("  ");
        System.out.print(sum4);
        System.out.print("  ");
        System.out.print(avg4);
        System.out.println();

        System.out.print(name5);
        System.out.print("  ");
        System.out.print(kor5);
        System.out.print("  ");
        System.out.print(eng5);
        System.out.print("  ");
        System.out.print(math5);
        System.out.print("  ");
        System.out.print(sum5);
        System.out.print("  ");
        System.out.print(avg5);
        System.out.println();
    }
}

<강사님 코드 2>
// 3단계 : 변수 선언을 모아서 일괄적으로 처리하기
package step02.assignment;

public class Test01 {
    public static void main(String[] args) {
        // 사용할 변수를 먼저 선언한다.
        String name1, name2, name3, name4, name5;
        int kor1, kor2, kor3, kor4 ,kor5;
        int eng1, eng2, eng3, eng4, eng5l
        int math1, math2, math3, math4, math5;
        int sum1, sum2, sum3, sum4, sum5;
        double avg1, avg2, avg3, avg4, avg5;

        java.io.InputStream keyboard = System.in;
        java.util.Scanner KeyScan = new java.util.Scanner(keyboard); 

        System.out.print("입력? ");
        name1 = KeyScan.nextLine();
        kor1 = KeyScan.nextInt();
        eng1 = KeyScan.nextInt();
        math1 = KeyScan.nextInt();

        sum1 = kor1 + eng1 + math1;
        avg1 = sum1 / 3;


        name2 = KeyScan.nextLine();
        kor2 = KeyScan.nextInt();
        eng2 = KeyScan.nextInt();
        math2 = KeyScan.nextInt();

        sum2 = kor2 + eng2 + math2;
        avg2 = sum2 / 3;

        name3 = KeyScan.nextLine();
        kor3 = KeyScan.nextInt();
        eng3 = KeyScan.nextInt();
        math3 = KeyScan.nextInt();


        sum3 = kor3 + eng3 + math3;
        avg3 = sum3 / 3;

        name4 = KeyScan.nextLine();
        kor4 = KeyScan.nextInt();
        eng4 = KeyScan.nextInt();
        math4 = KeyScan.nextInt();

        sum4 = kor4 + eng4 + math4;
        avg4 = sum4 / 3;

        name5 = KeyScan.nextLine();
        kor5 = KeyScan.nextInt();
        eng5 = KeyScan.nextInt();
        math5 = KeyScan.nextInt();

        sum5 = kor5 + eng5 + math5;
        avg5 = sum5 / 3;

        System.out.println("-----------------------");

        System.out.print(name1);
        System.out.print("  ");
        System.out.print(kor1);
        System.out.print("  ");
        System.out.print(eng1);
        System.out.print("  ");
        System.out.print(math1);
        System.out.print("  ");
        System.out.print(sum1);
        System.out.print("  ");
        System.out.print(avg1);
        System.out.println();

        System.out.print(name2);
        System.out.print("  ");
        System.out.print(kor2);
        System.out.print("  ");
        System.out.print(eng2);
        System.out.print("  ");
        System.out.print(math2);
        System.out.print("  ");
        System.out.print(sum2);
        System.out.print("  ");
        System.out.print(avg2);
        System.out.println();

        System.out.print(name3);
        System.out.print("  ");
        System.out.print(kor3);
        System.out.print("  ");
        System.out.print(eng3);
        System.out.print("  ");
        System.out.print(math3);
        System.out.print("  ");
        System.out.print(sum3);
        System.out.print("  ");
        System.out.print(avg3);
        System.out.println();

        System.out.print(name4);
        System.out.print("  ");
        System.out.print(kor4);
        System.out.print("  ");
        System.out.print(eng4);
        System.out.print("  ");
        System.out.print(math4);
        System.out.print("  ");
        System.out.print(sum4);
        System.out.print("  ");
        System.out.print(avg4);
        System.out.println();

        System.out.print(name5);
        System.out.print("  ");
        System.out.print(kor5);
        System.out.print("  ");
        System.out.print(eng5);
        System.out.print("  ");
        System.out.print(math5);
        System.out.print("  ");
        System.out.print(sum5);
        System.out.print("  ");
        System.out.print(avg5);
        System.out.println();
    }
}
*/

/*
// 4단계 : 배열을 사용하여 같은 종류의 메모리를 쉽게 만들기!
package step02.assignment;

public class Test01 {
    public static void main(String[] args) {
        
        // 배열 사용 시 같은 종류의 메모리를 아주 간단히 만들 수 있음
        String[] name = new String[5];
        int[] kor = new int[5];
        int[] eng = new int[5];
        int[] math = new int[5];
        int[] sum = new int[5];
        double[] avg = new int[5]5;

        java.io.InputStream keyboard = System.in;
        java.util.Scanner KeyScan = new java.util.Scanner(keyboard); 

        System.out.print("입력? ");
        name[0] = KeyScan.nextLine();
        kor[0] = KeyScan.nextInt();
        eng[0] = KeyScan.nextInt();
        math[0] = KeyScan.nextInt();

        sum[0] = kor[0] + eng[0] + math[0];
        avg[0] = sum[0] / 3;

        name[1] = KeyScan.nextLine();
        kor[1] = KeyScan.nextInt();
        eng[1] = KeyScan.nextInt();
        math[1] = KeyScan.nextInt();

        sum[1] = kor[1] + eng[1] + math[1];
        avg[1] = sum[1] / 3;


        name[2] = KeyScan.nextLine();
        kor[2] = KeyScan.nextInt();
        eng[2] = KeyScan.nextInt();
        math[2] = KeyScan.nextInt();

        sum[2] = kor[2] + eng[2] + math[2];
        avg[2] = sum[2] / 3;

        name[3 = KeyScan.nextLine();
        kor[3] = KeyScan.nextInt();
        eng[3] = KeyScan.nextInt();
        math[3] = KeyScan.nextInt();


        sum[3] = kor[3] + eng[3] + math[3];
        avg[3] = sum[3] / 3;

        name[4] = KeyScan.nextLine();
        kor[4] = KeyScan.nextInt();
        eng[4] = KeyScan.nextInt();
        math[4] = KeyScan.nextInt();

        sum[4] = kor[4] + eng[4] + math[4];
        avg[4] = sum[4] / 3;


        System.out.println("-----------------------");

        System.out.print(name[0]);
        System.out.print("  ");
        System.out.print(kor[0);
        System.out.print("  ");
        System.out.print(eng[0);
        System.out.print("  ");
        System.out.print(math[0]);
        System.out.print("  ");
        System.out.print(sum[0]);
        System.out.print("  ");
        System.out.print(avg[0]);
        System.out.println();        

        System.out.print(name[1]);
        System.out.print("  ");
        System.out.print(kor[1]);
        System.out.print("  ");
        System.out.print(eng[1]);
        System.out.print("  ");
        System.out.print(math[1]);
        System.out.print("  ");
        System.out.print(sum[1]);
        System.out.print("  ");
        System.out.print(avg[1]);
        System.out.println();

        System.out.print(name[2]);
        System.out.print("  ");
        System.out.print(kor[2]);
        System.out.print("  ");
        System.out.print(eng[2]);
        System.out.print("  ");
        System.out.print(math[2]);
        System.out.print("  ");
        System.out.print(sum[2]);
        System.out.print("  ");
        System.out.print(avg[2]);
        System.out.println();

        System.out.print(name[3]);
        System.out.print("  ");
        System.out.print(kor[3]);
        System.out.print("  ");
        System.out.print(eng[3]);
        System.out.print("  ");
        System.out.print(math[3]);
        System.out.print("  ");
        System.out.print(sum[3]);
        System.out.print("  ");
        System.out.print(avg[3]);
        System.out.println();

        System.out.print(name[4]);
        System.out.print("  ");
        System.out.print(kor[4]);
        System.out.print("  ");
        System.out.print(eng[4]);
        System.out.print("  ");
        System.out.print(math[4]);
        System.out.print("  ");
        System.out.print(sum[4]);
        System.out.print("  ");
        System.out.print(avg[4]);
        System.out.println();

    }
}
*/

/*
// 5단계 : 반복문을 사용하여 입력과 출력 코드를 간단히 하라!!
package step02.assignment;

import java.io.InputStream;
import java.util.Scanner;

public class Test02 {
    public static void main(String[] args) {
        final int people = 5;                   // 기호 상수 지정
        String[] name = new String[people];     // 이름 선언
        int[] kor = new int[people];            // 국어 성적 선언
        int[] eng = new int[people];            // 영어 성적 선언
        int[] math = new int[people];           // 수학 성적 선언
        int sum;                                // 총합계 성적 선언
        double avg;                             // 평균 선언

        InputStream keyboard = System.in;       // 입력 받을 키보드 선언
        Scanner sc = new Scanner(keyboard);     // 입력 도구 선언

        // 각각 5명의 성적을 입력한다.
        for(int i = 0 ; i < people ; i++) {
            System.out.print("입력? ");

            name[i] = sc.next();
            kor[i] = sc.nextInt();
            eng[i] = sc.nextInt();
            math[i] = sc.nextInt();
            //sc.next();    // 빈칸 및 줄바꿈 스킵용
        }

        System.out.println("----------------------------------");

        for(int i = 0; i < people ; i++) {
            sum = kor[i] + eng[i] + math[i];
            avg = sum / 3; //

            System.out.print(name[i]);
            System.out.print("  ");
            System.out.print(kor[i]);
            System.out.print("  ");
            System.out.print(eng[i);
            System.out.print("  ");
            System.out.print(math[i]);
            System.out.print("  ");
            System.out.print(sum);
            System.out.print("  ");
            System.out.print(avg);
            System.out.println();   
        }
    }
}

*/