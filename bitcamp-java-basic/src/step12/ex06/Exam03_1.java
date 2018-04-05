//
package step12.ex06;

import java.util.HashMap;
import java.util.Hashtable;

public class Exam03_1 {
    public static void main(String[] args) {
        HashMap map = new HashMap(); 
        map.put(null, "홍길동"); // 1) null을 key로 사용 가능 
        map.put("s01", null);  // 2) value가 null이 될수 있다.
                               // 3) 동기화를 지원하지 않는다.
                               // 머티 스레드가 동시에 사용할 때 문제 발생
                               // 속도 빠름
        
        Hashtable table = new Hashtable();
        //table.put(null, "홍길동"); // 실행 오류! key가 null이 될 수 없다.
        table.put("s02", null);  // value가 null이 될 수 없다.
    }
}
