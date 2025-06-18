package C02ClassBasic;

public class C01Method {
    public static void main(String[] args) {
        // for문을 이용해 1~10까지 total값 구해서 출력
        int total = 0;
        for (int i = 1; i <= 10; i++) {
            total += i;
        }
        System.out.println(total);

        // for문을 이용해 10~20까지 total값 구해서 출력
        int total2 = 0;
        for (int i = 10; i <= 20; i++) {
            total2 += i;
        }
        System.out.println(total2);

//        위 코드의 중복이 지속적으로 발생하므로, 반복을 피하기 위해 위 코드의 기능을 모듈화 하여 별도로 분리 -> 메서드
//        클래스 메서드 기본호출 방식 : 클래스명.메서드명()
        System.out.println(C01Method.sumAcc(1,10));
        System.out.println(C01Method.sumAcc(10,20));
        System.out.println(C01Method.sumAcc(1,50));
//        같은 클래스내에서 정의된 클래스 메서드의 호출은 클래스명 생략가능
        System.out.println(sumAcc(1,100));

    }

    //    접근제어자(public), 클래스메서드여부(static O)/객체메서드(static X), 반환타입(int, String, 배열 등등), 매개변수(input 값)
    public static int sumAcc (int start, int end) {
        int total = 0;
        for (int i = start; i <= end; i++) {
            total += i;
        }
        return total;
    }
}