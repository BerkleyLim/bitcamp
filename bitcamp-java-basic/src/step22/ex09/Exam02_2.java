// java I/O API 사용하기 -  ObjectOutputStream과 java.io.Serializable 인터페이스
package step22.ex09;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Exam02_2 {

    public static void main(String[] args) throws Exception {
        FileOutputStream fileOut = new FileOutputStream("temp/test9.data");
        BufferedOutputStream bufOut = new BufferedOutputStream(fileOut);
        ObjectOutputStream out = new ObjectOutputStream(bufOut);
        
        
        Member member = new Member();
        member.name = "AB가각간";
        member.age = 27;
        member.gender = true;

        // ObjectOutputStream 인스턴스의 값을 바이트 배열로 만들어 출력하는 기능이 있다.
        long startTime = System.currentTimeMillis();
        
        out.writeObject(member);
        
        long endTime = System.currentTimeMillis();
        
        out.close();
        
        System.out.println("데이터 출력 완료!");
        System.out.println(endTime - startTime);
    }

}
