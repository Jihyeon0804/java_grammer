package C02ClassBasic;

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
        System.out.println(mi1.sumAcc(10));
        System.out.println(mi1.sumAcc(20));


        // B 부서의 매출 : 10, 20, ...
        MyCalculatorInstance mi2 = new MyCalculatorInstance();
        // MyCalculatorInstance.sumAcc() : static이 없으므로 sumAcc는 호출이 불가 -> 객체로 만들어서 호출해야 함
        System.out.println(mi2.sumAcc(10));
        System.out.println(mi2.sumAcc(20));
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

    public int sum(int a, int b) {
        return a + b;
    }

    public int sumAcc(int a) {
        total += a;
        return total;
    }
}

