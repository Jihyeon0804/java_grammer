package C04Interface.BankService;

import java.util.ArrayList;
import java.util.Scanner;

public class BankController {
    public static void main(String[] args) {

        System.out.println("계좌번호를 입력해 주세요.");
        Scanner scan = new Scanner(System.in);
        String accountNumber = scan.nextLine();
        BankAccount ba = new BankAccount(accountNumber);    // 계좌 개설
        BankService bs;
        
        while (true) {
            System.out.println("입금하시려면 1번, 출금하시려면 2번");
            String serviceNumber = scan.nextLine();

            // 입금
            if (serviceNumber.equals("1")) {
                System.out.println("입금 방식을 선택해주세요.  1. 카카오페이 2. 토스페이");
                String methodNumber = scan.nextLine();
                System.out.println("입금하실 금액을 입력해 주세요.");
                long money = Long.parseLong(scan.nextLine());
                // 입금 방식 분기문
                if (methodNumber.equals("1")) {
                    bs = new BankKakaoService();
                    bs.deposit(money, ba);
                } else {
                    bs = new BankTossService();
                    bs.deposit(money, ba);
                }
                System.out.println("입금이 완료되었습니다.");
                System.out.println("입금 후 잔액은 " + ba.getBalance() + "원입니다.");

            // 출금
            } else {
                System.out.println("출금 방식을 선택해주세요.  1. 카카오페이 2. 토스페이");
                System.out.println("출금하실 금액을 입력해 주세요.");
                String methodNumber = scan.nextLine();
                long money = Long.parseLong(scan.nextLine());
                if (methodNumber.equals("1")) {
                    bs = new BankKakaoService();
                } else {
                    bs = new BankTossService();
                }
                if (bs.withdraw(money, ba)) {
                    System.out.println("출금이 정상 처리되었습니다.");
                    System.out.println("출금 후 잔액은 " + ba.getBalance() + "원입니다.");
                } else {
                    System.out.println("잔액 부족으로 인해 출금이 불가능 합니다.");
                }

            }
        }
    }
}
