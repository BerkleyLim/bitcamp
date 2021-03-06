// 애노테이션 프로퍼티 값 추출 - 배열 값 추출
package step20.ex05;

public class Exam05 {
    public static void main(String[] args) {
        Class clazz = MyClass5.class;
       
        MyAnnotation3 obj = (MyAnnotation3) clazz.getAnnotation(MyAnnotation3.class);
        System.out.println(obj.v1());
        System.out.println(obj.v2());
        System.out.println(obj.v3());
        /* 실행 결과 
        [Ljava.lang.String;@7f31245a
        [I@6d6f6e28
        [F@135fbaa4
         */
        
        System.out.println(obj.v1()[0]);
        System.out.println(obj.v2()[0]);
        System.out.println(obj.v3()[0]);
        /* 실행 결과 
           '임꺽정
            1111
            1.11
         */
    }
}
