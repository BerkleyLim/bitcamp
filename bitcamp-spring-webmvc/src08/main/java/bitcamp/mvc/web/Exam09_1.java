// 인터셉터 - 페이지 컨트롤러를 실행하기 전후에 개입하기. 필터와 같은 역할을 한다.
package bitcamp.mvc.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerInterceptor;

@Controller 
@RequestMapping("/exam09_1") 
public class Exam09_1 implements HandlerInterceptor{ 
    
    @GetMapping(value="aaa/m1", produces="text/plain;charset=UTF-8")
    public String m1() {
        // 테스트:
        //      http://localhost:8888/bitcamp-spring-webmvc/mvc/exam09_1/aaa/m1
        System.out.println("Exam09_1.m1()");
        return "exam09_1";
    }
    
    @GetMapping(value="aaa/m2", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m2() {
        // 테스트:
        //      http://localhost:8888/bitcamp-spring-webmvc/mvc/exam09_1/aaa/m2
        System.out.println("Exam09_1.m2()");
        return "exam09_1";
    }
    
    @GetMapping(value="bbb/m3", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m3() {
        // 테스트:
        //      http://localhost:8888/bitcamp-spring-webmvc/mvc/exam09_1/bbb/m3
        System.out.println("Exam09_1.m3()");
        return "exam09_1";
    }
}