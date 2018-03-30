package bitcamp.java106.pms.dao;

import bitcamp.java106.pms.domain.ClassRoom;

public class ClassRoomDao {
    private ClassRoom[] classRooms = new ClassRoom[1000];
    private int classRoomIndex = 0;
    
    // 삽입
    public void insert(ClassRoom classRoom) {
        classRoom.setNo(classRoomIndex);
        classRooms[classRoomIndex++] = classRoom;
    }
    
    // 목록
    public ClassRoom[] list() {
        ClassRoom[] arr = new ClassRoom[classRoomIndex];
        for(int i = 0; i < classRoomIndex; i++) {
            arr[i] = classRooms[i];
        }
        return classRooms;
    }
    
    // 업데이트!
    public void update(ClassRoom classRoom) {
        classRooms[classRoom.getNo()] = classRoom;
    }
    
    // 삭제
    public void delete(ClassRoom classRoom) {
        classRooms[classRoom.getNo()] = null;
    }
    
    // 색인 번호
    public ClassRoom get(int index) {
        if(classRooms[index] == null)
            return null;
        return classRooms[index];
    }
}
