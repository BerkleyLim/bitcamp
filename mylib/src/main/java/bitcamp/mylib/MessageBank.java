package bitcamp.mylib;

import java.util.HashMap;

// 라이브러리 파일을 자기가 만들기
public class MessageBank {
    static HashMap<String,String> messageMap = new HashMap<>();
    
    static {
        messageMap.put("hello", "안녕하세요!");
        messageMap.put("goodbye", "안녕히 가세요!");
        messageMap.put("thanks", "감사합니다!");
    }
    
    public static String getMessage(String name) {
        return messageMap.get(name);
    }
}
