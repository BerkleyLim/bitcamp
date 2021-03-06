// 부동소숫점 변수 - 단정도와 배정도
package step02;

public class Exam05_2 {
    public static void main(String[] args) {
        float f;
        double d;

        // 부동소숫점 리터럴 값 뒤에 f나 F를 붙이면,
        // 4byte 크기의 부동소숫점 값을 의미한다.
        // 땨라서 변수(메모리)에 값을 넣기 전에  
        // 이미 리터럴 값이 4바이트 크기로 고정시키기 위해서
        // 유효자릿수를 넘어가는 값은 짤린다.
        // 그래서 d 변수에 저장된 값은 짤린 값은 이미 4byte 메모리에
        // 저장될 수 있도록 짤린 값이 저장된다.
        f = 9876.98769876f;
        d = 9876.98769876f;

        System.out.println("f의 값 : " + f);
        System.out.println("d의 값 : " + d);
        // 주의!!!!
        // 정수의 경우 리터럴을 표현할 때
        // 값이 그 크기를 넘어가면 컴파일 오류가 발생하지만
        // 부동소숫점의 경우 리터럴이 메모리의 크기를 넘어갈 때
        // 컴파일 오류 대신 단지 값이 짤릴 뿐이다.


        // double(8byte) 값 ==> float(4byte) 메모리
        //f = 9876.98769876; // 컴파일 오류 발생 -> double형을 -> float형으로 X 
        f = 9876.98769876f; // 이게 맞음!!

        // double 메모리에 리터럴 값을 넣을 때는
        // 8byte 부동소수점 리터럴을 넣어라!!
        // 즉 리터럴 뒤에 f나 F를 붙이면 안된다!!!
        d = 9876.98769876;

        System.out.println("f의 값 : " + f);
        System.out.println("d의 값 : " + d);  //   
    }
}

// 결론!
// - float 메모리에 값을 저장 시, 유효자릿수 7자리 이하인 수를 4byte 
//   부동소숫점(f 또는 F)을 저장하라.
// - double 메모리에 값을 저장 시, 유효자릿수가 15자리 이하인 8byte 부동소숫점을
//   저장하라.

/*
실행 결과
f의 값 : 9876.987         // 유효숫자 7자리
d의 값 : 9876.9873046875  // 유효숫자 15자리, 단, 더블형 d에서는 float형으로 저장
                          // 하였기 때문이다!!!! <7자리만 제대로 저장, 나머지
                          // 쓰레기 값으로 저장!!> => 3046875 부분은 쓰레기 값!!
f의 값 : 9876.987
d의 값 : 9876.98769876
*/
