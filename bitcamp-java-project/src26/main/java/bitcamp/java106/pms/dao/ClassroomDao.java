package bitcamp.java106.pms.dao;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Iterator;
import java.util.Scanner;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.domain.Classroom;

@Component
public class ClassroomDao extends AbstractDao<Classroom> {
    
    public ClassroomDao() throws Exception {
        load();
    }
    
    public void load() throws Exception {
       Scanner in = new Scanner(new FileReader("data/classroom.csv"));
      
       while(true) {
           try {
               String[] arr = in.nextLine().split(",");
               
               // 인덱스번호,수업명,수업시작일,수업종료일,수업교실
               Classroom cr = new Classroom();
               cr.setNo(Integer.valueOf(arr[0]));
               cr.setClassName(arr[1]);
               cr.setStartDate(Date.valueOf(arr[2]));
               cr.setEndDate(Date.valueOf(arr[3]));
               cr.setClassNumber(arr[4].equals(" ")? "" : arr[4]);
               insert(cr);
               
           } catch(Exception e) {
               break;
           }
       }

       in.close(); 
    }
    
    public void save() throws Exception {
        PrintWriter out = new PrintWriter(new FileWriter("data/classroom.csv"));
        
        Iterator<Classroom> classrooms = list();
        
        while (classrooms.hasNext()) {
            Classroom cr = classrooms.next();
            out.printf("%d,%s,%s,%s,%s\n", cr.getNo(), 
                    cr.getClassName(), cr.getStartDate().toString(), 
                    cr.getEndDate().toString(), cr.getClassNumber());
        }
        
        out.close();
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