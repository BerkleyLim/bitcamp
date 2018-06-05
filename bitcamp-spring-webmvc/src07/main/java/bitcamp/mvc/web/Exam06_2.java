// 요청 핸들러의 리턴 값 - 콘텐트를 직접 리턴하기2
package bitcamp.mvc.web;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping("/exam06_2") 
public class Exam06_2 {
    
    // request handler에서 콘텐트를 직접 리턴할 때는
    // HttpEntity에 담아서 리턴할 수 있다.
    @GetMapping(value="m1")  
    @ResponseBody  
    public HttpEntity<String> m1() {
        // 응답 콘텐트 타입의 기본 콘텐트는 : text/html;charset=ISO-8859-1
        HttpEntity<String> entity = 
                new HttpEntity<>("Exam06_2.m1() ==> 012ABCabc#!@가각간");
        return entity;
    }
    
    @GetMapping(value="m2")  
    @ResponseBody  
    public HttpEntity<String> m2() {
        // 응답 콘텐트의 타입과 문자표를 지정하고 싶다면
        // 응답 헤더를 명시적으로 지정하라!
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "text/plain;charset=UTF-8");
        
        HttpEntity<String> entity = 
                new HttpEntity<>("Exam06_2.m2() ==> 012ABCabc#!@가각간", headers);
        return entity;
    }
    
    @GetMapping(value="m3")  
    @ResponseBody  
    public ResponseEntity<String> m3() {
        // 응답 콘텐트의 타입과 문자표를 지정하고 싶다면
        // 응답 헤더를 명시적으로 지정하라!
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "text/plain;charset=UTF-8");
        
        // ResponseEntity는 HttpEntity의 하위 클래스이다.
        // 응답할 때 상태코드를 설정할 수 있다.
        ResponseEntity<String> entity = new ResponseEntity<>(
                "Exam06_2.m3() ==> 012ABCabc#!@가각간",
                headers,
                HttpStatus.OK);
        return entity;
    }
}







