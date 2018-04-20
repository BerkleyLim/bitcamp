// 스레드 그룹에 소속된 하위 그룹들
package step24.ex02;

public class Exam05 {
    public static void main(String[] args) {
        // 이 순간 실행중인 흐름이 무엇인지 알고 싶다면,
        Thread main = Thread.currentThread();
        ThreadGroup mainGroup = main.getThreadGroup();
        
        // 스레드 그룹에 소속된 부모 그룹을 알고 싶다면?
        ThreadGroup parentGroup = mainGroup.getParent();
        System.out.println(parentGroup.getName());
        
        // "system" 그룹에 소속된 부모 그룹을 알고 싶다면?
        ThreadGroup grandParentGroup = parentGroup.getParent();
        if(grandParentGroup != null)
            System.out.println(grandParentGroup.getName());
        
        // "System" 스레드 그룹:
        //     "main" 스레드 그룹:
        //         => "main" 스레드
        //         => 다른 하위 그룹은 없다!
    }
}
