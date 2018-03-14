// 매서드 :스택 메모리 응용 3 - 스택 오버 플로우
package step06;

import java.util.Scanner;

public class Exam04_6 {
    
    static int sum(int value) {
        // 종료 조건을 빼버리면, 무한으로 호출한다.
        // java.lang.StackOverflowError 발생
        /*
        if(value == 1)
            return 1;
        */

        long a1, a2, a3, a4, a5, a6, a7, a8, a9;
        System.out.println(value);

        return value + sum(value - 1);
    }


    public static void main(String[] args) {
        try {
            System.out.println(sum(5));
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}

// JVM Stack 메모리의 사용
// 0) 시작
// 1) main()
// 2) main() => sum(5)
//           => 5 + sum(4)
//                  => 4 + sum(3)
//                          => 3 + sum(2)
//                                  => 2 + sum(1)
//                                          => 1
// 3) main()
// 4) 종료!

// 재귀호출(recursive call)
// - 수학식을 코드를 표현하기가 편하다.
// - 코드가 간결하다.
// - 그러나 반복문을 사용하는 경우보다 메모리를 많이 사용한다.
// - 멈춰야 할 조건을 빠뜨리면 스택 메모리가 극한으로 증가하여
//   메모리가 부족한 사태에 빠진다.
//   이런 사태를 "stackoverflow"라 부른다.
// - 그래서 큰 수(즉,에 대해서 재귀호출을 할 때
//   스택오버플로우가 자주 발생한다.
