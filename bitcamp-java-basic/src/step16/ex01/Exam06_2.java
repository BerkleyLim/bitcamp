// 디렉토리에 들어 있는 파일이나 하이 디렉토리 정보 알아내기
package step16.ex01;

import java.io.File;
import java.io.FilenameFilter;

import step16.ex01.Exam06_1.JavaFilter;

public class Exam06_2 {
    static class JavaFilter implements FilenameFilter {
        public boolean accept(File dir, String name) {
            if (name.endsWith(".java"))
                return true;  // 조회 결과에 포함시켜라!
            return false;  // 조회 결과에서 제외하라!
        }
    }
    
    public static void main(String[] args) throws Exception {
        File dir = new File(".");
        
        JavaFilter javaFilter = new JavaFilter();
        // => 파일이나 디렉토리 정보를 File 객체로 받기
        File[] files = dir.listFiles(javaFilter);
        
        for(File file : files) {
            
            System.out.printf("%s %12d %30s\n",
                    file.isDirectory() ? "d" : "-",
                    file.length(),
                    file.getName());
        }
    }
}
