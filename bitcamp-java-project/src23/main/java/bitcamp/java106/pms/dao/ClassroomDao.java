package bitcamp.java106.pms.dao;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.domain.Classroom;

@Component
public class ClassroomDao extends AbstractDao<Classroom> {
    
    public int indexOf(Object key) {
        int classroomNo = (Integer) key;
        for (int i = 0; i < collection.size(); i++) {
            if(collection.get(i).getNo() == classroomNo) {
                return i;
            }
        }
        return -1;
    }
    
}

//ver 23 - @Component 애노테이션을 붙인다.