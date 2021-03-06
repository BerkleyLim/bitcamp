// 비트 이동 연산자 : <<, >>>, >>
package step04;

public class Exam04_2 {
    public static void main (String[] args) {
        int i = 0b0110_1001;        // 0110 1001 = 105
        System.out.println(i >> 1); // 0011 0101 = 52
        System.out.println(i >> 2); // 0001 1010 = 26
        System.out.println(i >> 3); // 0000 1101 = 13
        System.out.println(i >> 4); // 0000 0110 = 6
        // 오른쪽으로 이동 후,
        // 왼쪽 빈자리 : 원래 숫자와 같은 부로 값으로 채운다.
        //              양수면 0, 음수면 1을 채운다.
        // 오른쪽 경계를 넘어간 비트 : 짜른다.
        
        // 음수의 경우
        i = 0b1111_1111_1111_1111_1111_1111_1010_1001;    // -87
        System.out.println(i >> 1); 
        // 1111_1111_1111_1111_1111_1111_1101_0100 = -44
        // => 왼쪽 빈자리는 숫자의 부호비트로 채운다.
        //    음수니깐 1로 채운다.
        // => 2로 나눈 후에 소수점이 있으면
        //    그 수보다 더 작은 정수값이 되는 결과가 나온다.

        System.out.println(i >> 2);
        // 1111_1111_1111_1111_1111_1111_1110_1010 = -22
        System.out.println(i >> 3);
        // 1111_1111_1111_1111_1111_1111_1111_0101 = -11
        System.out.println(i >> 4); 
        // 1111_1111_1111_1111_1111_1111_1111_1010 = -6       
    }
}

// 오른쪽 이동
// - 1비트 이동은 나누기 2 한 것과 같은 효과를 준다.
// - 소수점 이하는 짤리는 효과를 갖는다.