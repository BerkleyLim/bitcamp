// 이 클래스는 명령창에서 사용할 기능을 모아 둔 클래스이다.
package bitcamp.java106.pms.util;

import java.util.Scanner;

public class Console {
    // 이 클래스를 사용하기 전에 반드시 Scanner 객체를 설정하라!
    private static Scanner keyScan;

    public Console(Scanner keyScan) {
        this.keyScan = keyScan;
    }
    
    // 조건식 yes/no
    public static boolean confirm(String message) {
        System.out.printf("%s (Y/N)", message);
        String input = keyScan.nextLine().toLowerCase();
        if (input.equals("y"))
            return true;
        else 
            return false;
    }

    // 명령 프롬프트
    public String[] prompt() {
        System.out.print("명령> ");
        return keyScan.nextLine().toLowerCase().split(" ");
    }


}