// AppServer에 접속할 클라이언트 만들기
package bitcamp.java106.pms;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class AppClient {
    static String serverAddr;
    static int port;
    static String requestPath;
    
    public static void main(String[] args) throws Exception {
        // >java -cp bin/main bitcamp.java106.pms.AppClient [서버주소]
        Scanner keyScan = new Scanner(System.in);
        
        while (true) {
            System.out.print("요청> ");
            
            // 예) http://192.168.0.7:8888/board/list
            String str= keyScan.nextLine().replace("http://", "");

            int colonIndex = str.indexOf(':');
            int slashIndex = str.indexOf('/');
            
            if (colonIndex != -1) { // 찾았다면.
             // 예) 192.168.0.7:8888/board/list
                serverAddr = str.substring(0, colonIndex);
                port = Integer.parseInt(
                        str.substring(colonIndex + 1, slashIndex));
            } else {
             // 예) 192.168.0.7/board/list
                serverAddr = str.substring(0, slashIndex);
                port = 80;
            }

            requestPath = str.substring(slashIndex + 1);
            
            if (str.equals("quit"))
                break;
            send();
        }
        keyScan.close();
    }
    
    static void send() {
        try (
            Socket socket = new Socket("localhost", 8888);
            PrintStream out = new PrintStream(socket.getOutputStream());
            Scanner in = new Scanner(socket.getInputStream());) {
            
            out.println(requestPath);
            
            while (true) {
                String str = in.nextLine();
                if (str.isEmpty())
                    break;
                System.out.println(str);
            }
        } catch (Exception e) {
            System.out.println("서버 요청중 오류 발생!");
        }
        
    }
}
