// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.controller.classroom;

import java.io.PrintWriter;
import java.sql.Date;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.ClassroomDao;
import bitcamp.java106.pms.domain.Classroom;
import bitcamp.java106.pms.server.ServerRequest;
import bitcamp.java106.pms.server.ServerResponse;
import bitcamp.java106.pms.util.Console;

@Component("/classroom/update")
public class ClassroomUpdateController implements Controller {
    // 입력은 기본!
    private ClassroomDao classroomDao;
    
    public ClassroomUpdateController(ClassroomDao classroomDao) {
        this.classroomDao = classroomDao;
    }
    
    @Override
    public void service(ServerRequest request, ServerResponse response) {
        PrintWriter out = response.getWriter();
        int no = Integer.parseInt(request.getParameter("no"));
        Classroom classroom = classroomDao.get(no);
       
        if (classroom == null) {
            out.println("유효하지 않는 수업 번호입니다.");
            return;
        }
        
        Classroom updateClassroom = new Classroom();
        updateClassroom.setNo(classroom.getNo());
        updateClassroom.setClassName(request.getParameter("classname"));
        updateClassroom.setStartDate(
                Date.valueOf(request.getParameter("startdate")));
        updateClassroom.setEndDate(
                Date.valueOf(request.getParameter("enddate")));
        updateClassroom.setClassNumber(request.getParameter("classnumber"));

        int index = classroomDao.indexOf(no);
        classroomDao.update(index, updateClassroom);
        
        out.println("변경");
    }
}

// ver 26 - ClassroomUpdateController에서 update() 메서드를 추출하여 클래스로 정의
// ver 23 - @Component 애노테이션을 붙인다. ClassroomDao를 받도록 생성자 변경.
