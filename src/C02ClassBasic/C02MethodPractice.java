package C02ClassBasic;

import java.util.Scanner;

public class C02MethodPractice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        if (isPrime(input)) {
            System.out.println("OOOOO 입력한 숫자는 소수입니다 OOOOO");
        } else {
            System.out.println("XXXXX 입력한 숫자는 소수가 아닙니다 XXXXX");
        }
    }

    //  소수 판별기
    public static boolean isPrime(int input) {
        if (input < 2) return false;
        for (int i = 2; i <= Math.sqrt(input); i++) {
//            메서드에서 return을 만나면 메서드가 강제 종료
            if (input % i == 0) return false;
        }
        return true;
    }
}