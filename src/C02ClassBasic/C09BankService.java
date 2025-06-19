package C02ClassBasic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class C09BankService {
    
//        계좌개설 및 입출금 서비스 : id(auto_increment), name(String), accountNumber(String), balance(int).
//        주의사항1 : main 메서드에서 입출력 처리를 하고, deposit, withdraw, transfer 메서드는 BankAccount 클래스에 생성.
//        주의사항2 : 프로그램은 항상 실행될수 있도록 전체코드를 while(true)처리
//        서비스번호를 입력하세요. 1.개설 2.조회 3.입금 4.출금 5.송금
//        1.계좌개설 : 계좌번호와 현재 가지고 계신 돈을 입력하세요. -> 자동으로 id값 증가되어 세팅
//        2.계좌조회 : 계좌조회서비스입니다. 계좌번호를 입력해주세요. -> 잔고출력
//        3.입금 : 계좌입금서비스입니다. 계좌번호와 입금금액을 입력해주세요. -> 현재 계좌에 얼마가 있습니다. 출력.
//        4.출금 : 계좌출금서비스입니다. 계좌번호와 출금금액을 입력해주세요.(잔액검증) -> 남은 금액은 얼마입니다. 또는 출금 불가(잔액 부족) 출력.
//        5.송금 : 송금서비스입니다. 본인의 계좌번호를 입력해주세요. 보내고자 하는 상대방의 계좌번호를 입력해주세요. 송금금액을 입력해주세요.(잔액검증)
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 자료 구조 : BankAccount 객체를 담아둘 자료 구조 선언
        Map<String, BankAccount> bankAccountMap = new HashMap<>();
        int id = 0;
        // 프로그램 항상 실행
        while (true) {
            System.out.println("서비스 번호를 입력하세요.");
            System.out.println("1. 계좌 개설   2. 계좌 조회   3. 입금   4. 출금   5. 송금");
            int serviceNum = Integer.parseInt(br.readLine());
            // 계좌 개설 서비스
            if (serviceNum == 1) {
                System.out.println("계좌번호와 성함, 입금할 금액을 입력하세요.");
                System.out.print("계좌 번호 : ");
                String account = br.readLine();
                System.out.print("이름 : ");
                String name = br.readLine();
                System.out.print("금액 : ");
                long money = Integer.parseInt(br.readLine());

                BankAccount bankAccount = new BankAccount(id++, name, account, money);
                bankAccountMap.put(account, bankAccount);

                System.out.println("계좌 개설이 완료되었습니다.");
                System.out.println("현재 잔액은 " + bankAccountMap.get(account).getBalance() + "원입니다.");
                continue;
                
            // 계좌 조회 서비스
            } else if (serviceNum == 2) {
                System.out.println("계좌 조회 서비스입니다. 계좌번호를 입력해주세요.");
                System.out.print("계좌 번호 : ");
                String account = br.readLine();
                if (bankAccountMap.containsKey(account)) {
                    System.out.println("현재 잔액은 " + bankAccountMap.get(account).getBalance() + "원입니다.");
                } else {
                    System.out.println("없는 계좌번호 입니다");
                }
                continue;

            // 입금 서비스
            } else if (serviceNum == 3) {
                System.out.println("계좌 입금 서비스입니다. 계좌번호와 입금 금액을 입력해주세요.");
                System.out.print("계좌 번호 : ");
                String account = br.readLine();

                System.out.print("입금할 금액 : ");
                long money = Integer.parseInt(br.readLine());
                bankAccountMap.get(account).deposit(money);
                System.out.println("현재 잔액은 " + bankAccountMap.get(account).getBalance() + "원입니다.");
                continue;
                
            // 출금 서비스    
            } else if (serviceNum == 4) {
                System.out.println("계좌 출금 서비스입니다. 계좌번호와 출금 금액을 입력해주세요.");
                System.out.print("계좌 번호 : ");
                String account = br.readLine();

                System.out.print("출금할 금액 : ");
                long money = Integer.parseInt(br.readLine());

                boolean check = bankAccountMap.get(account).withdraw(money);
                if (check) {
                    System.out.println("출금 후 잔액은 " + bankAccountMap.get(account).getBalance() + "원입니다.");
                } else {
                    System.out.println("잔액이 부족합니다.");
                }
                continue;
                
            // 송금 서비스
            } else if (serviceNum == 5) {
                System.out.println("계좌 송금 서비스입니다. 본인 계좌번호와 송금할 계좌번호와 금액을 입력해주세요.");
                System.out.print("본인 계좌 번호 : ");
                String account = br.readLine();

                System.out.print("송금할 계좌 번호 : ");
                String target_account = br.readLine();

                System.out.print("송금할 금액 : ");
                long money = Integer.parseInt(br.readLine());

                if (bankAccountMap.containsKey(target_account)) {
                    if(bankAccountMap.get(account).transfer(bankAccountMap.get(target_account), money)) {
                        System.out.println("송금이 완료되었습니다.");
                        System.out.println("송금 후 잔액은 " + bankAccountMap.get(account).getBalance() + "원입니다.");

                    } else {
                        System.out.println("잔액이 부족합니다.");
                    }
                    continue;
                } else {
                    System.out.println("없는 계좌 번호 입니다.");
                    continue;
                }

            // 서비스 번호 잘못 입력    
            } else {
                System.out.println("잘못 입력하셨습니다.");
                continue;
            }
        }
    }
}

class BankAccount {

    private int id;
    private static int totalId;
    private String name;
    private String accountNumber;
    private long balance;

    // 계좌 개설
    public BankAccount(int id, String name, String accountNumber, long balance) {
        this.id = totalId++;
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    
    // getter 생성
    public int getId() {
        return id;
    }

    public long getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    // setter 생성 (메서드 명 set 보다는 의도를 명확히 한 update 사용하기; 나는 항상 this)
    // 입금
    public void deposit(long money) {
        this.balance += money;
    }

    // 출금
    public boolean withdraw(long money) {
        // 잔고가 있으면 차감 후 return true
        // this.getBalance() 쓰지 않아도 나의 계좌 잔액을 확인하는 것이기 때문에 this.balance 사용; 굳이 함수 쓸 필요 X
        if (this.balance >= money) {
            this.balance -= money;
            return true;
        }
        // 잔고가 없으면 return false
        return false;
    }

    // 송금
    // 매개 변수로 BankAccount 또는 String의 accountNumber 둘 다 가능
    public boolean transfer(BankAccount targetAccount, long money) {
        if (withdraw(money)) {
            targetAccount.balance += money;
            return true;
        }
        return false;
    }
}