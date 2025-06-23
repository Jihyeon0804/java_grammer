package C03Inheritance;

// 부모 클래스를 상속받을 때, 부모 클래스에 기본 생성자가 없으면 자식 클래스에서 상속 시 기본적으로 에러 발생
public class C02SuperKeyword extends SuperParents {

    int a;

    // 자식 클래스의 생성자
    C02SuperKeyword() {
        super(20);        // super() : 부모 클래스의 생성자를 호출하는 메서드
        this.a = 10;
    }

    public static void main(String[] args) {
        
        C02SuperKeyword c2 = new C02SuperKeyword();
        c2.display();
    }

    public void display() {
        System.out.println("자식의 변수 : " + a);            // 10 -> 변수명이 같을 경우 자식 클래스 우선
        System.out.println("부모의 변수 : " + super.a);      // 20 -> super 키워드를 통해 부모 클래스 지칭
    }
}

class SuperParents {
    int a;

    public SuperParents(int a) {
        this.a = a;
    }

//    public SuperParents() {
//        
//    }
}
