// 변수 - 메모리 종류와 변수 선언

package step02;
//import java.util.Scanner;
//import java.io.InputStream;

public class Exam03_1 {
    public static void main(String[] args) {
        byte b;
        short s;
        int i;
        long l;
        float f;
        double d;
        char c;
        boolean bool;
        //String st;

    }
}

// 변수 선언
// - 값을 저장할 메모리를 준비시키는 명령.

// 문법
// - 메모리종류 별명;

// 메모리 종류
// 1) primative data type (원시 데이터 타입)
//   자바에서 기본으로 제공하는 메모리 종류
// - 정수
//   - byte : 1byte 메모리 (-128 ~ 127)
//   - short : 2byte 메모리 (-32768 ~ 32767)
//   - int : 4byte 메모리 (약 -21억 ~ 21억)
//   - long : 8byte 메모리 (약 -922경 ~ 922경)
// - 부동소숫점
//   - float : 4byte 메모리 (유효자릿수 7자릿수)
//   - double : 8byte 메모리 (유효자릿수 15자릿수)
// - 문자
//   - char : 2byte 메모리 (0 ~ 65535). UTF-16 코드값 저장.
// - 논리값
//   - boolean : JVM에서 4byte int 메모리를 사용한다.

// 2) Reference data type (레퍼런스 데이터 타입)
//    데이터가 저장된 메모리의 주소를 저장하는 메모리.
// - 문자열(주소)
//   - String : 문자열이 저장된 주소를 저장한다.
//              지금 당장에는 그냥 문자열을 저장하는 메모리로 생각해라.
