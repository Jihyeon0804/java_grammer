package C03Inheritance;

//  final 키워드가 붙은 class 는 상속 불가
//  final 키워드가 붙은 메서드는 extends 불가
//  public class C06AbstractMain extends FinalParents
public class C06AbstractMain{
    public static void main(String[] args) {

//        AbstractDog d1 = new AbstractDog();
//        d1.makeSound1();
//        d1.makeSound2();
        
        
        // 추상 클래스는 구현체가 없는 메서드가 있으므로, 기본적으로 객체 생성 불가능
//        AbstractAnimal a1 = new AbstractAnimal();

        // 객체의 실체가 AbstractDog 클래스를 통해 만들어지므로 여기서는 d2의 makeSound2() 사용 가능
        AbstractAnimal d2 = new AbstractDog();
        d2.makeSound1();
        d2.makeSound2();
        
        // 모든 메서드가 abstract 인 클래스를 인터페이스라고 함 (선언만 존재)
        // 인터페이스는 구현체가 없으므로 기본적으로 별도의 객체 생성 불가
//        List<Integer> list = new List<>();        // 불가능

    }
}

// 추상 메서드가 하나라도 있으면 반드시 클래스에도 abstract 키워드를 붙이고 추상 클래스가 됨
abstract class AbstractAnimal {
    void makeSound1() {
        System.out.println("동물은 소리를 냅니다.");
    }
    
    // 메서드를 선언만 하고 구현이 없는 메서드 선언 시 abstract 키워드 사용
    // abstract 는 구현체가 없어야 함
    abstract void makeSound2();
}

// AbstractDog 클래스의 메서드 개수는 2개
// 상속 받은 메서드 makeSound1(), 재정의 하는 메서드 makeSound2()
class AbstractDog extends AbstractAnimal {
    
    @Override
    void makeSound2() {
        System.out.println("멍멍");
    }
}

final class FinalParents {

}
