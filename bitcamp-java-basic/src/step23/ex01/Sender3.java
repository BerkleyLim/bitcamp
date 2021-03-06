// 클라이언트 + 키보드 입력 + 무한 반복
package step23.ex01;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Sender3 {
    public static void main(String[] args) throws Exception {
        Scanner keyScan = new Scanner(System.in);
        
      Socket socket = new Socket("192.168.0.58", 8888);
//        Socket socket = new Socket("192.168.0.12", 8888);
        
        
        PrintStream out = new PrintStream(socket.getOutputStream());
        Scanner in = new Scanner(socket.getInputStream());
        
        while (true) {
            // 키보드 입력을 받아서 서버에게 전송한다.
            System.out.println("입력> ");
            String input = keyScan.nextLine();
            out.println(input);
            
            // 서버가 보낸 데이터를 수신한다.
            String str = in.nextLine();
            System.out.println(str);
            
            if (input.equals("qult")) {
                break;
            }
        }
        
        in.close();
        out.close();
        socket.close();
        keyScan.close();
    }
}
