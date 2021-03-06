// 애노테이션 적용 범위
package step20.ex06;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// @Target을 사용하여 애노테이션을 붙일 수 있는 범위를 지정할 수 있다.
@Target({ElementType.METHOD, ElementType.TYPE}) // 메서드, 타입(인터페이스 및 클래스) 만 적용범위 지정
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String v1() default "가나다";
    int v2() default 100;
    float v3() default 3.14f;
}
