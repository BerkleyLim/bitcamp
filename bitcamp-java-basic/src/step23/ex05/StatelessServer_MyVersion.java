// Stateless와 Stateful의 비교
package step23.ex05;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// Stateless의 방식의 특징
// => 요청 할 때마다 서버와 연결한다. 응답 받은 후 서버와의 연결을 끊는다.
// => 요청자를 구분할 수 없어 클라이언트의 작업을 구분 불가능 하다.
public class StatelessServer_MyVersion {
     public static void main(String[] args) throws Exception {
         HashMap<String, Integer> hash = new HashMap<>();
         System.out.println("서버 실행 중....");
         // 합계를 계산하는 서버를 만들어보자!
         ServerSocket ss = new ServerSocket(8888);
         
         while (true) {
             Socket socket = ss.accept();
             System.out.println("클라이언트 연결 승인 및 작업 처리 중....");
             
             try (
                 PrintStream out = new PrintStream(socket.getOutputStream());
                 Scanner in = new Scanner(socket.getInputStream());
                 // 이후, 어차피 try 블록문이 끝나면 저절로
                 // close 처리 된다.
                 ) {
                 
                 // 클라이언트와 연결되면 클라이언트는 값을 한 개 보낸다.
                 //서버는 그 클라이언트의 값을 기존 합계에 추가해야 한다.
                 int sum = 0;
                 
                 String[] str = in.nextLine().split(",");
                 if (str[0].isEmpty()) {
                     
                     // 여기서 각각 요소별로 나누고
                     sum = hash.get(str[1]);
                     
                     out.println("결과 = " + sum);
                     hash.remove(str[1]);
                 }
                 try {
                     sum += Integer.parseInt(str[0]);
                     sum += hash.get(str[1]);
                 } catch (Exception e) {}
                 
                 
                 hash.put(str[1], sum);
             }
             
             // "stateful"은 한 번 연결되면 연결을 끊을 때 까지 데이터를 주고 받는다.
             // 그래서 각 클라이언트의 작업 결과(상태 값)를 유지할 수 있다.
             // 단 현재 버전의 문제는 클라이언트가 연결을 끊을 때까지
             // 다른 클라이언트의 요청을 처리하지 못한다는 문제가 있다.
             // 해결책?
             // => 멀티 스레드를 이용하여 동시에 여러 클라이언트의 요청을 처리하면 된다.
             
             // 클라이언트가 데이터를 보낼 때마다 새로 연결을 수행한다.
             // => 데이터를 보낸 클라이언트가 누군지 서버에서 구분할 수 없다.
             // => 이런 방식의 통신이 "stateless"이다.
             // => 클라이언트를 구분할 수 없기 때문에 각각의 클라이언트의 상태를
             //    따로 관리할 수 없다.
             // 해결책?
             // => 클라이언트가 접속할 때 시별번호를 발급하여 클라이언트를 구분한다.
             // => 즉 서버로부터 식별번호를 부여받은 클라이언트는
             //    이후 데이터를 보낼때마다 동시에 수용한다.
         }
     }
}
