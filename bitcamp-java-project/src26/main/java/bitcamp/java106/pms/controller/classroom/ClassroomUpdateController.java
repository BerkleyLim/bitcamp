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

@Component("classroom/update")
public class ClassroomUpdateController implements Controller {
    // 입력은 기본!
    private Scanner keyScan;
    private ClassroomDao classroomDao;
    
    public ClassroomUpdateController(Scanner keyScan, ClassroomDao classroomDao) {
        this.keyScan = keyScan;
        this.classroomDao = classroomDao;
    }
    
    public void service(String menu, String option) {
        System.out.println("[수업 정보 변경]");
        
        System.out.print("변경할 수업 번호? ");
        String index = keyScan.nextLine();
        
        if (index.length() == 0) {
            System.out.println("번호를 입력하시기 바랍니다.");
        }
        
        Classroom classroom = classroomDao.get(Integer.parseInt(index));
       
        if (classroom == null) {
            System.out.println("유효하지 않는 수업 번호입니다.");
            return;
        }
        
        Classroom updateClassroom = new Classroom();
        
        updateClassroom.setNo(classroom.getNo());
        
        System.out.printf("수업명(%s)? ", classroom.getClassName());
        String str = keyScan.nextLine();
        if (str.length() == 0) {
            updateClassroom.setClassName(classroom.getClassName());
        } else {
            updateClassroom.setClassName(str);
        }
        
        
        System.out.printf("시작일(%s)? ", classroom.getStartDate().toString());
        str = keyScan.nextLine();
        if (str.length() == 0) {
            updateClassroom.setStartDate(classroom.getStartDate());
        } else {
            updateClassroom.setStartDate(Date.valueOf(str));
        }
        
        
        System.out.printf("종료일(%s)? ", classroom.getEndDate().toString());
        str = keyScan.nextLine();
        if (str.length() == 0) {
            updateClassroom.setEndDate(classroom.getEndDate());
        } else {
            updateClassroom.setEndDate(Date.valueOf(str));
        }
        
        System.out.print("교실번호? ");
        updateClassroom.setClassNumber(keyScan.nextLine());

        
        if(Console.confirm("변경하시겠습니까?")) {
            System.out.println("변경하였습니다.");
            classroomDao.update(Integer.parseInt(index), updateClassroom);
        } else {
            System.out.println("취소하였습니다.");
        }
    }
}

// ver 26 - ClassroomUpdateController에서 update() 메서드를 추출하여 클래스로 정의
// ver 23 - @Component 애노테이션을 붙인다. ClassroomDao를 받도록 생성자 변경.
