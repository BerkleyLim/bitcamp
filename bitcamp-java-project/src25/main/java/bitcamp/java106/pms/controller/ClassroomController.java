// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.controller;

import java.sql.Date;
import java.util.Iterator;
import java.util.Scanner;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.dao.ClassroomDao;
import bitcamp.java106.pms.domain.Classroom;
import bitcamp.java106.pms.util.Console;

@Component("classroom")
public class ClassroomController implements Controller {
    // 입력은 기본!
    private Scanner keyScan;
    private ClassroomDao classroomDao;
    
    public ClassroomController(Scanner keyScan, ClassroomDao classroomDao) {
        this.keyScan = keyScan;
        this.classroomDao = classroomDao;
    }
    
    public void service(String menu, String option) {
        if (menu.equals("classroom/add")) {
            onAdd();
        } else if (menu.equals("classroom/list")) {
            onList();
        } else if (menu.equals("classroom/update")) {
            onUpdate();
        } else if (menu.equals("classroom/delete")) {
            onDelete();
        } else {
            System.out.println("명령어가 올바르지 않습니다.");
        }
    }
    
    private void onAdd() {
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
    
    private void onList() {
        System.out.println("[수업 목록]");
        Iterator<Classroom> iterator = classroomDao.list();
        while(iterator.hasNext()) {
            Classroom cr = iterator.next();
            System.out.printf("%d, %s, %s ~ %s, %s\n",
                    cr.getNo(), cr.getClassName(),
                    cr.getStartDate().toString(), cr.getEndDate().toString(),
                    cr.getClassNumber());
        }
    }
    
    private void onUpdate() {
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
    
    private void onDelete() {
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

//ver 23 - @Component 애노테이션을 붙인다. ClassroomDao를 받도록 생성자 변경.
