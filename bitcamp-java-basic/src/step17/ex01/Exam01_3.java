// 클래스의 종류 : non-static 중첩 클래스(nested class)의 사용
package step17.ex01;

import java.io.File;
import java.io.FilenameFilter;

public class Exam01_3 {
    
    // non-static nested class = inner class 
    // => 스태틱이 붙지 않은 중첩 클래스
    // => 이 클래스는 인스턴스가 있어야만 사용할 수 있다.
    // => 보통 인스턴스 멤버를 사용하는 중첩 클래스를 만들 때 inner class로 정의한다.
    // => 당연히 inner 클래스는 인스턴스 메서드에서 주로 사용할 것이다.
    class JavaFilter implements FilenameFilter {
        public boolean accept(File dir, String name) {
            if (name.endsWith(".java"))
                return true;  // 조회 결과에 포함시켜라!
            return false;  // 조회 결과에서 제외하라!
        }
    }
    
    public void test() {
        File dir = new File(".");
        
        // inner class의 인스턴스를 생성한다.
        JavaFilter javaFilter = new JavaFilter();
        
        // inner class 안에 있는 인스턴스의 필터를 사용하여 디렉토리 안의 목록을 추출한다.
        String[] names = dir.list(javaFilter);
        
        for(String name : names) {
            System.out.println(name);
        }
    }

    public static void main(String[] args) throws Exception {
        Exam01_3 obj = new Exam01_3();
        obj.test();
    }
}
