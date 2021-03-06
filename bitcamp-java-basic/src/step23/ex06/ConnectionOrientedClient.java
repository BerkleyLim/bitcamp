// 응용 - 에코 클라이언트 만들기
package step23.ex06;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ConnectionOrientedClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 8888);
        System.out.println("서버에 연결됨");
        
        Scanner in = new Scanner(socket.getInputStream());
        PrintStream out = new PrintStream(socket.getOutputStream());
        
        // 데이터를 읽고 출력할 때는 반드시 서버와의 통신 규칙을 따라야 한다.
        // 클라이언트가 먼저 데이터를 보내기로 했으면 먼저 데이터를 보내야 한다.
        out.println(args[0]);
        System.out.println("데이터 보냄!");
        
        // 서버가 보낸 데이터를 읽고 화면에 출력한다.
        String str= in.nextLine(); // 서버에서 받은 버퍼를 읽어들여 불려들어 저장한다.
        System.out.println("데이터 받음");
        System.out.println(str);
        
        in.close();
        out.close();
        socket.close();
    }
}
