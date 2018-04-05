// non-static 중첩 클래스 응용
package step17.ex03;

import java.util.Iterator;

public class ArrayList {
    
    public class MyIterator  {
        int index;
         public boolean hasNext() {
             if (this.index < ArrayList.this.cursor)
                 return true;
             return false;
         }
         public Object next() {
             return ArrayList.this.list[this.index++];
         }
     }

    protected static final int DEFAULT_CAPACITY = 5;
    
    Object[] list;
    int cursor = 0;
    
    /*
    public void m() {
        this(4); // Constructor call must be the first statement in a constructor
    }
    */
    
    public ArrayList() {
        this(DEFAULT_CAPACITY); // 생성자 ArrayList(int capacity)에서 5로 대입 가능
        
    }
    
    public ArrayList(int capacity) {
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
        if (index < 0 || index > cursor) {
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
            if (obj.equals(value)) // 같은 객체가 들어 있는지 검사하는 것이 아니다.
                return true;       // 같은 내용을 가진 객체가 들어 있는지 검사하는 것이다.
        }
        return false;
    }
    
    public int indexOf(Object value) {
        for (int i = 0; i < list.length; i++) {
            if(list[i].equals(value)) // 같은 객체가 들어 있는지 검사하는 것이 아니다.
                return i;             // 같은 내용을 가진 객체가 들어 있는지 검사하는 것이다.
        }
        return -1;
    }
    
    public MyIterator iterator() {
        // MyIterator를 만들 때 현재 ArrayList 객체 주소를 넘겨준다.
        // 즉  MyIterator는 자신이 만들어지는 그 순간의 바깥 (클래스의  )객체 주소를 알고 있다 
        // MyIterator는 이 바깥 객체를 가지고 값을 꺼낼 것이다.
        return new MyIterator();
    }
}
