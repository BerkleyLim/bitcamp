// 세션 다루기 - HttpSession에 보관된 데이터 꺼내기
package bitcamp.mvc.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping("/exam08_2") 
public class Exam08_2 {

    @GetMapping(value="m1", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m1(HttpSession session) {
        // 테스트:
        //      http://localhost:8888/bitcamp-spring-webmvc/mvc/exam08_2/m1
        // 세션에 보관된 값을 꺼내 출력하기
        return String.format("m1(): name=%s, age=%d, working=%b",
                session.getAttribute("name"),
                session.getAttribute("age"),
                session.getAttribute("working"));
    }
    
    @GetMapping(value="m2", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m2(HttpSession session) {
        // 테스트:
        //      http://localhost:8888/bitcamp-spring-webmvc/mvc/exam08_2/m2
        // 세션에 무효화하기
        session.invalidate();
        
        return String.format("m2(): 세션 무효화시킴!");
    }
    
}





