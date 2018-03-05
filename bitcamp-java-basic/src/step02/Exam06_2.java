// 문자 변수 - UTF-16(Unicode 2) 코드 값 저장!!!!!!!!!!!!!!!!!
package step02;

public class Exam06_2 {
    public static void main(String[] args) {
        // 0 ~ 65535까지의 UTF-16 코드 값을 저장하는 2byte 메모리
        char c1, c2, c3;
        c1 = 0x41; // A 문자의 UTF-16 코드 값
        c2 = 65;   // A 문자의 UTF-16 코드 값
        c3 = 0b0100_0001;  // A 문자의 UTF-16 코드 값

        // println()은 변수의 타입에 따라 출력을 달리한다.
        // - 변수의 종류가 char이면, 출력할 때 10진수로 출력하는 대신
        //   해당 코드의 문자를 폰트 파일에서 찾아 출력한다.
        System.out.println("c1의 값 : " + c1);
        System.out.println("c2의 값 : " + c2);
        System.out.println("c3의 값 : " + c3);

        // 다음 변수에 핳 문자를 저장하여 출력하라!
        char c4;
        
        // 변수의 문자 코드를 저장하면 문자 코드를 암기해야 하는데
        // 너무 힘들다.
        // 해결책?
        // 자바에서는 문자의 코드 값을 알아내는 명령어가 있다.
        // 그 명령어를 사용하면 손쉽게 문자 코드를 얻을 수 있다.
        c4 = '헐';   // 작은 따옴표를 사용하라!!!!
                     // '헐'의 경우 헐 문자의 UTF-16코드 값을
                     // 그 자리에 놓는다.
                     // 따라서 다음과 같은 코드가 된다.
                     // '헐' = 54736
        System.out.println("c4의 UTF-16의 문자 코드 값 : " + (int) c4);
        System.out.println("54736의 코드 값 : " + (char) 54736);
    }
}
