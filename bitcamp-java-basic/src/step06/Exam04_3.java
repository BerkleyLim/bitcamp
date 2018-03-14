// 매서드 : 인스턴스와 힙 메모리
package step06;

import java.util.Scanner;

class MyObject {
    int a;
    int b;
}

public class Exam04_3 {

    static MyObject getMyObject() {
        // Exam03_3.java 에 정의된 MyObject 클래스 사용
        MyObject ref = new MyObject();
        ref.a = 100;
        ref.b = 200;
        return ref;
    }

    public static void main(String[] args) {
        MyObject ref;
        ref = getMyObject();
        System.out.println(ref.a); // 100
        System.out.println(ref.b); // 200

    }
}

// 1) main() 호출
//    => JVM Stack : args, arr 변수 생성
// 2) getArray() 호출
//    => JVM Stack : arr 변수 생성
//    => Method Area : Myobject 클래스를 로딩
//    => heap : MyObject 설계도의 따라 생성
// 3) getArray() 호출 끝
//    => JVM Stack : getArray() 관련 메모리(arr 변수) 제거
//    => new int[] 배열 주소 리턴
// 4) main() 호출 끝
//    => JVM Stack : main() 관련 메모리르 제거
// 5) JVM 종료
//    => JVM이 사용한 모든 메모리(Method Area, JVM Stack, Heap 등)를 OS 반납.