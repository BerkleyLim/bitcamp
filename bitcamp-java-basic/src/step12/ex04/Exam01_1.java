// queue 사용
package step12.ex04;

import step12.ex02.LinkedList;

public class Exam01_1 {
    public static void main(String[] args) {
        String s1 = new String("aaa");
        String s2 = new String("bbb");
        String s3 = new String("ccc");
        String s4 = new String("ddd");
        String s5 = new String("eee");
        
        Queue queue = new Queue();
        queue.offer(s1);
        print(queue);
        System.out.println("-------------------------------");
        queue.offer(s2);
        print(queue);
        System.out.println("-------------------------------");
        queue.offer(s3);
        print(queue);
        System.out.println("-------------------------------");
        System.out.println("==>" + queue.poll()); // ccc
        System.out.println("==>" + queue.poll()); // bbb
        
        queue.offer(s4);
        print(queue);
        System.out.println("-------------------------------");
        queue.offer(s5);
        print(queue);
        System.out.println("-------------------------------");
        
        String value;
        while((value = (String) queue.poll()) != null) {
            System.out.println(value);
        }
        
    }
    
    static void print(LinkedList list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i) + ", ");
        }
    }
}
