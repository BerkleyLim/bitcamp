// 비트 이동 연산자 : >>, >>>, <<
package step04;

public class Exam04_1 {
    public static void main (String[] args) {
        int i = 1;                  // 0000 0001 = 1
        System.out.println(i << 1); // 0000 0010 = 2
        System.out.println(i << 2); // 0000 0100 = 4
        System.out.println(i << 3); // 0000 1000 = 8
        System.out.println(i << 4); // 0001 0000 = 16
        // 왼쪽으로 이동 후,
        // 오른 쪽 빈자리 : 0으로 채운다.
        // 왼쪽 경계를 넘어간 비트 : 짜른다.
        // 꿀팁 : 비트연산자 '<<' 사용시 2^(n-1) 역할을 한다.
        
        i = 0b0000_1011;    // 11
        System.out.println(i << 1); // 0001 0110 = 22
        System.out.println(i << 2); // 0010 1100 = 44
        System.out.println(i << 3); // 0101 1000 = 88
        System.out.println(i << 4); // 1011 0000 = 176
    }
}

// 왼쪽 이동
// - 1비트 이동은 곱하기 2 한 것과 같은 효과를 준다.
//   