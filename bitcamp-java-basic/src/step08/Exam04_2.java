// 생성자(constructor) - 파라미터를 받는 생성자
package step08;

import java.util.Scanner;

public class Exam04_2 {
    // Exam04_1 클래스 조차도 기본 생성자가 자동으로 추가된다.
    // 즉 다음의 생성자를 컴파일러가 자동으로 붙일 것이다.
    //Exam04_1() { }
    
    static class Score {
        private String name;
        private int kor;
        private int eng;
        private int math;
        private int sum;
        private float average;
        
        // 생성자가 한 개라도 있으면 컴파일러는 기본 생성자를 만들어 주지 않는다.
        public Score(String name, int kor, int eng, int math) {
            System.out.println("Score(String, int, int, int)");
            
            // 파라미터로 받은 값을 새로 만든 인스턴스 변수에 저장한다.
            // => 이렇게 생성자는 새로 만든 인스턴스 변수를 초기화시키는 일을 한다.
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
            compute();
        }
        
        private void compute() { // 계산
            this.sum = this.kor + this.eng + this.math;
            this.average = this.sum / 3f;
        }
        
    }
    
    
    
    public static void main(String[] args) {
        // Score 클래스에는 기본 생성자가 없기 때문에
        // 다음 문장은 컴파일 오류다!
        //Score s1 = new Score();
        
        // Score 인스턴스 만든 후에는 생성자가 원하는 값을 주어 초기화 시켜야 한다.
        // 생성자를 호출할 대 그 생성자의 파라미터 값을 주어야 한다.
        // Score(String name, int kor, int eng, int math){}
        Score s2 = new Score("홍길동", 100, 90, 80);
        Score s3 = new Score("임꺽정", 80, 88, 87);
        
        // 새성자에서 이미 계산을 수행했기 때문에
        // 합계와 평균을 계산하기 위해 따로 compute()를 호출할 필요가 없다.
        // 이것이 생성자를 사용하는 이유이다.
        System.out.printf("%s, %d, %d, %d, %d, %.1f\n", 
                s2.name, s2.kor, s2.eng, s2.math, s2.sum, s2.average);
        
        System.out.printf("%s, %d, %d, %d, %d, %.1f\n", 
                s3.name, s3.kor, s3.eng, s3.math, s3.sum, s3.average);
    }
}

// 생성자?
// => 인스턴스(객체)를 생성한 후에 사용하기 전에 유효한 값으로 초기화시켜 작업을 수행한다.
