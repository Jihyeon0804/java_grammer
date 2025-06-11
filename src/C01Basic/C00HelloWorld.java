package C01Basic;

// 클래스의 명명 규칙
// 1) 반드시 public class 명과 파일명이 일치해야한다.
// 2) 일반적으로 대문자 알파벳으로 시작한다.
public class C00HelloWorld {

//    메서드, 변수명은 일반적으로 소문자 알파벳으로 시작한다.
//    어디에서든 접근 가능(public)하고, 리턴 값이 없는 메서드(void)
//    메인 메서드는 프로그램 실행 시 가장 먼저 실행되는 메서드
    public static void main(String[] args) {
//        sout 단축어를 통해 실행
//        java의 모든 명령문은 세미콜론을 통해 끝맺음
        System.out.println("hello world");

        /*
        여러줄의
        주석 처리시에 이와 같은 방법으로 주석 처리 가능
        */
    }
}
