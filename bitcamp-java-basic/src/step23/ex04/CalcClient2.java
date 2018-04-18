// connectionful(=stateful) 방식 - 계산기 클라이언트 만들기
package step23.ex04;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class CalcClient2 {
    public static void main(String[] args) throws Exception {
        Scanner keyScan = new Scanner(System.in);
        System.out.println("클라이언트 실행중");

        Socket socket = new Socket("localhost", 8888);
        Scanner in = new Scanner(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        while (true) {
            System.out.print("값1? ");
            out.writeInt(Integer.parseInt(keyScan.nextLine()));
            
            System.out.print("연산자? ");
            out.writeUTF(keyScan.nextLine());
            
            System.out.print("값2? ");
            out.writeInt(Integer.parseInt(keyScan.nextLine()));
            
            String str= in.nextLine(); // 서버에서 받은 버퍼를 읽어들여 불려들어 저장한다.
            System.out.println(str);
            
            if (str.equals("quit"))
                break;
        }
        
        in.close();
        out.close();
        socket.close();
    }
}
