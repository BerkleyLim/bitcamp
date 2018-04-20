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

@Component("/classroom/add")
public class ClassroomAddController implements Controller {
    // 입력은 기본!
    private ClassroomDao classroomDao;
    
    public ClassroomAddController(ClassroomDao classroomDao) {
        this.classroomDao = classroomDao;
    }
    
    public void service(ServerRequest request, ServerResponse response) {
        Classroom classroom = new Classroom();
        
        classroom.setClassName(request.getParameter("name"));
        classroom.setStartDate(Date.valueOf(request.getParameter("startdate")));
        classroom.setEndDate(Date.valueOf(request.getParameter("enddate")));
        classroom.setClassNumber(request.getParameter("classnumber"));
        classroomDao.insert(classroom);
        
        // 여기서 함수 넣기!
        PrintWriter out = response.getWriter();
        out.println("등록 성공!");
    }
    
}

// ver 26 - ClassroomAddController에서 add() 메서드를 추출하여 클래스로 정의
// ver 23 - @Component 애노테이션을 붙인다. ClassroomDao를 받도록 생성자 변경.
