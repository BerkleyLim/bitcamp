// ArrayList API에 있는 그대로 구조 구현해보기 
package bitcamp.java106.pms.util;

public class ArrayList {
    private static final int DEFAULT_CAPACITY = 5;
    
    Object[] list;
    int cursor = 0;
    
    /*
    public void m() {
        this(4); // Constructor call must be the first statement in a constructor
    }
    */
    
    public ArrayList() {
        // 자신의 다른 생성자를 호출 할 수 있다.
        // => 생성자를 호출 할 수 있는 경우
        //    1) new 명령을 사용할 때
        //    2) 생성자에서 다른 생성자를 호출할 때
        //    그 외에는 임의로 생성자를 호출할 수 없다.
        // 일반 메서드에서 생성자를 임의로 호출 할 수 없다.
        // 다른 생성자를 호출할 때는 super 클래스의 생성자를 호출 불가
        // => 둘 중 하나만 첫 문장으로 올 수 있다.
        //super(); // 컴파일 오류!
        this(DEFAULT_CAPACITY); // 생성자 ArrayList(int capacity)에서 5로 대입 가능
        
    }
    
    public ArrayList(int capacity) {
        // super(); 항상 생성자에는 수퍼 클래스의 기본 생성자를 호출하는 문장이 숨겨져 있다.
        //          물론 개발자가 수퍼 클래스의 생성자를 호출하겠다고 명시한다면
        //          당연히 자동으로 붙지 않는다.
        if (capacity < DEFAULT_CAPACITY) {
            list = new Object[DEFAULT_CAPACITY];
        } else {
            list = new Object[capacity];
        }
    }
    
    public void add(Object value) {
        // 만일에 cursor가 list길이보다 클경우 새로 추가 (배열 늘리기 위한 꼼수 방법 중 하나)
        if (cursor >= list.length) {
            increaseArray();
        }
        list[cursor++] = value;
    }
    
    public Object get(int index) {
        return list[index];
    }
    
    public void set(int index, Object value) {
        list[index] = value;
    }
    
    public void remove(int index) {
        if(index < 0 || index >= cursor) {
            //System.out.println("해당 인덱스 번호에 데이터가 없습니다.");
            return;
        }
        for(int i = index + 1; i < cursor; i++) {
            list[i-1] = list[i];
            
        }
        cursor--;
    }
    
    public void add(int index, Object value) {
        if (index < 0 || index >= cursor) {
            //System.out.println("해당 인덱스 번호에 추가할 수 없습니다.");
            return;
        }
        
        if (cursor >= list.length) {
            this.increaseArray();
        }
        
        for (int i = cursor - 1; i >= index; i--) {
            list[i+1] = list[i];
        }
        list[index] = value;
        cursor++;
    }
    
    private void increaseArray() {
        Object[] list2 = new Object[list.length + DEFAULT_CAPACITY];
        for (int i =0; i < list.length; i++) {
            list2[i] = list[i];
        }
        list = list2;
    }
    
    public int size() {
        return cursor;
    }
    
    public boolean contains(Object value) {
        for (Object obj : list) {
            if (obj == value)
                return true;
        }
        return false;
    }
}
