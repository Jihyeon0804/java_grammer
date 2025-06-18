package C02ClassBasic;

import java.util.*;

public class C03Class {

    public static void main(String[] args) {
        System.out.println(MyCalculator.sum(10, 20));

        // 누적합
        // 해당 메서드 내에서만 total 변수를 정해주면 호출할 때마다 초기화되기 때문에 누적합을 구할 수 없음

        /*
        // A 부서의 매출
        // 10원 매출 발생
        System.out.println(MyCalculator.sumAcc(10));
        // 20원 매출 발생
        System.out.println(MyCalculator.sumAcc(20));
        // 30원 매출 발생
        System.out.println(MyCalculator.sumAcc(30));
        // 40원 매출 발생
        System.out.println(MyCalculator.sumAcc(40));

        // B 부서의 매출
        // 10원 매출 발생
        System.out.println(MyCalculator.sumAcc(10));    // 10원이 되어야 함 (재활용 안됨)
        // 20원 매출 발생
        System.out.println(MyCalculator.sumAcc(20));
        // 30원 매출 발생
        System.out.println(MyCalculator.sumAcc(30));
        // 40원 매출 발생
        System.out.println(MyCalculator.sumAcc(40));
        */

        // 객체를 활용한 매출 계산
        // A 부서의 매출 : 10, 20, ...
        MyCalculatorInstance mi1 = new MyCalculatorInstance();
        // MyCalCulatorInstance.sumAcc() : static이 없으므로 sumAcc는 호출이 불가 -> 객체로 만들어서 호출해야 함
        mi1.sumAcc(10);
        System.out.println(mi1.total);
        mi1.sumAcc(20);
        System.out.println(mi1.total);


        // B 부서의 매출 : 10, 20, ...
        MyCalculatorInstance mi2 = new MyCalculatorInstance();
        // MyCalculatorInstance.sumAcc() : static이 없으므로 sumAcc는 호출이 불가 -> 객체로 만들어서 호출해야 함
        mi2.sumAcc(10);
        System.out.println(mi2.total);
        mi2.sumAcc(20);
        System.out.println(mi2.total);

        System.out.println(MyCalculatorInstance.total_count);
        
        // 자료 구조에서 객체 사용 예시
        // 1) 배열
        String[] arr1 = {"hello", "java", "python"};
        Arrays.sort(arr1);                              // 클래스명.메서드명() : 클래스 메서드
        System.out.println(arr1.length);                // 객체(인스턴스) 메서드
        
        // 2) 리스트
        List<String> myList = new ArrayList<>();
        myList.sort(Comparator.naturalOrder());     // 객체 메서드
        Collections.sort(myList);                   // 클래스 메서드
    }

}
class MyCalculator {

    // static이 붙어 있으면 클래스 변수, static이 붙어 있지 않으면 객체 변수
    static int total = 0;

    public static int sum(int a, int b) {
        return a + b;
    }

    public static int sumAcc(int a) {
        total += a;
        return total;
    }
}

class MyCalculatorInstance {
    int total = 0;
    
    // 클래스 변수를 모든 인스턴스(객체) 간 상태를 공유 목적으로 주로 사용
    static int total_count = 0;
    
    // 클래스를 만들면, 아래와 같은 클래스명의 이름을 가진 메서드(생성자)가 기본으로 만들어짐
    // 생성자의 주된 목적은 객체 생성 시 실행되면서 객체 변수를 초기화하기 위해 주로 사용
    public MyCalculatorInstance() {
        total_count++;
    }
    
    // 클래스 메서드는 "객체의 상태와 상관없는" 독립적인 로직 수행 시에 사용 가능
    public static int sum(int a, int b) {
        return a + b;
    }

    public void sumAcc(int total) {
        // this 는 객체 그 자신을 의미
        // 일반적으로 매개변수와 객체변수를 구분짓기 위해 사용
        // ex) 매개 변수명도 total, 객체 변수명도 total일 경우
        this.total += total;
    }
}

