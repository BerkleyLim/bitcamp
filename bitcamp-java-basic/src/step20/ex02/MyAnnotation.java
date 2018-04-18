// 애노테이션 유지 정책
// => SOURCE : 소스 파일에만 남긴다. 컴파일 후 제거된다.
// => CLASS : .class 파일에 남긴다. 그러나 실행 시에 추출할 수 없다.
// => RUNTIME : .class 파일에 남긴다. 실행 시에 추출할 수 있다.
package step20.ex02;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// 애노테이션의 유지 정책을 지정하지 않으면 기본이 CLASS이다.
@Retention(RetentionPolicy.CLASS)
public @interface MyAnnotation {
    // 주석의 프로퍼티를 정의할 수 있다.
    // => 인터페이스에서 메서드를 정의하는 것과 유사한다.
    // => 단, 메서드 이름은 프로퍼티(변수)명처럼 작성한다.
    //    즉 일반적인 메서드는 보통 동사로 이름을 시작하지만,
    //    애노테이션은 명사로 이름을 짓는다.
    String value();
}
