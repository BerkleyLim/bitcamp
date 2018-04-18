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

@Component("classroom/add")
public class ClassroomAddController implements Controller {
    // 입력은 기본!
    private Scanner keyScan;
    private ClassroomDao classroomDao;
    
    public ClassroomAddController(Scanner keyScan, ClassroomDao classroomDao) {
        this.keyScan = keyScan;
        this.classroomDao = classroomDao;
    }
    
    public void service(String menu, String option) {
        System.out.println("[수업 등록]");
        
        Classroom classroom = new Classroom();
        
        System.out.print("수업명? ");
        classroom.setClassName(keyScan.nextLine());
        
        System.out.print("시작일? ");
        classroom.setStartDate(Date.valueOf(keyScan.nextLine()));
        
        System.out.print("종료일? ");
        classroom.setEndDate(Date.valueOf(keyScan.nextLine()));
        
        System.out.print("교실번호? ");
        classroom.setClassNumber(keyScan.nextLine());
        
        // 여기서 함수 넣기!
        classroomDao.insert(classroom);
    }
    
}

// ver 26 - ClassroomAddController에서 add() 메서드를 추출하여 클래스로 정의
// ver 23 - @Component 애노테이션을 붙인다. ClassroomDao를 받도록 생성자 변경.
