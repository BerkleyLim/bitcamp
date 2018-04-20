package bitcamp.java106.pms.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Iterator;
import java.util.Scanner;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.domain.Classroom;
import bitcamp.java106.pms.domain.Task;

@Component
public class ClassroomDao extends AbstractDao<Classroom> {
    
    public ClassroomDao() throws Exception {
        load();
    }
    
    public void load() throws Exception {
        
        try (
                ObjectInputStream in = new ObjectInputStream(
                               new BufferedInputStream(
                               new FileInputStream("data/classroom.data")));
            ) {
        
            while (true) {
                try {
                    // 작업 데이터를 읽을 대 작업 번호가 가장 큰 것으로
                    // 카운트 값을 서정한다.
                    Classroom classroom = (Classroom) in.readObject();
                    if (classroom.getNo() >= classroom.count)
                        Classroom.count = classroom.getNo() + 1;
                        // 다음에 새로 추가할 작업의 번호는 현재 읽은 작업 번호 보다
                        // 1 큰 값이 되게 한다.
                    this.insert(classroom);
                } catch (Exception e) { // 데이터를 모두 읽었거나 파일 형식에 문제가 있다면,
                    //e.printStackTrace();
                    break; // 반복문을 나간다.
                }
            }
        } 
    }
    
    public void save() {
        try (
                ObjectOutputStream out = new ObjectOutputStream(
                                new BufferedOutputStream(
                                new FileOutputStream("data/classroom.data")));
            ) {
            Iterator<Classroom> classrooms = this.list();
            
            while (classrooms.hasNext()) {
                out.writeObject(classrooms.next());
            }
        } catch (Exception e) {
            System.out.println("수업 데이터 출력 오류!");
        }
    }
    
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