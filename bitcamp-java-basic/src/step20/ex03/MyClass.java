// 애노테이션 프로퍼티 값 지정하기
// => @애노테이션이름(프로퍼티명=값, 프로퍼티명=값, ......)
package step20.ex03;

//@MyAnnotation // 필수 프로퍼티 값을 지정하지 않으면 컴파일 오류!
@MyAnnotation2  // 선택 프로퍼티 값을MyAnnotation.java 지정하지 않으면 default 값이 사용된다.
public class MyClass {
}
