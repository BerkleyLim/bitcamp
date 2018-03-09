// 비트 이동 연산자 : 응용 1
package step04;

public class Exam04_4 {
    public static void main (String[] args) {
        int i = 0x27a130ff;        // 5
        int temp;
        int a, b, c, d;  // a = 27, b = a1, c = 30, d = ff;
        System.out.println(Integer.toHexString(i));
        // 16진수로 출력, 기본 10진수로 고정된 상태여서 변경해야함

        // i 변수에 들어있는 값을 순서대로 1바이트씩 짤라서
        // a, b, c, d 변수에 넣은 다음 각 변수의 값을 16진수로 출력하라!
        
        a = i >> 24;        // 00000000_00000000_00000000_00100111

        b = (i >> 16) & 0xff;
        // 만일 b = i >> 16 으로만 하면, 00000000_00000000_00100111_10100001
        // 즉 27al로 출력
        // 0xff로 하면, 10100001 만 남음 결국 값 = a1

        c = (i & 0x0000FF00);
        c = c >> 8;

        d = (i & 0x000000FF);

        System.out.println(Integer.toHexString(a));
        System.out.println(Integer.toHexString(b));
        System.out.println(Integer.toHexString(c));
        System.out.println(Integer.toHexString(d));

        // for문으로 한번에 처리
        for (int j = 24 ; j >= 0 ; j -= 8) {
            temp = (i >> j) & 0xff;
            System.out.println(Integer.toHexString(temp));

        }
           
    }
}