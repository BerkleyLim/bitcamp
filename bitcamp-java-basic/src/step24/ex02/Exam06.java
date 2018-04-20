// 스레드 그룹에 소속된 하위 그룹들
package step24.ex02;

public class Exam06 {
    public static void main(String[] args) {
        // 이 순간 실행중인 흐름이 무엇인지 알고 싶다면,
        Thread main = Thread.currentThread();
        ThreadGroup mainGroup = main.getThreadGroup();
        ThreadGroup systemGroup = mainGroup.getParent();
        
        ThreadGroup[] groups = new ThreadGroup[100];
        int count = systemGroup.enumerate(groups, false);
        
        System.out.println("System 스레드 그룹의 자식 그룹들:");
        for (int i = 0; i < count; i++) {
            System.out.println("    =>" + groups[i].getName());
        }
        
        // "System" 스레드 그룹:
        //     "main" 스레드 그룹:
        //         => "main" 스레드
        //         => 다른 하위 그룹은 없다!
    }
}
