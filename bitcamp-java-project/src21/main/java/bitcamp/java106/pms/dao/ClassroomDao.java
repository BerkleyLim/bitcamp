package bitcamp.java106.pms.dao;

import java.util.LinkedList;

import bitcamp.java106.pms.domain.Classroom;

public class ClassroomDao {
    LinkedList<Classroom> collection = new LinkedList<>();
    
    // 삽입
    public void insert(Classroom classroom) {
        collection.add(classroom);
    }
    
    // 목록
    public Classroom[] list() {
        Classroom[] arr = new Classroom[collection.size()];
        return this.collection.toArray(arr);
        
        // 주의! -> 에러 발생, 주소를 받을 때는 Object 배열이다. (Classroom 배열과 일치 않음)
        // return = (Classroom[]) collection.toArray(); // 실행 오류 남
        
    }
    
    // 업데이트!
    public void update(Classroom classroom) {
        int index = this.getClassroomIndex(classroom.getNo());
        if (index < 0)
        collection.set(index, classroom);
    }
    
    // 삭제
    public void delete(Classroom classroom) {
        int index = this.getClassroomIndex(classroom.getNo());
        if (index < 0)
            return;
        collection.set(index, null);
    }
    
    
    private int getClassroomIndex(int classroomNo) {
        for (int i = 0; i < collection.size(); i++) {
            if(collection.get(i).getNo() == classroomNo) {
                return i;
            }
        }
        return -1;
    }
    
    // 색인 번호
    public Classroom get(int classroomNo) {
        int index = this.getClassroomIndex(classroomNo);
        if (index < 0)
            return null;
        return collection.get(index);
    }
    
}
