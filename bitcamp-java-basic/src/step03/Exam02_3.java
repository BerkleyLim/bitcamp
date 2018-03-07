// 클래스 - 레퍼런스 배열
package step03;

public class Exam02_3 {
    public static void main(String[] args) {
        // 여러개의 인스턴스 주소를 저장하려면?
        // - 레퍼런스 배열을 이용하면 된다.

        class Score {
            String name;
            int kor;
            int eng;
            int math;
            int sum;
            float aver;  
        }

        // Score 레퍼런스를 여러개 준비한다.
        // => 레퍼런스 배열의 준비 (인스턴스 배열이 아니다!)
        Score[] arr = new Score[3];

        // 반복문 이용하여 인스턴스를 만들어 주소를 저장한다. 

        for (int i = 0; i < arr.length; i++)
            arr[i]= new Score();

        // 값 저장 시 일일히 값을 지정
        arr[0].name = "홍길동";
        arr[1].name = "임꺽정";
        arr[2].name = "유관순";

        // 반복문 사용하면 배열의 인스턴스 값을 꺼내기 쉬움.
        for(int i = 0; i > arr.length; i++) 
            System.out.printf("이름 : %s\n", arr[i].name); 
    }
}

// 결론!
// - 배열은 반복문과 함께 쓸 때 특히 유용한다.