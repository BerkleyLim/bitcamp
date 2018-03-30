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
    
    private int count(String teamName) {
        int cnt = 0;
        for (int i = 0; i < taskIndex; i++) {
            if (tasks[i] == null) continue;
            if (tasks[i].getTeam().getName().equals(teamName)) {
                cnt++;
            }
        }
        return cnt;
    }
    
    public Task[] list(String teamName) {
        Task[] arr = new Task[this.count(teamName)];
        for (int i = 0, x = 0; i < this.taskIndex; i++) {
            if (tasks[i] == null) continue;
            if (tasks[i].getTeam().getName().equals(teamName)) {
                arr[x++] = this.tasks[i];
            }
        }
        return arr;
    }
    
    public Task get(String teamName, int taskNo) {
        for(int i =0, x = 0; i < taskIndex; i++) {
            if (tasks[i] == null) continue;
            if (tasks[i].getTeam().getName().toLowerCase().equals(teamName) &&
                    tasks[i].getNo() == taskNo) {
                return tasks[i];
            }
        }
        return null;
    }
    
    public void update(Task task) {
        tasks[task.getNo()] = task;
    }
    
    public void delete(int taskNo) {
        tasks[taskNo] = null;
    }
    
    private int getTaskIndex(String name) {
        for (int i = 0; i < this.taskIndex; i++) {
            if (this.tasks[i] == null) continue;
            if (name.equals(this.tasks[i].getTeam().getName().toLowerCase())) {
                return i;
            }
        }
        return -1;
    }

}

//ver 16 - 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
//ver 14 - TeamController로부터 데이터 관리 기능을 분리하여 TeamDao 생성.





