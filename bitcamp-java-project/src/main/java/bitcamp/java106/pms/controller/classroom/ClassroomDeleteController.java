// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.controller.classroom;

import java.io.PrintWriter;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.ClassroomDao;
import bitcamp.java106.pms.domain.Classroom;
import bitcamp.java106.pms.server.ServerRequest;
import bitcamp.java106.pms.server.ServerResponse;
import bitcamp.java106.pms.util.Console;

@Component("/classroom/delete")
public class ClassroomDeleteController implements Controller {
    // 입력은 기본!
    private ClassroomDao classroomDao;
    
    public ClassroomDeleteController(ClassroomDao classroomDao) {
        this.classroomDao = classroomDao;
    }
    
    @Override
    public void service(ServerRequest request, ServerResponse response) {
        PrintWriter out = response.getWriter();
        int no = Integer.parseInt(request.getParameter("no"));

        Classroom classroom = classroomDao.get(no);
        
        if(classroom == null) {
            out.println("삭제할 수업번호와 일치하지 않습니다.");
        } else {
            classroomDao.delete(no);
            out.println("삭제하였습니다.");
        }
    }
}

// ver 26 - ClassroomDeleteController에서 delete() 메서드를 추출하여 클래스로 정의
// ver 23 - @Component 애노테이션을 붙인다. ClassroomDao를 받도록 생성자 변경.
