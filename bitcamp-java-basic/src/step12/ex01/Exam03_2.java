// java.util.ArrayList의 indexOf()의 사용
package step12.ex01;

import java.util.ArrayList;

public class Exam03_2 {
    // hashCode()와 equals()을 오버라이딩 한    public static void main(String[] args) {
        String s1 = new String("aaa");
        String s2 = new String("bbb");
        String s3 = new String("ccc");
        String s4 = new String("bbb"); // s2 != s4
        
        ArrayList list = new ArrayList();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        
        print(list);
        
        // Member 클래스는 equals()를 오버라이딩 했다!!!!!!!!!!!!!
        // 따라서 인스턴스가 다르더라도 Member의 name과 age 값이 같다면
        // equals()의 검사 결과도 true이기 때문에,
        // contains()로 객체가 있는지 판단할 것이다.
        System.out.println(list.contains(s4)); // true
    }
    
    static void print(ArrayList list) {
        for (int i =0; i < list.size(); i++) {
            System.out.print(list.get(i) + ", ");
        }
        System.out.println();
    }
}
