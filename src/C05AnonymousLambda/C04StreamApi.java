package C05AnonymousLambda;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Stream;

public class C04StreamApi {
    public static void main(String[] args) {

        int[] arr = {20, 10, 4, 12};
        
        // 전통적인 방식의 데이터 접근 방법 : 메모리 주소 접근
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        
        // 함수형 프로그래밍 방식 : 데이터와 객체 중심이 아닌, 입력에 따른 출력만 존재
        // StreamAPI : java 에서 함수형 프로그래밍을 지원하는 라이브러리
        // forEach는 스트림의 각 요소를 하나씩 소모하면서 동작을 수행
        Arrays.stream(arr).forEach(a -> System.out.println(a));

        // 스트림의 생성 : .stream()
        List<String> myList = new ArrayList<>();
        myList.add("HTML");
        myList.add("CSS");
        myList.add("javascript");
        Stream<String> stream1 = myList.stream();
        String[] myArr = new String[3];
        myArr[0] = "HTML";
        myArr[1] = "CSS";
        myArr[2] = "javascript";
        Stream<String> stream2 = Arrays.stream(myArr);

        // 원시 자료형을 위한 stream 객체가 별도로 존재
//        int[] intArr = {10, 20, 30, 40, 50};
//        IntStream stream3 = Arrays.stream(intArr);

        // stream의 중개 연산(변환) : filter, map, sorted, distinct
        int[] intArr = {10, 10, 30, 40, 50};
        // 30보다 작은 값들의 총합
        // filter() : 특정 기준으로 대상을 filtering하여 새로운 스트림을 반환하는 중개 연산 메서드
        // sum() : 스트림의 요소들을 하나씩 소모하여 총합을 구하는 메서드
        int total = Arrays.stream(intArr).filter(a -> a <= 30).sum();
        System.out.println(total);

        // map() : 기존의 스트림을 조작하여 새로운 스트림을 반환
        int[] intArr2 = {10, 10, 30, 40, 50};
        // 각 요소에 10을 곱한 후 총합
        int total2 = Arrays.stream(intArr2).map(a -> a * 10).sum();
        // 각 요소에 10을 곱한 새로운 배열 생성
        int[] newIntArr = Arrays.stream(intArr2).map(a -> a * 10).toArray();

        // distinct() : 중복 제거
        int[] intArr3 = {10, 10, 30, 40, 50};
        int total3 = Arrays.stream(intArr3).distinct().sum();
        System.out.println(total3);

        // sorted() : 정렬
        int[] intArr4 = {40, 10, 30, 10, 50};
        int[] newArr4 = Arrays.stream(intArr4).sorted().toArray();      // 원시 자료형이기 때문에 Comparator 사용 불가
        System.out.println(Arrays.toString(newArr4));
        
        // mapToInt() : IntStream 형태로 변환해주는 map
        String[] strArr = {"HTML", "CSS", "JAVA", "PYTHON"};
        // 모든 문자열 길이의 총합
        int lengthTotal = Arrays.stream(strArr).mapToInt(a -> a.length()).sum();
        System.out.println(lengthTotal);
        
        
        // 실습 )
        int[] arr1 = {1, 2, 3, 4, 5, 6};
        // arr 에서 홀수만 담은 배열 생성 후 출력
        int[] newIntArr1 = Arrays.stream(arr1).filter(a -> a % 2 == 1).toArray();
        System.out.println(Arrays.toString(newIntArr1));

        // arr 에서 홀수만 걸러서 해당 홀수의 제곱값을 담은 배열을 생성 후 출력
        int[] newIntArr2 = Arrays.stream(newIntArr1).map(a -> a * a).toArray();
        System.out.println(Arrays.toString(newIntArr2));

        // arr 에서 홀수만 거르고, 제곱값을 구하고 해당 숫자값을 오름차순한 순서로 배열을 생성 후 출력
        int[] newIntArr3 = Arrays.stream(newIntArr2).sorted().toArray();
        System.out.println(Arrays.toString(newIntArr3));
        
        
        // 스트림의 소모
        // forEach() - 출력, sum() - 합계, reduce() - 누적 연산, max(), min(), count(), findFirst() - 스트림의 첫번째 값
        int[] intArr1 = {10, 20, 30, 40};
        // forEach()
        Arrays.stream(intArr1).forEach(a -> System.out.println(a));

        // sum()
        int total1 = Arrays.stream(intArr1).sum();
        System.out.println(total1);
        
        // max() : return 타입 Optional 객체
        // Optional 객체 : 값이 있을 수도 있고 없을 수도 있음을 명시한 객체
        int max = Arrays.stream(intArr1).max().getAsInt();
        System.out.println(max);

        // min() : return 타입 Optional 객체
        int min = Arrays.stream(intArr1).min().getAsInt();
        System.out.println(min);

        // count()
        long count = Arrays.stream(intArr1).count();
        System.out.println(count);

        // reduce() : 누적 연산 -> reduce(초기값, 연산식)
        int accSum = Arrays.stream(intArr1).reduce(0, (a, b) -> a + b);
        System.out.println(accSum);

        int accMultiply = Arrays.stream(intArr1).reduce(1, (a, b) -> a * b);
        System.out.println(accMultiply);

        String[] strArr1 = {"hello", "java", "world"};
        String str = Arrays.stream(strArr1).reduce("", (a, b) -> a + b);
        System.out.println(str);

        // findFirst() : 스트림의 첫번째 요소 반환
        // 글자의 길이가 5인 요소 중에 첫번째 요소 반환
        String firstStr = Arrays.stream(strArr1).filter(a -> a.length() >= 5).findFirst().get();
        System.out.println(firstStr);

        // 주의 사항 : 제네릭의 타입 소거
        // 자바의 런타임 시점에 <String>과 같은 제네릭의 타입 소거 발생
        // 제네릭의 타입 소거로 인해 toArray() 를 통해 바로 새로운 String[]을 만드는 것은 불가
        // 런타임 시점에서 컴파일 효율성을 위해 제네릭 타입이 소거됨, 때문에 toArray() error 발생 -> 어떤 배열로 바꿀 것인지 명시해주어야 함
        // int는 제네릭에 int가 들어갈 수 없기 때문에 IntStream 이라는 별도의 객체가 있기 때문에 문제 없음
        String[] strArr2 = {"hello", "java", "world"};
        String[] answer = Arrays.stream(strArr2).filter(a -> a.length() >= 5).toArray(a -> new String[a]);
        System.out.println(Arrays.toString(answer));
        
        
        // 메서드 참조 : 하나의 메서드만을 호출하는 경우에 매개 변수를 제거한 방식
        // 사용 방식 : 클래스명::메서드명
        Arrays.stream(strArr2).forEach(System.out::println);
        String[] answer2 = Arrays.stream(strArr2).filter(a -> a.length() >= 5).toArray(String[]::new);
        System.out.println(Arrays.toString(answer2));
        
        // Stream API 실습)
        // List에 Student 객체 4개 담기 : {"Kim", 20}, {"Choi", 32}, {"Lee", 35}, {"Park", 22}
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Kim", 20));
        studentList.add(new Student("Choi", 32));
        studentList.add(new Student("Lee", 35));
        studentList.add(new Student("Park", 22));

        // 1) 모든 객체의 평균 나이
        double averageAge = studentList.stream().mapToInt(a -> a.getAge()).average().getAsDouble();
        System.out.println(averageAge);
        
        // 2) 정렬을 통한 가장 나이 어린 사람 찾기
        Student s1 = studentList.stream().sorted((o1, o2) -> o1.getAge() - o2.getAge()).findFirst().get();
        System.out.println(s1);

        // 3) 30대인 사람들의 이름만 모아서 새로운 String[]에 담기
        String[] nameArr = studentList.stream().filter(a -> a.getAge() >= 30)
                .map(a -> a.getName()).toArray(String[]::new);
        System.out.println(Arrays.toString(nameArr));


        // Optional 객체 : 특정 객체에 값이 없을지도 모른다는 것 (null) 을 명시적으로 표현
        String str1 = null;
        if (str1 != null) {
            System.out.println("hello");
        } else {
            System.out.println("값이 없습니다.");
        }
        Optional<String> opt1 = Optional.ofNullable("hello");
        if (opt1.isPresent()) {
            System.out.println(opt1.get().compareTo("hello"));
        } else {
            System.out.println("값이 없습니다.");
        }

        // Optional 객체 생성 방법 3가지
        Optional<String> opt2 = Optional.empty();                             // 비어있는 Optional 객체 생성
        Optional<String> opt3_1 = Optional.ofNullable(null);            // 비어있는 Optional 객체 생성
        Optional<String> opt3_2 = Optional.ofNullable("hello");         // 값이 없는 Optional 객체 생성
        Optional<String> opt4 = Optional.of("hello");                   // 값이 있는 Optional 객체 생성

        // Optional 객체 처리 방법 4가지
        // 방법 1) isPresent()로 확인 후에 get()
        if (opt3_1.isPresent()) {
            System.out.println(opt3_1.get());
        } else {
//            System.out.println(opt3_1.get());         // 에러 발생
            System.out.println("값이 없습니다.");
        }
        
        // 방법 2) orElse() : 값이 있으면 있는 값 return, 없으면 지정한 값 return
        System.out.println(opt3_1.orElse("값이 없습니다."));
        System.out.println(opt3_2.orElse("값이 없습니다."));
        
        // 방법 3) orElseGet() : 값이 있으면 있는 값 return, 없으면 람다 함수 실행
        System.out.println(opt2.orElseGet(() -> new String("값이 없습니다.")));

        // ** 방법 4) orElseThrow() : 값이 있으면 있는 값 return, 없으면 지정된 예외(에러) 강제 발생 <- 가장 많이 사용 **
        // 개발에서 사용자에게 적잘한 메세지 전달 목적과 의도된 코드 중단을 목표로 강제로 예외 발생시키는 경우는 매우 많음
//        System.out.println(opt3_1.orElseThrow(() -> new RuntimeException("값이 없습니다.")));        // 의도한 에러 발생
//        System.out.println(opt3_1.get());                                                           // 의도치 않은 에러 발생

        // Optional 객체 예시 1)
        List<Student> studentList1 = new ArrayList<>();
        // 평군 구하기 1)
        OptionalDouble age = studentList1.stream().mapToInt(a -> a.getAge()).average();
//        if (age.isPresent()) {
//            age.getAsDouble();
//        } else {
//            throw new NoSuchElementException("값이 없습니다");
//        }

        // 평균 구하기 2)
//        System.out.println(studentList1.stream().mapToInt(a -> a.getAge()).average()
//                .orElseThrow(() -> new NoSuchElementException("값이 없습니다. 확인해 주세요.")));


        // Optional 객체 예시 2)
        studentList1.add(new Student("Kim", 20));
        studentList1.add(new Student("Choi", 32));
        studentList1.add(new Student("Lee", 35));
        studentList1.add(new Student("Park", 22));

        System.out.println("조회하고자 하는 student의 index 번호를 입력해 주세요.");
        Scanner scan = new Scanner(System.in);
        int indexNumber = Integer.parseInt(scan.nextLine());
//        System.out.println(studentList1.get(indexNumber));      // index 범위 초과 시 error 발생
        // index 범위가 list안에 있으면 Optional.ofNullable 또는 of, ofEmpty
        Optional<Student> optStudent;
        if (studentList1.size() <= indexNumber) {
            optStudent = Optional.empty();
//            optStudent = Optional.ofNullable(null);
        } else {
            optStudent = Optional.of(studentList1.get(indexNumber));
        }
        System.out.println(optStudent.orElseThrow(() -> new NoSuchElementException("입력하신 index는 없는 번호입니다.")));

    }
}
