// 버퍼 사용 후 - 파일 복사 및 시간 측정
package step22.ex05;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Exam02_2 {

    public static void main(String[] args) throws Exception {
        FileInputStream in = new FileInputStream("temp/jls8.jpg");
        FileOutputStream out = new FileOutputStream("temp/jls8_3.jpg");
        
        byte[] buf = new byte[8196]; // 보통 8KB 정도 메모리 준비
        int count = 0;
        
        long startTime = System.currentTimeMillis(); // 밀리 초
        
        while ((count = in.read(buf)) != -1) {
            out.write(buf);
        } // 파일을 끝까지 읽는다.
            
        long endTime = System.currentTimeMillis();
        
        System.out.println(endTime - startTime); // 2
        
        in.close();
        out.close();

    }

}
