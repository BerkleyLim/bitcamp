// 레퍼런스와 인스턴스 - 인스턴스 주고 받기
package step03;

public class Exam03_2 {
    public static void main(String[] args) {
        // 여러개의 인스턴스 주소 저장하기

        class Score {
            String name;
            int kor;
            int eng;
            int math;
            int sum;
            float aver;  
        }

        // Score 레퍼런스 선언
        Score s1 = new Score();

        // 인스턴스를 만들어 그 주소를 레퍼런스에 저장한다.
        s1 = new Score();

        // s1에 저장된 주소를 s2에도 저장한다.
        Score s2 = s1;

        s1.name = "홍길동";
        
        System.out.println(s2.name);

    }
}