// 매서드 : call by reference 1
package step06;

import java.util.Scanner;

public class Exam03_2 {
    // call by reference
    static void swap(int[] arr) {
        System.out.printf("swap() : arr[0]=%d, arr[1]=%d\n", arr[0], arr[1]);
        int temp = arr[0];
        arr[0] = arr[1];
        arr[1] = temp;
        System.out.printf("swap() : arr[0]=%d, arr[1]=%d\n", arr[0], arr[1]);
    }
    
    public static void main(String[] args) {
        int[] arr = new int[] {100, 200};
        //swap(new int[] {100, 200}); // Ok 
        swap(arr);  // 배열 인스턴스(메모리)를 넘기는 것이 아니다.
                    // 주소를 넘기는 것이다.
                    // 그래서 "call by reference" 라 부른다.
       System.out.printf("main() : arr[0]=%d, arr[1]=%d\n", arr[0], arr[1]);
    }
}

// call by reference