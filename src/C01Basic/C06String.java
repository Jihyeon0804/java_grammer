package C01Basic;

import java.util.Arrays;
import java.util.regex.Pattern;

public class C06String {
    public static void main(String[] args) {

        // 원시 자료형은 스택 메모리에 저장되므로, 비교 시 값 자체를 비교
        int n1 = 10;
        int n2 = 10;
        System.out.println(n1 == n2);     // 숫자끼리의 비교
        
        // 참조 자료형의 비교는 기본적으로 메모리 주소 값끼리의 비교
        String str1 = new String("hello");
        String str2 = new String("hello");
        System.out.println(str1 == str2);           // false => 메모리 주소 값 비교이기 때문
        System.out.println(str1.equals(str2));      // true => 값 자체를 비교
        
        // WrapperClass : 기본형 타입을 Wrapping 한 클래스
        int i1 = 10;
        Integer ig1 = 10;


////        오토 언박싱 : Wrapper클래스 -> 원시자료형으로 자동 형변환
//        int i2 = ig1;
//
////        배열(참조자료형)에는 원시타입 자료형 세팅가능
//        int[] arr = {10, 20, 30};

//        그 외(리스트,set,map) 등에는 참조자료형을 세팅해야함


//        String의 선언방법 2가지
//         객체 선언 방식
//        String s1 = new String("hello World");
//        String s2 = new String("hello World");
////          리터럴 방식 : 자바에서 추천하는 방식
//        String s3 = "hello World";
//        String s4 = "hello World";


//        length : 문자열의 길이 출력
//        String s1 = "Hello1 World2 Java3";
//        System.out.println(s1.length());
//
//        char c1 = s1.charAt(0);
//
////        소문자알파벳의 개수 구하기
//        int lowerCaseCnt = 0;
        // 향상된 for문 사용
//        for (char c : s1.toCharArray()) {
//            if (c >= 'a' && c <= 'z')
//                lowerCaseCnt++;
//        }
//        System.out.println("lowerCaseCnt = " + lowerCaseCnt);
//
         // 일반 for 문 사용
//        lowerCaseCnt = 0;
//        for (int i = 0; i < s1.length(); i++) {
//            if (s1.charAt(i) >= 'a' && s1.charAt(i) <= 'z')
//                lowerCaseCnt++;
//        }
//        System.out.println("lowerCaseCnt = " + lowerCaseCnt);
//
////        a의 개수 출력
//        String s2 = "adsfaasaaasdfsdfs";
//        int aCnt = 0;
//        for (char c : s2.toCharArray()) {
//            if (c == 'a') aCnt++;
//        }
//        System.out.println("aCnt = " + aCnt);

//        indexOf : 특정 문자열의 위치 반환. 가장 먼저 나오는 문자열의 위치 반환
//        String s1 = "hello java java";
//        System.out.println(s1.indexOf("java"));
//
////        contains : 특정 문자열이 포함되어 있는 지 여부(boolean) 출력
//        System.out.println(s1.contains("hello")); // true
//        System.out.println(s1.contains("world")); // false

//        문자열 더하기 : +=
        String s1 = "hello";
        s1 += " world";
        s1 += '1'; // String 에 char을 더하면 String 으로 됨
        System.out.println("s1 = " + s1);


        // 프로그래머스 - 나머지 구하기
        // 프로그래머스 - 특정 문자 제거하기 (문자열 더하기로 풀기)
        String my_string = "abcdef";
        String letter ="f";
        String answer = "";
        for (char c : my_string.toCharArray()) {
            if (c != letter.charAt(0)) {
                answer += c;
            }
        }
        System.out.println(answer);


        // substring(a, b) : a 이상 b "미만"의 index의 문자를 잘라 반환 (return String)
        String st1 = "hello world";
        System.out.println(st1.substring(0, 5));                // hello
        System.out.println(st1.substring(6, st1.length()));     // world

        // 프로그래머스 - 특정 문자 제거하기 (substring 으로 풀기)
        answer = "";
        for (int i = 0; i < my_string.length(); i++) {
            if (!my_string.substring(i, i+1).equals(letter)) {
                answer += my_string.substring(i, i+1);
            }
        }
        System.out.println(answer);

        // 프로그래머스 - 가운데 글자 가져오기
        String s = "abcde";      // => c
        if (s.length() % 2 == 0) {
            System.out.println(s.substring(s.length() / 2 - 1, s.length() / 2 + 1));
        } else {
            System.out.println(s.substring(s.length() / 2, s.length() / 2 + 1));
        }


        // trim , strip : 문자열 양쪽 끝의 공백 제거; strip이 안정성이 trim 보다 높음
        str1 = "      hello world     ";
        String trim1 = str1.trim();
        String strip = st1.strip();
        System.out.println(trim1);
        System.out.println(strip);
        
        
        // toUpperCase : 모든 문자열을 대문자로 변환
        // toLowerCase : 모든 문자열을 소문자로 변환
        s1 = "hello";
        String s2 = s1.toUpperCase();
        String s3 = s1.toLowerCase();
        System.out.println(s2);
        System.out.println(s3);
        
        
        // replace(a, b) : a 문자열을 b 문자열로 대체
        s1 = "hello world";
        s2 = s1.replace("world", "java");
        System.out.println(s2);

        // replaceAll(a, b) : replace와 사용법 동일. 정규 표현식을 쓸 수 있는 점이 차이점.
        s1 = "01abC123한글123";
        // 예제 1) 한글 알파벳 제거
        answer = s1.replaceAll("[가-힣]", "");
        System.out.println(answer);

        // 예제 2) 영문자 소문자 제거
        answer = s1.replaceAll("[a-z]", "");
        System.out.println(answer);

        // 예제 3) 영문자 제거
        answer = s1.replaceAll("[A-Za-z]", "");
        System.out.println(answer);

        // 예제 4) 전화번호 검증
        String number = "010-1244-1745";
        boolean check = number.matches("^\\d{3}-\\d{4}-\\d{4}$");
        System.out.println(check);

        // 예제 5) 이메일 검증
        String email = "한글1234@naver.com";
        boolean check_email = Pattern.matches("^[a-z0-9]+@[a-z]+.com$", email);
        System.out.println(check_email);

        // split : 특정 문자를 기준으로 잘라서 문자 배열로 만드는 것 (return Array)
        String ss = "a:b:c:d";
        String[] arr = ss.split(":");
        System.out.println(Arrays.toString(arr));

        String bb = "a b c  d";
        String[] arr2 = bb.split(" ");
        String[] arr3 = bb.split("\\s+");             // \s : 공백; 여러 개의 공백도 하나의 공백으로 처리
        System.out.println(Arrays.toString(arr2));          // [a, b, c, , d]
        System.out.println(Arrays.toString(arr3));          // [a, b, c, d]
        
        // null과 공백의 차이
        String ss1 = null;      // null은 String이 아님
        String ss2 = "";        // 공백은 문자열
        String ss3 = " ";
        System.out.println(ss1 == ss2);           // false
//        System.out.println(ss1.isEmpty());      // NullPointerException 발생
        System.out.println(ss2.isEmpty());        // true
        System.out.println(ss3.isEmpty());        // false
        System.out.println(ss3.isBlank());        // true

        String abc = "hello      world   java";
        for (int i = 0; i < abc.length(); i++) {
            if (abc.substring(i, i + 1).isBlank()) {
                System.out.println(i + "번째는 Blank");
            }
        }


        // 문자열 합치기 (문자열 재선언)
        String[] arr1 = {"java", "python", "javascript"};
        String answer1 = "";
        for (String st : arr1) {
            answer1 += st;
            answer1 += " ";             // \n을 사용하면 줄바꿈 추가
        }
        System.out.println(answer1);

        String answer2 = String.join(" ", arr1);
        System.out.println(answer2);
        
        
        // StringBuffer : 문자열 조립 객체
//        StringBuffer sb = new StringBuffer();
//        // append는 맨 뒤에 문자열을 더하는 메서드
//        sb.append("java");
//        sb.append("\n");
//        sb.append("python");
//        sb.append("\n");
//        sb.append("javascript");
//        String ans = sb.toString();
//        // String[] arr1 = {"java", "python", "javascript"};
//        StringBuffer sb2 = new StringBuffer();
//        for (int i = 0; i < arr1.length; i++) {
//            sb2.append(arr1[i]);
//            sb2.append("\n");
//        }
//        sb2.insert(0, "C++\n");
//        sb2.deleteCharAt(sb2.length() - 1);
//        System.out.println(sb2);

        // StringBuilder : 문자열 조립 객체 (가장 빠름)
        String str = "hello";
        // StringBuilder는 동시성 이슈 O == Thread-Safe 하지 않음, 성능이 뛰어남
        StringBuilder sb = new StringBuilder();
        // StringBuffer는 동시성 이슈 X == Thread-Safe 함, 성능이 떨어짐
        StringBuffer sb2 = new StringBuffer();


        // 문자열 뒤집기
        String st = "hello";
        for (int i = st.length() - 1; i >= 0; i--) {
            sb.append(st.charAt(i));
        }
        System.out.println(sb);

        // 문자열 비교
        String s4 = "hello";
        String s5 = "dello";
        String s6 = "hello";
        System.out.println(s4.compareTo(s5));           // 양수
        System.out.println(s5.compareTo(s4));           // 음수
        System.out.println(s4.compareTo(s6));           // 0
        
        
        // 프로그래머스 - 문자열 밀기
        String a = "apple";
        String b = "elppa";


    }
}
