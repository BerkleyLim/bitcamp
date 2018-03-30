package bitcamp.java106.pms.dao;

import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.util.ArrayList;

public class TaskDao {
    ArrayList collection = new ArrayList();
    
    public void insert(Task task) {
        // 팀 정보가 담겨있는 객체의 주소를 배열에 보관한다.
        collection.add(task);
    }
    
    // 여기서 해당 팀 중 프로젝트 만드는 갯수
    private int count(String teamName) {
        int cnt = 0;
        for (int i = 0; i < collection.size(); i++) {
            Task task = (Task)collection.get(i);
            if (task.getTeam().getName().toLowerCase().equals(
                    teamName.toLowerCase())) {
                cnt++;
            }
        }
        return cnt;
    }
    
    // 리스트
    public Task[] list(String teamName) {
        Task[] arr = new Task[this.count(teamName)];
        for (int i = 0, x = 0; i < collection.size(); i++) {
            Task task = (Task)collection.get(i);
            if (task.getTeam().getName().toLowerCase().equals(
                    teamName.toLowerCase())) {
                arr[x++] = task;
            }
        }
        return arr;
    }
    
    public Task get(int taskNo) {
        int index = getTaskIndex(taskNo);
        if (index < 0)
            return null;
        return (Task) collection.get(index);
    }
    
    public void update(Task task) {
        int index = getTaskIndex(task.getNo());
        if(index < 0)
            return;
        collection.set(index, task);
    }
    
    public void delete(int taskNo) {
        int index = getTaskIndex(taskNo);
        if(index < 0)
            return;
        collection.remove(index);
    }
    
    private int getTaskIndex(int taskNo) {
        for (int i = 0; i < collection.size(); i++) {
            Task task = (Task)collection.get(i);
            if (task.getNo() == taskNo) {
                return i;
            }
        }
        return -1;
    }

}

// ver 18 - ArrayList 클래스 적용하여 객체(의 주소) 목록을 다룬다.
// ver 16 - 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
// ver 14 - TeamController로부터 데이터 관리 기능을 분리하여 TeamDao 생성.





