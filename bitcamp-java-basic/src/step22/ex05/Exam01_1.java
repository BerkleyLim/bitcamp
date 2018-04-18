// 버퍼 사용 전 - 데이터 읽기 시간
package step22.ex05;

import java.io.FileInputStream;

public class Exam01_1 {

    public static void main(String[] args) throws Exception {
        FileInputStream in = new FileInputStream("temp/jls8.pdf");
        
        int b;
        
        long startTime = System.currentTimeMillis(); // 밀리 초
        
        while ((b = in.read()) != -1); // 파일을 끝까지 읽는다.
            
        long endTime = System.currentTimeMillis();
        
        System.out.println(endTime - startTime);
        
        in.close();

    }

}
