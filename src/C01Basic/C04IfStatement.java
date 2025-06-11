package C01Basic;

import java.util.Scanner;

public class C04IfStatement {
    public static void main(String[] args) {

        // 도어락 키 예제
//        int answer = 1234;
//        Scanner scan = new Scanner(System.in);
//        int input = scan.nextInt();
//
//        if (answer == input) {
//            System.out.println("문이 열렸습니다");
//        } else {
//            System.out.println("비밀번호가 틀렸습니다.");
//        }

        
        // 버스 카드 예제
        // 현재 가지고 있는 돈은 얼마인지 묻는다.
        // 입력 값을 받아서, 10,000원 이상이면 "택시를 타시오" 라고 출력
        // 3,000원 이상 10,000원 미만이면 "버스를 타시오 라고" 출력
        // 그렇지 않으면 "걸어가시오" 라고 출력

//        System.out.println("현재 가지고 있는 돈은 얼마인가요.");
        // if, else if 구문에서 조건 식은 택 1로서, 한 조건에 해당하면 실행 후 구문 밖으로 빠져나감
//        int money = scan.nextInt();
//        if (money >= 10000) {
//            System.out.println("택시");
//        } else if (money >= 3000) {
//            System.out.println("버스");
//        } else {
//            System.out.println("도보");
//        }


        // if 문이 독립적으로 존재할 경우에는 정확한 범위 지정을 하지 않으면 모든 if 문이 중복되어 실행될 가능성이 존재
//        if (money >= 10000) {
//            System.out.println("택시");
//        }
//        if (money >= 3000 && money < 10000) {
//            System.out.println("버스");
//        }
//        if (money < 3000) {
//            System.out.println("도보");
//        }


        // 삼항 연산자
        // 결과값 = 조건식 ? 반환값1 : 반환값2
        // 조건식이 참인 경우 반환값1이 결과값에 담기고, 거짓인 경우 반환값2가 결과값에 담김
//        int answer = 1234;
//        Scanner scan = new Scanner(System.in);
//        int input = scan.nextInt();
//        String result = (answer == input) ? "문이 열렸습니다." : "비밀번호가 틀렸습니다.";
//        System.out.println(result);


        // switch 문 : if, else if, else 등 여러 조건식이 있을 때 조건문을 가독성 있게 표현한 구문
        // 고객센터 문의 전화 예제
        // 원하신는 서비스 번호를 입력해 주세요.
        // 1. 대출    2. 예금   3. 적금   0. 상담사 연결   그외. 잘못된 입력
        System.out.println("원하신는 서비스 번호를 입력해 주세요.");
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        if (input == 1) {
            System.out.println("대출");
        } else if (input == 2) {
            System.out.println("예금");
        } else if (input == 3) {
            System.out.println("적금");
        } else if (input == 0) {
            System.out.println("상담사 연결");
        } else {
            System.out.println("잘못된 입력");
        }
        
        
        // switch 사용
        switch (input) {
            case 1:
                System.out.println("대출");
                break;
            case 2:
                System.out.println("예금");
                break;
            case 3:
                System.out.println("적금");
                break;
            case 4:
                System.out.println("상담사 연결");
                break;
            default:
                System.out.println("잘못된 입력");
                break;
        }
    }
}
