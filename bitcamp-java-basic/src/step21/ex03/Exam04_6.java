// 던지는 예외 받기 - 다형적 변수의 특징을 이용하여 여러 예외를 한 catch에서 받을 수 있다.
package step21.ex03;

import java.io.IOException;
import java.sql.SQLException;

public class Exam04_6 {
    // 메서드에서 발생되는 모든 예외를 나열하기
    static void m(int i) 
            throws Exception, RuntimeException, SQLException, IOException {
        if (i == 0)
            throw new Exception();
        else if (i == 1)
            throw new RuntimeException();
        else if (i == 2)
            throw new SQLException();
        else
            throw new IOException();
    }
    
    public static void main(String[] args) {
        try {
            // try 블록에서 예외가 발생할 수 있는 메서드를 호출한다.
            m(1);
            
        } catch (RuntimeException | SQLException | IOException e) {
            // OR 연산자를 사용하여 여러개의 예외로 묶어 받을 수 있다.
            
        } catch (Exception e) {
            
        }
    }
}
