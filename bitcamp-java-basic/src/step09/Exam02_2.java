// 인스턴스 메서드와 클래스 메서드의 활용 - wrapper 클래스
package step09;

public class Exam02_2 {
    public static void main(String[] args) throws Exception {
        Integer i1 = new Integer(100);
        Integer i2 = new Integer(200);
        Integer i3 = new Integer(300);
        
        // 인스턴스 메서드 사용<현재 Integer 값과 파라미터 값과의 비교한다.>
        System.out.println(i2.compareTo(i1));
        System.out.println(i2.compareTo(i3));
        
        // intValue() : 객체 int(Integer)를 primative int로 변환
        int v1 = i2.intValue();
        System.out.println(v1);
        
        // 스태틱 메서드 = 클래스 메서드 사용
        // Integer.parseInt("숫자로 된 문자열") : 문자열을 숫자로 바꾸는 것, static 메서드
        int v2 = Integer.parseInt("1280");
        String s1 = Integer.toBinaryString(77); // 2진수를 문자열로, static 메서드 
        String s2 = Integer.toOctalString(77);  // 8진수를 문자열로, static 메서드
        String s3 = Integer.toHexString(77).toUpperCase();  // 16진수를 문자열로, static 메서드
        System.out.printf("77: %s, %s, %s\n", s1, s2, s3);
        
        // Integer.valueOf() : 문자열을 Integer로 변환할 때
        Integer x1 = Integer.valueOf("44"); // 문자열에 있는 수를 10진수로 간주한다.
        Integer x2 = Integer.valueOf("44", 16); // 16진수라고 지정한다.
        System.out.printf("%d, %d\n", x1, x2);
        
        float f = Float.parseFloat("3.14f");  // 문자열을 실수형으로
        boolean b = Boolean.parseBoolean("true"); // 문자열을 boolean형으로 
        System.out.printf("%f, %b\n", f, b);
    }
}