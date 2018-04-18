// 버퍼 사용 후 - 데이터 읽기 시간
package step22.ex05;

import java.io.FileInputStream;

public class Exam01_2 {

    public static void main(String[] args) throws Exception {
        FileInputStream in = new FileInputStream("temp/jls8.pdf");
        
        byte[] buf = new byte[8196]; // 보통 8KB 정도 메모리 준비
        int count = 0;
        
        long startTime = System.currentTimeMillis(); // 밀리 초
        
        while ((count = in.read(buf)) != -1); // 파일을 끝까지 읽는다.
            
        long endTime = System.currentTimeMillis();
        
        System.out.println(endTime - startTime);
        
        in.close();

    }

}
