package bitcamp.java106.pms.controller;

import java.sql.Date;
import java.util.Scanner;

import bitcamp.java106.pms.dao.ClassRoomDao;
import bitcamp.java106.pms.domain.ClassRoom;
import bitcamp.java106.pms.util.Console;

public class ClassRoomController {
    // 입력은 기본!
    private Scanner keyScan;
    private ClassRoomDao classRoomDao;
    
    public ClassRoomController(Scanner keyScan, ClassRoomDao classRoomDao) {
        this.keyScan = keyScan;
        this.classRoomDao = classRoomDao;
    }
    
    public void service(String menu, String option) {
        if (menu.equals("classroom/add")) {
            onClassRoomAdd();
        } else if (menu.equals("classroom/list")) {
            onClassRoomList();
        } else if (menu.equals("classroom/update")) {
            onClassRoomUpdate();
        } else if (menu.equals("classroom/delete")) {
            onClassRoomDelete();
        } else {
            System.out.println("명령어가 올바르지 않습니다.");
        }
    }
    
    private void onClassRoomAdd() {
        System.out.println("[수업 등록]");
        
        ClassRoom classRoom = new ClassRoom();
        
        System.out.print("수업명? ");
        classRoom.setClassName(keyScan.nextLine());
        
        System.out.print("시작일? ");
        classRoom.setStartDate(Date.valueOf(keyScan.nextLine()));
        
        System.out.print("종료일? ");
        classRoom.setEndDate(Date.valueOf(keyScan.nextLine()));
        
        System.out.print("교실번호? ");
        classRoom.setClassNumber(keyScan.nextLine());
        
        // 여기서 함수 넣기!
        classRoomDao.insert(classRoom);
    }
    
    private void onClassRoomList() {
        System.out.println("[수업 목록]");
        ClassRoom[] classRooms = classRoomDao.list();
        for(ClassRoom cr : classRooms) {
            if(cr == null) continue;
            System.out.printf("%d, %s, %s ~ %s, %s\n",
                    cr.getNo(), cr.getClassName(),
                    cr.getStartDate().toString(), cr.getEndDate().toString(),
                    cr.getClassNumber());
        }
    }
    
    private void onClassRoomUpdate() {
        System.out.println("[수업 정보 변경]");
        
        System.out.print("변경할 수업 번호? ");
        int index = Integer.parseInt(keyScan.nextLine());
        
        ClassRoom classRoom = classRoomDao.get(index);
       
        if(classRoom == null) {
            System.out.println("수업번호를 찾을 수 없습니다.");
            return;
        }
        
        System.out.printf("수업명(%s)? ", classRoom.getClassName());
        classRoom.setClassName(keyScan.nextLine());
        
        System.out.printf("시작일(%s)? ", classRoom.getStartDate().toString());
        Date startDate = Date.valueOf(keyScan.nextLine());
        
        if(startDate == null) {
            classRoom.setStartDate(classRoom.getStartDate());
        } else {
            classRoom.setStartDate(startDate);
        }
        
        
        System.out.printf("종료일(%s)? ", classRoom.getEndDate().toString());
        Date endDate = Date.valueOf(keyScan.nextLine());
        
        if(endDate == null) {
            classRoom.setEndDate(classRoom.getEndDate());
        } else {
            classRoom.setEndDate(endDate);
        }
        
        System.out.print("교실번호? ");
        classRoom.setClassNumber(keyScan.nextLine());

        
        if(Console.confirm("변경하시겠습니까?")) {
            System.out.println("변경하였습니다.");
            classRoomDao.update(classRoom);
        } else {
            System.out.println("취소하였습니다.");
        }
    }
    
    private void onClassRoomDelete() {
        System.out.println("[수업 삭제]");

        System.out.print("삭제할 수업 번호? ");
        int index = Integer.parseInt(keyScan.nextLine());
        
        ClassRoom classRoom = classRoomDao.get(index);
        
        if(classRoom == null) {
            System.out.println("삭제할 수업번호와 일치하지 않습니다.");
        } else {
            if(Console.confirm("정말 삭제하시겠습니까?")) {
                System.out.println("삭제하였습니다.");
                classRoomDao.delete(classRoom);
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