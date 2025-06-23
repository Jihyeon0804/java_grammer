package C03Inheritance;

// class 에는 public, default 접근 제어자만 존재
public class C04ProtectedClass {

    // 변수, 메서드에는 4가지 접근 제어자가 존재
    // public > protected > default > private

    // public : 프로젝트 전체에서 접근 가능 (다른 패키지여도 접근 가능)
    public String st1 = "hello java1";

    // private : 클래스 내에서만 접근 가능
    private String st2 = "hello java2";

    // default : 생략 가능. 패키지 내에서만 접근 가능
    String st3 = "hello java3";

    // protected : 패키지를 벗어나더라도 상속 관계인 경우에는 접근 가능
    protected String st4 = "hello java4";

}
