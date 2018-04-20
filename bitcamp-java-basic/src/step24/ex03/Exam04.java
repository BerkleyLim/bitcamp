// Thread를 Runnable로 받기 응용
package step24.ex03;

public class Exam04 {
    public static void main(String[] args) {
        
        // 스레드 실행하기
        // => Runnable 구현체를 Thread에 실어서 실행한다.
        // => start()를 호출하여 기존 스레드에서 분리하여 스레드를 실행시킨다.
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 별도로 분리해서 병행으로 실행할 코드!
                for (int i = 0; i < 1000; i++) {
                    System.out.println("===> " + i);
                }
            }
        }).start();
        
        // "main" 스레드는 MyThread와 상관없이 병행하여 실행한다.
        for (int i = 0; i < 1000; i++) {
            System.out.println(">>>> " + i);
        }
    }
}
