// HTTP 프로토콜에 따라 요청을 처리할 서버
package bitcamp.java106.pms;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class HTTPServer {
    int port;
    ApplicationContainer applicationContainer;
    
    public HTTPServer(int port, ApplicationContainer applicationContainer) {
        this.port = port;
        this.applicationContainer = applicationContainer;
    }
    
    public void execute() throws IOException {
     // 서버 소켓 준비
        ServerSocket serverSocket = new ServerSocket(this.port);
        System.out.println("서버 실행 했음!");
        
        while (true) {
            Socket socket = serverSocket.accept();
            
            // 클라이언트 요청을 처리할 코드를 기존의 실행흐름에서 분리하여 실행한다.
            // 그리고 바로 새 스레드(실행흐름)의 실행을 시작시킨다.
            System.out.println("클라이언트 요청 처리중....");
            new RequestProcessorThread(socket);
            
            // 그리고 기존의 실행은 계속 위의 t 스레드와 상관없이 계속 진행한다.
        }
    }

    // 기존의 실행 흐름과 분리하여 명령을 처리할 클래스 
    class RequestProcessorThread extends Thread {
        Socket socket;
        
        public RequestProcessorThread(Socket socket) {
            this.socket = socket;
        }

        // 기존의 실행 흐름에서 분기되어 독립적으로 실행할 코드를 이 메서드에 두어라.
        @Override
        public void run() {
            PrintWriter out = null;
            Scanner in = null;
            
            try {
                out = new PrintWriter(socket.getOutputStream());
                in = new Scanner(socket.getInputStream());
                
                // Request-Line 형식 지정 방법 (SP : Space)
                // = Methos SP Request-URI SP HTTP-Version CRLF
                // HTTP 프로토콜에서 요청 정보를 읽는다..
                boolean firstLine = true;
                String requestURI = null;
                while (true) {
                    String line = in.nextLine();
                    if (line.isEmpty())
                        break;
                    
                    if (!firstLine)
                        continue;
                    
                    // HTTP 요청 프로토콜에서 첫 번째 줄에 있는 요청 URI 정보를 추출한다.
                    requestURI = line.split(" ")[1];
                    firstLine = false;
                }
                
                // ApplicationContainer에게 실행을 요구한다.
                String result = applicationContainer.execute(requestURI);
                
                // HTTP 프로토콜에 따라 응답한다.
                out.println("HTTP/1.1 200 OK");
                out.println("Content-Type: text/plain; Charset=UTF-8");
                out.println("");
                out.println(result);
                
            } catch (Exception e) {
                out.println("서버 오류!");
                e.printStackTrace(out);
                out.println();
            } finally {
                out.close();
                in.close();
                try {socket.close();} catch (Exception e) {}
            }
        }
        
    }
    
}

// ver 30 - Thread 적용
