// 제네릭(Generic) - 사용 후
package step13.ex01;

import java.util.ArrayList;
import java.util.HashSet;

public class Exam01_4 {
    public static void main(String[] args) {

        ArrayList<Member> list = new ArrayList<Member>();
        list.add(new Member("홍길동", 20));
        
        // ArrayList를 선언할 때 지정한 타입이 아닌 경우에는 컴파일 오류가 발생한다.
        // => 컬렉션에 잘못된 값이 들어갈 상황을 없앨 수 있다.
        //list.add(new String("Hello"));
        //list.add(new Integer(100));
        //list.add(new HashSet());
        
        // 레퍼런스에 제레릭 정보가 있다면 new 연산자에서는 생략할 수 있다.
        ArrayList<Member> list2 = new ArrayList</*Member*/>(); // OK
        
        ArrayList<Member> list3;
        list3 = new ArrayList<>(); // OK
        
    }
}
