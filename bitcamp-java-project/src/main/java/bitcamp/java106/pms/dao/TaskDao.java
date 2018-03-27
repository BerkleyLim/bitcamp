package bitcamp.java106.pms.dao;

import bitcamp.java106.pms.domain.Task;

public class TaskDao {
    Task[] tasks = new Task[1000];
    int taskIndex = 0;
    
    public void insert(Task task) {
        // 팀 정보가 담겨있는 객체의 주소를 배열에 보관한다.
        task.setNo(taskIndex);
        this.tasks[this.taskIndex++] = task;
    }
    
    public Task[] list() {
        Task[] arr = new Task[this.taskIndex];
        for (int i = 0; i < this.taskIndex; i++) 
            arr[i] = this.tasks[i];
        return arr;
    }
    
    public Task get(String name) {
        int i = this.getTaskIndex(name);
        if (i == -1)
            return null;
        return tasks[i];
    }
    
    public void update(Task task) {
        int i = this.getTaskIndex(task.getName());
        if (i != -1)
            tasks[i] = task;
    }
    
    public void delete(String name) {
        int i = this.getTaskIndex(name);
        if (i != -1) 
            tasks[i] = null;
    }
    
    private int getTaskIndex(String name) {
        for (int i = 0; i < this.taskIndex; i++) {
            if (this.tasks[i] == null) continue;
            if (name.equals(this.tasks[i].getName().toLowerCase())) {
                return i;
            }
        }
        return -1;
    }

}

//ver 16 - 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
//ver 14 - TeamController로부터 데이터 관리 기능을 분리하여 TeamDao 생성.





