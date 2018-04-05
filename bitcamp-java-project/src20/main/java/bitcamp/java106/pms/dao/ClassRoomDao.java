package bitcamp.java106.pms.dao;

import java.util.LinkedList;

import bitcamp.java106.pms.domain.ClassRoom;

public class ClassRoomDao {
    LinkedList<ClassRoom> collection = new LinkedList<>();
    
    // 삽입
    public void insert(ClassRoom classRoom) {
        collection.add(classRoom);
    }
    
    // 목록
    public ClassRoom[] list() {
        ClassRoom[] arr = new ClassRoom[collection.size()];
        return this.collection.toArray(arr);
        
        // 주의! -> 에러 발생, 주소를 받을 때는 Object 배열이다. (ClassRoom 배열과 일치 않음)
        // return = (ClassRoom[]) collection.toArray(); // 실행 오류 남
        
    }
    
    // 업데이트!
    public void update(ClassRoom classRoom) {
        int index = this.getClassRoomIndex(classRoom.getNo());
        if (index < 0)
        collection.set(index, classRoom);
    }
    
    // 삭제
    public void delete(ClassRoom classRoom) {
        int index = this.getClassRoomIndex(classRoom.getNo());
        if (index < 0)
            return;
        collection.set(index, null);
    }
    
    
    private int getClassRoomIndex(int classRoomNo) {
        for (int i = 0; i < collection.size(); i++) {
            if(collection.get(i).getNo() == classRoomNo) {
                return i;
            }
        }
        return -1;
    }
    
    // 색인 번호
    public ClassRoom get(int classRoomNo) {
        int index = this.getClassRoomIndex(classRoomNo);
        if (index < 0)
            return null;
        return collection.get(index);
    }
    
}
