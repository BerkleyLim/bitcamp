// 상대편으로부터 연결 요청  - 클라이언트(Client)
package step23.ex01;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Sender {
    public static void main(String[] args) throws Exception {
        // 1) 다른 컴퓨터와 네트워크로 연결한다.
        //Socket socket = new Socket("192.168.0.58", 8888);
        Socket socket = new Socket("192.168.0.12", 8888);
        
        
        // 2) 소켓 객체를 통해 읽고 쓸 수 있도록 입출력스트림을 준비한다.
        PrintStream out = new PrintStream(socket.getOutputStream());
        Scanner in = new Scanner(socket.getInputStream());
        
        // 3) 상대편으로 문자열을 한 줄 보낸다.
        // => 서버에서 데이터를 읽을 때 까지 리턴하지 않는다.
        // => 이런 메서드를 블록킹(blocking) 메서드라 부른다.
        out.println("임현식입니다. 안녕하세요.");
        
        // 4) 상대편에서 보낸 문자열을 한 줄 읽는다.
        // => 상대편이 한 줄 데이터를 보낼 때 까지 리턴하지 않는다.
        // => 이런 메서드를 블로킹 메서드라 부른다.
        String str = in.nextLine();
        System.out.println(str);
        
        // 5) 항상 입출력 도구는 사용 후 닫아야 한다.
        in.close();
        out.close();
        
        // 6) 네트워크 연결도 닫는다.
        socket.close();
    }
}
