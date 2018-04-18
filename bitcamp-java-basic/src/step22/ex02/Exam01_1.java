
// Character Stream - 문자 단위로 출력하기
package step22.ex02;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * <xmp>
 * step22.ex02
 * Exam01_1.java
 * 
 * 
 * >java -Dfile.encoding=UTF-8 -cp bin/main step22.ex02.Exam01_1 
 * // 이 cmd 명령어는 외부 파일을 읽어 올 때 UTF-8 형식으로 불러 온다.
 * 
 * -Dfile.encoding : JVM에서 사용할 프로퍼티명
 * UTF-8 : 프로퍼티 값
 * file.encoding 값을 지정하지 않으면 OS가 사용하는 문자코드들은 JVM이 사용한다.
 * ex) Windows OS => MS949
 *     Unix => UTF-8
 * </xmp>
 *
 * @Author limhs
 * @Date 2018. 4. 11.
 * @Version : 
 */

public class Exam01_1 {
    public static void main(String[] args) throws IOException {
        // 1) 문자 단위로 출력할 도구 준비
        FileWriter out = new FileWriter("temp/test2.txt");
        
        // 2) 문자 출력하기
        // => 자바는 문자 데이터를 다룰 때 UTF-16(2byte) 유니코드를 사용한다.
        // => 그래서 출력할 때 UTF-16 2byte 유니코드를 값을 
        //    JVM에 설정된 기본 문자코드표의 값으로 변환하여 출력한다.
        // => JVM을 실행할 때 출력 데이터의 문자 코드표를 지정하지 않으면
        //    OS의 기본 문자코드표에 따라 변환한다.
        //    예) Windows OS(MS949), Unix(UTF-8)
        // => JVM을 실행할 때 출력 데이터의 문자 코드표를 지정하는 방법
        //    > java -Dfile.encoding=문자코드표 -cp 클래스 경로 클래스명
        
        // => 따라서 다음 4바이트 값을 출력하면
        //    앞의 2바이트는 버리고, 뒤의 2바이트를 UTF-8 코드표에 따라
        //    3바이트 값으로 변환하여 출력한다.
        out.write(0xAC00); // 파라미터 타입은 int 이지만 2byte를 출력한다.
        
        out.close();
        
        System.out.println("출력 완료!");
    }
}
