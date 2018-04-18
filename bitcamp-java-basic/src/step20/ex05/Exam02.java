// 애노테이션 프로퍼티 값 추출 - 배열 값 추출
package step20.ex05;

public class Exam02 {
    public static void main(String[] args) {
        Class clazz = MyClass2.class;
       
        MyAnnotation2 obj = (MyAnnotation2) clazz.getAnnotation(MyAnnotation2.class);
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
           '가나다
            100
            3.14
         */
    }
}
