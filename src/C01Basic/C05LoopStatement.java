package C01Basic;

import java.util.Arrays;

public class C05LoopStatement {
    public static void main(String[] args) {
        
        // 반복문 - while
//        int i = 0;
//        while (i < 10) {
//            System.out.println("hello world");
//            i = i + 1;
//        }

        // while 문을 사용하여 2 ~ 10까지 출력
//        int n = 2;
//        while (n < 11) {
//            System.out.println(n);
//            n++;
//        }

        // 도어락 키 예제
        // 1) 무한 반복 + 맞추면 종료되는 도어락 키 예제
//        while (true) {
//            int answer = 1234;
//            Scanner scan = new Scanner(System.in);
//            int input = scan.nextInt();
//
//            if (answer == input) {
//                System.out.println("문이 열렸습니다");
//                break;      // 가장 가까이에 있는 반복문 즉시 종료
//            } else {
//                System.out.println("비밀번호가 틀렸습니다.");
//            }
//        }

        // 2) 5회 입력 횟수 제한이 있는 도어락 키 예제
        // 종료 시 "5회 이상 초과 됐습니다." 출력
//        int cnt = 0;
//        while (true) {
//            int answer = 1234;
//            Scanner scan = new Scanner(System.in);
//            int input = scan.nextInt();
//
//            if (answer == input) {
//                System.out.println("문이 열렸습니다");
//                break;      // 가장 가까이에 있는 반복문 즉시 종료
//            } else {
//                System.out.println("비밀번호가 틀렸습니다.");
//            }
//            cnt++;
//            if (cnt == 5) {
//                System.out.println("5회 이상 초과 됐습니다.");
//                break;
//            }
//        }

        // 입력한 숫자의 구구단 단수 출력
//        while (true) {
//            System.out.println("구구단 단수를 입력해 주세요.");
//            Scanner scanner = new Scanner(System.in);
//            int num = scanner.nextInt();
//            int idx = 1;
//
//            while (idx < 10) {
//                System.out.println(num + " X " + idx + " = " + (num * idx));
//                idx++;
//            }
//        }

        // do while 문 : 무조건 1번은 실행
//        int a = 100;
//        do {
//            System.out.println(a);
//        }
//        while (a < 10);

        // for문 : 초기식, 조건식 증감식이 모두 포함돼 있는 반복문
        // for문은 사용했던 변수명을 for문이 끝난 이후에 재선언이 가능
        for (int a = 0; a < 10; a++) {
            System.out.println(a);
        }

        // 예제 1) 1 ~ 10 중에 홀수만 출력하기
        for (int j = 1; j < 11; j++) {
            if (j % 2 != 0) {
                System.out.println(j);
            }
        }

        // 예제 2) 1 ~20까지 짝수의 총합 출력
        int sum = 0;
        for (int i = 1; i < 21; i++) {
            if (i % 2 ==0) {
                sum += i;
            }
        }
        System.out.println(sum);

        // 예제 3) 두 수의 최대 공약수 찾기
        int a = 24;
        int b = 36;
        int min = a < b ? a : b;
        int great = 0;
        for (int i = 1; i <= min; i++) {
            if (a % i == 0 && b % i == 0) {
                great = i;
            }
        }
        System.out.println(great);

        // 초기값을 두 수 중 작은 수로 두기
        for (int i = min; i >= 1; i--) {
            if (a % i == 0 && b % i == 0) {
                System.out.println(i);
                break;
            }
        }
        
        // 예제 4) 소수 구하기 : 약수가 1과 자기 자신 뿐인 수
        // 사용자가 입력한 값이 소수인지 아닌지 판별해주는 프로그램
//        Scanner scan = new Scanner(System.in);
//        int input = scan.nextInt();
//        boolean check = false;
//        for (int i = 2; i * i < input; i++) {
//            if (input % i == 0) {
//                check = true;
//                break;
//            }
//        }
//        if (check) {
//            System.out.println("소수가 아닙니다.");
//        } else {    // !check (check == false)
//            System.out.println("소수입니다.");
//        }
        
        // continue : 반복문의 조건식으로 이동하는 명령어
        // 홀수만 출력
        for (int i = 1; i < 11 ; i++) {
            if (i % 2 == 0) {
                // continue는 코드의 직관성과 가독성을 위해 사용
                continue;   // 짝수이면 다시 반복문으로
            }
            System.out.println(i);
        }
        
        
        // 향상된(enhanced) for문 - for each문
        int[] arr = {1, 3, 5, 7};
        
        // 일반 for 문을 활용한 배열 접근 방식
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        
        // 향상된 for 문을 활용한 배열 접근 방식
        for (int i : arr) {
            System.out.println(i);
        }

        // 일반 for 문을 통한 배열에 저장된 값 변경
        for (int i = 0; i < arr.length; i++) {
            arr[i] += 10;
        }
        // 참조형 변수 (객체 타입)는 기본적으로 변수를 통한 출력 시에 메모리 값이 출력
        System.out.println(Arrays.toString(arr));
        
        // 향상된 for 문을 통한 배열에 저장된 값 변경 -> 원본의 값 변경 불가
        for (int i : arr) {
            i += 10;
        }
        System.out.println(Arrays.toString(arr));

        // 자바 변수의 유효 범위 : {}
        int num = 10;
        if (true) {
            num = 20;
            int num2 = 20;
        }
        // num2 = 30;          // if 문 범위 내에서 정의된 변수는 해당 중괄호 밖에서는 사용 불가.
        System.out.println(num);


        // 다중 반복문
        // 예제 1) 2 ~ 9단까지 한꺼번에 출력 + 각 단마다 "몇단입니다." 출력
        for (int i = 2; i < 10; i++) {
            System.out.println(i + "단 입니다.");
            for (int j = 1; j < 10; j++) {
                System.out.println(i + " X " + j + " = " + (i * j));
            }
            System.out.println();
        }


        // 라벨문 : 반복문에 이름을 붙이는 것
        loop1:
        for (int i = 0; i < 10; i++) {
            loop2:
            for (int j = 0; j < 10; j++) {
                if (true) {
                    break loop1;        // 원하는 for 문을 라벨링을 통해 종료시킬 수 있음
                }
            }
        }
        
        
        // 이중 반복문
        int[][] arr1 = {{1, 2, 3}, {4, 5, 11}, {7, 8, 9}, {11, 11, 12}};
        System.out.println(arr1[1][2]);     // 1번째 배열의 2번째 값 출력
        // 숫자 11이 위치한 배열의 index 값 출력(1, 2 또는 3, 1) 출력
        // 가장 먼저 찾아지는 11의 위치만 출력
        // 1) 라벨링 사용
        loop1:
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                if (arr1[i][j] == 11) {
                    System.out.println("위치는 " + i + ", " + j + "입니다.");
                    break loop1;
                }
            }
        }

        // 2) 라벨링 사용X
        boolean check=false;
        for(int i=0; i<arr1.length; i++){
            for(int j=0; j<arr1[i].length; j++){
                if(arr1[i][j]==11){
                    check = true;
                    System.out.println("위치는 " + i + ", " + j + "입니다.");
                    break ;
                }
            }
            if(check){
                break;
            }
        }


        // 100 ~ 200 까지 수 중에서 가장 작은 소수를 출력
        // 1) 라벨링 사용X
        for (int i = 100; i <= 200; i++) {
            boolean check1 = false;
            for (int j = 2; j * j < i; j++) {
                if (i % j == 0) {       // 소수가 아닌 경우
                    check1 = true;
                    break;
                }
            }

            if (!check) {
                System.out.println(i + "는 소수입니다.");
                break;
            }
        }

        // 2) 라벨링 사용
        loop:
        for (int i = 100; i < 201; i++) {
            for (int j = 2; j < Math.sqrt(i)+1; j++) {
                if (i % j == 0) {
                    continue loop;
                }
            }
            System.out.println(i);
            break;
        }
    }
}
