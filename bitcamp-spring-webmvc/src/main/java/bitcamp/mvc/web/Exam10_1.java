// JSON 데이터 출력하기 - 적용 전
package bitcamp.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerInterceptor;

import bitcamp.mvc.dao.BoardDao;

@Controller 
@RequestMapping("/exam10_1") 
public class Exam10_1 implements HandlerInterceptor{ 
    
    BoardDao boardDao;
    
    public Exam10_1(BoardDao boardDao) {
        this.boardDao = boardDao;
    }
    
    @GetMapping("list")
    public String list() {
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