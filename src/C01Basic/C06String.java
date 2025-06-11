package C01Basic;

public class C06String {
    public static void main(String[] args) {

        // 원시 자료형은 스택 메모리에 저장되므로, 비교 시 값 자체를 비교
        int a = 10;
        int b = 10;
        System.out.println(a == b);     // 숫자끼리의 비교
        
        // 참조 자료형의 비교는 기본적으로 메모리 주소 값끼리의 비교
        String str1 = new String("hello");
        String str2 = new String("hello");
        System.out.println(str1 == str2);           // false => 메모리 주소 값 비교이기 때문
        System.out.println(str1.equals(str2));      // true => 값 자체를 비교
        
        // WrapperClass : 기본형 타입을 Wrapping 한 클래스
        int i1 = 10;
        Integer ig1 = 10;
        
    }
}
