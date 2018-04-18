// Character Stream - 문자 배열을 특정 위치에 있는 것을 읽기

package step22.ex02;

import java.io.FileReader;


public class Exam03_2 {
    public static void main(String[] args) throws Exception {
        FileReader in = new FileReader("temp/test2.txt");

        // UTF-16 문자 코드 값을 저장할 배열을 준비한다.
        // => 이렇게 임시 데이터를 저장하기 위해 만든 바이트 배열을 보통 "버퍼(buffer)"라 한다.
        char[] buf = new char[100];
        
        // read(버퍼의주소, 저장할 위치, 읽을 바이트 개수)
        // => 리턴 값은 실제 읽은 문자의 개수이다.
        int count = in.read(buf, 10, 40); // 40개의 문자를 읽어 10번 방부터 저장한다.
        // 3) 읽기 도구를 닫는다.
        in.close();
        
        System.out.printf("%d\n", count);
        for(int i = 10; i < (count + 10); i++) {
            System.out.printf("%c(%x) ", buf[i], (int)buf[i]);
        }
        System.out.println();
    }
}
