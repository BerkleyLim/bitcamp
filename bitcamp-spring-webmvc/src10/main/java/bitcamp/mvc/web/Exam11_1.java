// 파일 업로드
package bitcamp.mvc.web;

import java.io.File;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller 
@RequestMapping("/exam11_1") 
public class Exam11_1 {
    
    @Autowired ServletContext sc;
    
    @PostMapping("upload01")
    public void upload01(
            String name, 
            int age,
            MultipartFile[] files,  // 파일이 2개 이상일 경우
            Model model) { 
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        
        String filesDir = sc.getRealPath("/files");
        
        int count = 0;
        for (MultipartFile file : files) {
            String filename = UUID.randomUUID().toString();
            // 원래 파일명
            model.addAttribute("file" + count + "Original", file.getOriginalFilename());
            // 랜덤으로 바뀐 파일명
            model.addAttribute("file" + count + "New", filename);
            count++;
            
            try {
                File path = new File(filesDir + "/" + filename);
                // transferTo를 사용하지 않으면 임시폴더에 저장한다.
                // 임시폴더에 저장된 파일은 일정시간이 지나면 사라진다.
                file.transferTo(path);
                System.out.println(path);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}







