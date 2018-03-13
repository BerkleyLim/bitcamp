// 흐름 제어문 - switch 문법
package step05;

import java.util.Scanner;

public class Exam02_3 {
    public static void main(String[] args) {
        
        // switch (값) { }
        // 값으로 가능한 데이터 타입은?
        // => 정수(byte, short, int, char), 문자열(String), 
        //    특별한 상수Enum 타입
        // => case 값으로 변수를 사용 불가, 리터럴만 가능!!!!!!!
        byte b = 2;
        switch (b) {
        case 1:
        case 2:
        default:
        }
        
        short s = 2;
        switch(s) {
        case 1:
        case 2:
        default:
        }
    
        int i = 2;
        switch(i) {
        case 1:
        case 2:
        default:
        }
        
        // long 형은 안됨 -> 컴파일 오류
        /*
        long l = 2;
        switch(l) {
        case 1:
        case 2:
        default:
        }
        */

        char c = 'A';   // A문자의 유니코드 값(UTF-16) 0x41(65)을 c에 저장한다.
        switch(1) {
        // case 의 값도 int 값이면 무엇이든 된다.
        case 66:
        case 0x43:
        default:
        }

        String str = "hello";
        switch (str) {
        // case 의 값으로 string 가능하다.
        case "hello": // 0x41 = 65
        case "ohora":
        case "hul":
        default:
        }

        // 컴파일 오류, switch문에서는 boolean은 불가능 (Java에서는 안됨, 
        //타언어에서는 되는것도 있다.)
        /*
        boolean bool = true;
        switch (bool) {
        case true:
        case false:
        }
        */

        // 컴파일 오류, switch문에서 case에 변수가 들어가면, 오류!!
        // case에서는 한마디로 상수표현만 가능하다!!
        /*
        int x = 1, y = 300;
        switch(x) {
        case 1 * y:
        }
        */

        int x = 1, y = 300;
        switch(x) {
        case 1 * 300:       // OK
        }
    }
}