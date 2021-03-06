// 애노테이션 프로퍼티 - 선택 프로퍼티
package step20.ex03;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation2 {
    String value() default "홍길동";
        // default 값이 있으면,
        // 애노테이션을 사용할 때 반드시 값을 지정하지 않아도 된다.
}
