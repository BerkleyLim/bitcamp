// 상대편으로부터 연결 요청 받기 - 서버(Server)
package step23.ex01;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Receiver {
    public static void main(String[] args) throws Exception {
        // 1) 다른 컴퓨터의 연결 요청을 기달린다.
        ServerSocket serverSocket = new ServerSocket(8888);
        
        // 2) 연결 하기 위해 대기 중인 컴퓨터 중에서 한 개를 연결을 허락한다.
        Socket socket = serverSocket.accept();
        
        // 3) 소켓 객체를 통해 읽고 쓸 수 있도록 입출력스트림을 준비한다.
        PrintStream out = new PrintStream(socket.getOutputStream());
        Scanner in = new Scanner(socket.getInputStream());
        
        // 4) 상대편에서 보낸 문자열을 한 줄 읽는다.
        // => 상대편이 한 줄 데이터를  보낼 때 까지 리턴하지 않는다.
        // => 이런 메서드를 블로킹 메서드라 부른다.
        String str = in.nextLine();
        System.out.printf("상대편> %s\n", str);
        
        // 5) 상대편으로 문자열을 한 줄 보낸다.
        // => 서버에서 데이터를 읽을 때 까지 리턴하지 않는다.
        // => 이런 메서드를 블록킹(blocking) 메서드라 부른다.
        out.println("저는 임현식입니다. 반갑습니다!");
        //out.println("너무 심한거 아닌가요? 너무하세요.");
        
        // 6) 항상 입출력 도구는 사용 후 닫아야 한다.
        in.close();
        out.close();
        
        // 7) 네트워크 연결도 닫는다.
        socket.close();
        serverSocket.close();
    }
}
