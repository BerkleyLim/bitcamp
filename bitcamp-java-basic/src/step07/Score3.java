package step07;
// 사용자 정의 데이터 타입 - 메소드 = 연산자
// => 학생 데이터를 담을 새로운 구조의 메모리를 설계한다.
class Score3 {
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float average;
    
    // 다음 연산자는 계산을 수행할 대마다 인스턴스의 주소를 파라미터로 받아야 한다.
    // 인스턴스 메서드!
    //public static void calculate(Score3 score) { 
    // /   score.sum = score.kor + score.eng + score.math;
    //    score.average  = (float) score.sum / 3f;
    //}

    // 인스턴스 메서드
    // => 인스턴스의 주소를 파라미터로 받는 것이 아니라,
    //    메서드를 호출할 때(연산자를 사용할 때), 
    //    매서드 앞에 인스턴스의 주소를 적는다.
    // => 이 인스턴스의 주소는 내부에 내장된 this라는 변수에 자동 복사된다.
    //    그래서 파라미터 대신 this를 사용하면 된다.
    // => 인스턴스 메서드는 static을 붙이지 않는다.
    public void calculate() {
        this.sum = this.kor + this.eng + this.math;
        this.average = this.sum / 3f;
    }
}

// 클래스 메서드
// => static이 붙는 메서드
// => 특정 인스턴스가 아닌 모든 인스턴스에 대해 작업을 수행할 때 사용하는 메서드이다.
// => 사용법
//    클래스명.메서드명();
//    레퍼런스.메서드명();
//    그러나 가능한 레퍼런스를 사용하여 클래스 멧드를 호출 금지
//    타 개발자가 헷깔려 함

// 인스턴스 메서드
// => static이 붙지 않는 메서드
// => 특정 인스턴스에 대해 작업을 수행할 때 사용하는 메셔드이다.
// => 사용법
//    레퍼런스.메서드명();
//    