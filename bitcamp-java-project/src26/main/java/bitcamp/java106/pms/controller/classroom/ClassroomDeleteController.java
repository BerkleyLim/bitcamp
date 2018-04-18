// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.controller.classroom;

import java.sql.Date;
import java.util.Iterator;
import java.util.Scanner;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.ClassroomDao;
import bitcamp.java106.pms.domain.Classroom;
import bitcamp.java106.pms.util.Console;

@Component("classroom/delete")
public class ClassroomDeleteController implements Controller {
    // 입력은 기본!
    private Scanner keyScan;
    private ClassroomDao classroomDao;
    
    public ClassroomDeleteController(Scanner keyScan, ClassroomDao classroomDao) {
        this.keyScan = keyScan;
        this.classroomDao = classroomDao;
    }
    
    public void service(String menu, String option) {
        System.out.println("[수업 삭제]");

        System.out.print("삭제할 수업 번호? ");
        int index = Integer.parseInt(keyScan.nextLine());
        
        Classroom classroom = classroomDao.get(index);
        
        if(classroom == null) {
            System.out.println("삭제할 수업번호와 일치하지 않습니다.");
        } else {
            if(Console.confirm("정말 삭제하시겠습니까?")) {
                System.out.println("삭제하였습니다.");
                classroomDao.delete(classroom);
            } else {
                System.out.println("취소하였습니다.");
            }
        }
    }
}

// ver 26 - ClassroomDeleteController에서 delete() 메서드를 추출하여 클래스로 정의
// ver 23 - @Component 애노테이션을 붙인다. ClassroomDao를 받도록 생성자 변경.
