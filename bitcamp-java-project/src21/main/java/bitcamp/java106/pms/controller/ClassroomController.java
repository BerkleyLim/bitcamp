// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.controller;

import java.sql.Date;
import java.util.Scanner;

import bitcamp.java106.pms.dao.ClassroomDao;
import bitcamp.java106.pms.domain.Classroom;
import bitcamp.java106.pms.util.Console;

//ClassroomController는 Controller 규칙을 이행한다.
//=> Controller 규칙에 따라 메서드를 만든다.
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
        Classroom[] classrooms = classroomDao.list();
        for(Classroom cr : classrooms) {
            if(cr == null) continue;
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
            classroomDao.update(updateClassroom);
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


/*
 * 추가
 * 명령> classroom/add
[수업 등록]
수업명? java10
시작일? 1111-1-1
종료일? 2222-2-2
교실번호? 301

명령> classroom/update
[수업 정보 변경]
변경할 수업 번호? 1
수업번호를 찾을 수 없습니다.

명령> classroom/update
[수업 정보 변경]
변경할 수업 번호? 0
수업명(java10)? java106
시작일(1111-01-01)? 2018-2-26
종료일(2222-02-02)? 2018-8-20
교실번호? 401
변경하시겠습니까? (y/N)y
변경하였습니다.

명령> classroom/list
[수업 목록]
0, java106, 2018-02-26 ~ 2018-08-20, 401

명령> classroom/add
[수업 등록]
수업명? java107
시작일? 2018-3-25
종료일? 2018-9-20
교실번호? 501

명령> classroom/add
[수업 등록]
수업명? java105
시작일? 2018-2-26
종료일? 2018-2-20
교실번호? 603

명령> classroom/list
[수업 목록]
0, java106, 2018-02-26 ~ 2018-08-20, 401
1, java107, 2018-03-25 ~ 2018-09-20, 501
2, java105, 2018-02-26 ~ 2018-02-20, 603

명령> classroom/delete
[수업 삭제]
삭제할 수업 번호? 1
정말 삭제하시겠습니까? (y/N)y
삭제하였습니다.

명령> classroom/delete
[수업 삭제]
삭제할 수업 번호? 4
삭제할 수업번호와 일치하지 않습니다.

명령> classroom/list
[수업 목록]
0, java106, 2018-02-26 ~ 2018-08-20, 401
2, java105, 2018-02-26 ~ 2018-02-20, 603

명령> quit
안녕히 가세요!

 * */