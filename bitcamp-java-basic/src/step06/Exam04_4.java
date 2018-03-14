// 매서드 :스택 메모리 응용 1
package step06;

import java.util.Scanner;

class MyObject {
    int a;
    int b;
}

public class Exam04_4 {

    static int m1(int value) {
        int r1 = m2(value);
        int r2 = m3(value);
        return r1 + r2;
    }

    static int m2(int value) {
        return value + 100;
    }

    static int m3(int value) {
        return value + 200;
    }

    static MyObject getMyObject() {
        // Exam03_3.java 에 정의된 MyObject 클래스 사용
        MyObject ref = new MyObject();
        ref.a = 100;
        ref.b = 200;
        return ref;
    }

    public static void main(String[] args) {
        int r = m1(5);
        System.out.println(r);

    }
}

// JVM Stack 메모리의 사용
// 0) 시작
// 1) main() => m1()
// 2) main() => m1() => m2()
// 3) main() => m1()
// 4) main() => m1() => m3()
// 5) main() => m1()
// 6) main()
// 7) 끝