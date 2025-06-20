package C02ClassBasic;

import java.util.Arrays;

public class C12RecursivePractice {
    public static void main(String[] args) {

        // for 문으로 1 ~ 10까지 누적 합계
        int sum = 0;
        for (int i = 1; i < 11; i++) {
            sum += i;
        }
        System.out.println(sum);

        // 재귀 함수로 1 ~ 10 까지 누적 합계
        System.out.println(sumAcc(1, 10));
        
        // 재귀 함수로 factorial 값 구하기 : 1 ~ n 까지를 모두 곱한 값
        System.out.println(factorial(5));       // 120

        // 재귀 함수로 피보나치 구하기
        // 피보나치 수열 : f(n- 1) + f(n - 2) = f(n)
        // 1 1 2 3 5 8 13 21 34 55 89...
        // 피보나치 수열의 10번째 값은?

        // 방법 1) 재귀 함수
        System.out.println(fibonacci(10));      // 55

        // 방법 2) for 문만으로 구하기
        int n1 = 1;
        int n2 = 1;
        int n3 = 0;
        for (int i = 2; i < 10; i++) {
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
        }
        System.out.println(n3);

        // 방법 3) ** DP 알고리즘 ** (기억하기(메모이제이션) 알고리즘)을 활용한 풀이법
        // 이전에 계산한 값들을 메모리에 저장해 두는 것
        // 재귀 함수보다는 DP 사용하기 -> 재귀는 연산이 중복되기 때문
        int[] arr = new int[10];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < 10; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(arr[10 - 1]);                // fibonacci(10)

    }
    
    // 누적 합계 메서드
    public static int sumAcc(int n, int target) {
        if (n > target) {
            return 0;
        }

        return n + sumAcc(n + 1, target);
    }

    // 팩토리얼 메서드
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    // 피보나치 메서드
    public static int fibonacci(int n) {
        if (n <= 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
