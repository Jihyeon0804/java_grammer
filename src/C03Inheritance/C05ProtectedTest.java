package C03Inheritance;

public class C05ProtectedTest {
    public static void main(String[] args) {
        // 같은 패키지 내에 있으므로 import 필요X
        C04ProtectedClass p1 = new C04ProtectedClass();
        p1.st1 = "hello python";
//        p1.st2 = "hello python";    // 사용불가
        p1.st3 = "hello python";
        p1.st4 = "hello python";
    }
}
