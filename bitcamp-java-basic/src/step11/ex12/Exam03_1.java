// 오버라이딩(Overriding) - 응용 예
package step11.ex12;

public class Exam03_1 {
    
    int i; // 인스턴스 변수는 인스턴스 주소가 있어야 호출 가능
    
    void m() { // 인스턴스 메소드
        this.i = 100;   // 내장된 변수에 가능 
    }
    
    static void m2() { // 스태틱 메소드
        //this.i = 300;  // 여기선 스태틱자체가 붙으면 this는 붙을 수 없음
    }
    
    static class Member {
        String name;
        int age;
        public Member(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
    
    public static void main(String[] args) {
        // Object 클래스?
        //this.m(); // 호출 불가(main 자체가 static이기 때문에)
        
        // 클래스 안에서도 클래스 생성 가능!!
        Exam03_1 obj = new Exam03_1();
        obj.i = 100;
        obj.m();
        
        // 내부 클래스 생성시 만드는 방법 - 인스턴스 클래스일때
        /*
        Exam09_1 a = new Exam09_1();
        Member obj2;
        obj2 = a.new Member();
        */
        
        Member m1 = new Member("홍길동", 20);
        Member m2 = new Member("홍길동", 20);
        
        if (m1 == m2)
            System.out.println("m1 == m2");
        else 
            System.out.println("m1 != m2");
        
        // => 클래스를 만들 때 수퍼 클래스를 지정하지 않은면,
        //    자동으로 Object를 상속받게 된다.
        //    따라서 자바의 모든 클래스는 Object의 자손이다.
        // => 그래서 자바의 모든 클래스는 Object의 메서드르 사용 할 수 잇따.

        // 상속 받은 메서드 중에서 equals() 메서드를 살펴보자!
        System.out.println(m1.equals(m2));
        // 어? Member 클래스에 equals()를 정의한 적이 없는데?
        // => 클래스를 만들 때 수퍼 클래스를 지정하지 않으면,
        //    자동으로 Obje3ct를 상속받게 된다
        //    따라서 자바의 모든 클래스는 Object의 자손이다.
        // => 그래서 자바의 모든 클래스는 Object의 메서드를 사용할 수 있다.
        //    equals()는 Object로 부터 상속 받은 메서드 중에 하나이다.
        // equals()는 String을 사용할 때 문자열 비교에 사용했던 메서드이다.
        // 두 문자열의 인스턴스가 달라도 내용이 같아도 true를 리턴했다.
        // 그런데 위의 실행 결과를 보면 m1과 m2가 비록 인스턴스는 다르지만
        // 내용이 같이 때문에 true를 리턴할 것이라 예상했는데
        // 실제 리턴 값을 확인해보면 false를 리턴한다.
        // 이유?
        // => Object 클래스에서 상속 받아 쓰는 equals()는 원래 내용물을 비교하는 게 아니라
        //    인스턴스가 같은지를 비교하는 메서드이다.
        // => m1, m2 인스턴스가 다르니 당연히 그 결과가 false 인 것이다.
        
        // Member의 내용이 같은지 비교하고 싶은가?
        // => 이럴 때 "오버라이딩"을 사용하는 것이다.
        // => 즉 Object로부터 상속 받은 메서드가 Member 클래스에 맞지 않다.
        //    그럼 Member 클래스에 맞게 끔 재정의하면 되는 것이다.
        // 다음 Exam09_2를 보라!
    }
    
}
