// java I/O API 사용하기 -  ObjectOutputStream과 java.ioSerializable 인터페이스
package step22.ex09;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Exam02_3 {

    public static void main(String[] args) throws Exception {
        FileInputStream fileIn = new FileInputStream("temp/test9_2.data");
        BufferedInputStream bufIn = new BufferedInputStream(fileIn);
        ObjectInputStream in = new ObjectInputStream(bufIn);
        
        Member2 member= (Member2) in.readObject();
        
        in.close();
        
        System.out.println(member);
    }

}
