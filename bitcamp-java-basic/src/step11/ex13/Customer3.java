package step11.ex13;

//class 문법을 이용하여 병원 고객을 추상화하였다.
public class Customer3 {
    // 외부에서 인스턴스 변수에 직접 접근하지 못하도록 막는다!
    private String name;
    private int age;
    private int weight;
    private int height;
    
    // 외부에서 인스턴스 변수에 접근을 못하기 때문에 값을 넣거나 조회 불가!
    // 그래서 이를 가능하게 하는 수단/방법(method)를 제공해야 한다. 
    // => 보통 메서드 명은 set으로 시작한다.
    // => 그래서 이 메서드를 "셋터(setter)"라고 부른다.
    
    // 인스턴스 변수 name의 값을 넣는 메서드
    // => 보통 메서드 명은 set으로 시작한다.
    public void setName(String name) {
        // 이 메서드에서 이름 값이 유효한지 검사한다. 
        if (name == null)
            this.name = "이름없음";
        
        if (name.length() < 2)
            this.name = "이름 없음";
        
        // 이름은 최대 5자만 넣는다.
        this.name = name.substring(0, 5);
    }
    
    public void setWeight(int weight) {
        // 이 메서드에서 이름 값이 유효한지 검사한다. 
        if (weight < 1 && weight > 30)
            this.weight = 0;
        this.weight = weight;
    }
    
    public void setHeight(int height) {
        if (height < 1 && height > 30)
            this.height = 0;
        this.height = height;
    }
    
    public void setAge(int age) {
        if (age > 0 || age < 120)
            this.age =age;
        this.age = 0;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getName() {
        return name;
    }
    
    public int getHeight() {
        return height;
    }
    
    public int getWeight() {
        return weight;
    }
    
}
