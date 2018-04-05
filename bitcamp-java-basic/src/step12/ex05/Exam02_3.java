package step12.ex05;

import java.util.Stack;
import java.util.Iterator;


public class Exam02_3 {
    public static void main(String[] args) {
        String s1 = new String("aaa");
        String s2 = new String("bbb");
        String s3 = new String("ccc");
        String s4 = new String("ddd");
        String s5 = new String("eee");
        
        Stack stack = new Stack();
        stack.push(s1);
        stack.push(s2);
        stack.push(s3);
        stack.push(s4);
        stack.push(s5);
        
        Iterator 컬렉션에서값을꺼내주는객체 = stack.iterator();
        
        // => 값을 꺼내주는 객체를 값을 꺼낸다
        while(컬렉션에서값을꺼내주는객체.hasNext()) {
            // => 꺼낼 데이터가 있다면 값을 꺼내달라고 명령한다.
            System.out.println(컬렉션에서값을꺼내주는객체.next() + ", ");
        }
        System.out.println();
    }
    
}
