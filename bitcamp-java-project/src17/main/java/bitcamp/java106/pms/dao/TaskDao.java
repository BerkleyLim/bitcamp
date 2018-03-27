package bitcamp.java106.pms.dao;

import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.domain.Task;

public class TaskDao {
    private Task[] tasks = new Task[1000];
    private static int taskIndex = 0;
    private String[] status = new String[]
      {"작업대기", "작업중", "", "", "", "", "", "", "", "작업완료"};
    
    // task 추가
    public void taskAdd(Task task, String name) {
        task.setNo(taskIndex);
        tasks[taskIndex++] = task;
    }
    
    // task 보기
    public Task[] taskList() {
        Task[] arr = new Task[taskIndex];
        for(int i = 0; i < taskIndex; i++) {
            arr[i] = tasks[i];
        }
        return arr;
    }
    
    // task 인덱스 색인
    public Task get(int i) {
        if (i < 0 || i >= taskIndex)
            return null;
        return tasks[i];
    }
    
    public void update(Task task) {
        tasks[task.getNo()] = task;
    }
    
    public void delete(int num) {
        tasks[num] = null;
    }
    
    public String status(int option) {
        return status[option];
    }
    
    public String[] titleStatus() {
        String[] arr = new String[taskIndex];
        for(int i = 0; i < taskIndex; i++) {
            arr[i] = tasks[i].getTaskTitle();
        }
        return arr;
    }
}
