package C05AnonymousLambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    }
}
