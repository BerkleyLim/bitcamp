// Connection-Oriented 서버 - 연결 후 데이터 송수신
package step23.ex06;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

//연결 지향(connection oriented)
//=> 연결 후 데이터를 송수신 하기 때문에 데이터 송수신에 신뢰를 보장한다.
//=> TCP 통신 방법의 전형적인 예이다.
public class ConnectionOrientedServer {
    public static void main(String[] args) throws Exception {
        System.out.println("서버 실행중");
        ServerSocket ss = new ServerSocket(8888);
        
        // 대기열에서 기다리고 있는 클라이언트 중에서 제일 첫번째 클라이언트에 대해 연결을 승인한다.
        // => 그 클라이언트와 통신할 수 있는 소켓을 리턴한다.
        Socket socket = ss.accept();
        System.out.println("클라이언트가 연결되었음!");
        
        Scanner in = new Scanner(socket.getInputStream());
        PrintStream out = new PrintStream(socket.getOutputStream());
        
        // 데이터를 읽고 출력할 때는 반드시 클라이언트와의 통신 규칙을 따라야 한다.
        // 클라이언트가 먼저 데이터를 보냈으면 서버에서는 먼저 읽어야 한다.
        String str = in.nextLine(); // 클라이언트에서 저장된 버퍼를 불려들어 저장한다.
        System.out.println("데이터 수신 완료");
        
        out.println(str);
        System.out.println("데이터 송신 완료!");
        
        in.close();
        out.close();
        socket.close();
        System.out.println("클라이언트 연결 끊기");
        ss.close();
    }
}
