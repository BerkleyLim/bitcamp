// Stateless와 Stateful의 비교
package step23.ex05;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

// Stateless의 방식의 특징
// => 연결 요청 할 때마다 서버와 연결한다. 응답 받은 후 서버와의 연결을 끊는다.
// => 
public class StatelessClient_MyVersion {
    public static void main(String[] args) throws Exception {
        try (Scanner keyScan = new Scanner(System.in)) {
            while (true) {
                System.out.print("값? ");
                String str = keyScan.nextLine();
                try(
                    Socket socket = new Socket("localhost", 8888);
                    PrintStream out = new PrintStream(socket.getOutputStream());
                    Scanner in = new Scanner(socket.getInputStream())) {

                    
                    
                    out.printf("%s,%s\n",str,args[0]); // 서버에 보낸다.
                    
                    if (str.isEmpty()) { // str이 공백이면
                        System.out.println(in.nextLine()); // 서버가 보낸 결과를 출력
                        break;
                    }
                }
            }
        }
        
    }
    
}
