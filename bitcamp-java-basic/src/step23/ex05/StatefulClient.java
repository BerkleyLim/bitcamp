// Stateless와 Stateful의 비교
package step23.ex05;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

// Stateful(connectionful)의 방식의 장점
// => 클라이언트와 계속 연결을 유지하기 때문에 작업 결과를 계속 서버에 유지할 수 있다.
// => 
public class StatefulClient {
    public static void main(String[] args) throws Exception {
        try (
                Scanner keyScan = new Scanner(System.in);
                
                // 합계를 계산을 요청하는 클라이언트를 만들어보자!
                Socket socket = new Socket("localhost", 8888);
                PrintStream out = new PrintStream(socket.getOutputStream());
                Scanner in = new Scanner(socket.getInputStream())) {//참고, 마지막껀
                                                            // 세미콜론 없어도 됨
                                                            // try (/*문장안 마지막*/)
            
            while (true) {
                System.out.print("값? ");
                String str = keyScan.nextLine();
                
                out.println(str); // 서버에 보낸다.
                
                if (str.isEmpty()) { // str이 공백이면
                    System.out.println(in.nextLine()); // 서버가 보낸 결과를 출력
                    break;
                }
            }
        }
        
    }
    
}
