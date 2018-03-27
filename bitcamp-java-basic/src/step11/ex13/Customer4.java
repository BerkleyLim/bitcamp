package step11.ex13;

//class 문법을 이용하여 병원 고객을 추상화하였다.
public class Customer4 {
    // 외부에서 인스턴스 변수에 직접 접근하지 못하도록 막는다!
    private String name;
    private int age;
    private int weight;
    private int height;
    
    // 실무에서는 셋터에서 유효 값을 검증하는 코드를 잘 넣지 않는다.
    // 따로 인스턴스 변수의 값을 검증하는 메서드를 추가하여 처리한다.
    // 그래서 실무에서 셋터 메서드는 인스턴스 변수에 그냥 값을 넣는 경우가 많다.
    // 즉 인스턴스 변수에 직접 값을 넣는 것과 동일하게 동작한다.
    // 이런 상황 때문에 셋터, 겟터의 무용성을 주장하는 개발자들이 있다.
    // 그들은 그냥 인스턴스 변수에 접근 범위를 public으로 공개하여 사용할 것을 주장한다.
    // 그러나 대부분의 개발자들은 셋터의 무용함을 떠나,
    // 셋터를 통해 변수의 접근을 제한하는 방법을 사용한다.
    
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
