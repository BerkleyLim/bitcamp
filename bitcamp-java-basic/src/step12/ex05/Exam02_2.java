package step12.ex05;

import java.util.LinkedList;
import java.util.Iterator;


public class Exam02_2 {
    public static void main(String[] args) {
        String s1 = new String("aaa");
        String s2 = new String("bbb");
        String s3 = new String("ccc");
        String s4 = new String("ddd");
        String s5 = new String("eee");
        
        LinkedList list = new LinkedList();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);
        
        Iterator 컬렉션에서값을꺼내주는객체 = list.iterator();
        
        // => 값을 꺼내주는 객체를 값을 꺼낸다
        while(컬렉션에서값을꺼내주는객체.hasNext()) {
            // => 꺼낼 데이터가 있다면 값을 꺼내달라고 명령한다.
            System.out.println(컬렉션에서값을꺼내주는객체.next() + ", ");
        }
        System.out.println();
    }
    
}
