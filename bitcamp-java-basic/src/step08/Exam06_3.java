// 초기화 블록 - 인스턴스 블록의 활용
package step08;

import java.util.Scanner;

public class Exam06_3 {

    static class A {
        // 3) 생성자 실행
        A() {
            a = 300;
        }
        
        // 2) 인스턴스 초기화 블록실행
        {
            a = 200;
        }
        
        // 1) 인스턴스 변수 생성 및 할당 연산자 실행(초기화 문장 실행)
        int a = 100;
    }
    public static void main(String[] args) {
        A obj1 = new A();
        System.out.println(obj1.a);
    }
}

