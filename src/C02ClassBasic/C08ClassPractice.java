package C02ClassBasic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C08ClassPractice {
    public static void main(String[] args) {

        // 객체 선언 및 List에 2개 정도 add
        List<Account> list = new ArrayList<>();
        Account account1 = new Account("kim11", "123456789", 100);
        Account account2 = new Account("kim22", "987654321", 200);
        list.add(account1);
        list.add(account2);
        System.out.println(list);

        // 계좌 번호 목록 출력
        for (Account a : list) {
            System.out.println(a.getAccountNumber());
        }

        //  사용자1이 사용자2에게 송금
        for (Account a : list) {
            if (account2.getAccountNumber().equals("987654321")) {

            }
        }

        // 계좌 상세 조회 : 계좌번호와 잔고 조회
        for (Account a : list) {
            System.out.println("계좌번호 : " + a.getAccountNumber() + "잔고 : " + a.getBalance());
        }


        // Map을 자료 구조로 사용
        Map<String, Account> accountMap = new HashMap<>();
        // 계좌 개설
        accountMap.put("12345", new Account("hong1", "12345", 100000));
        accountMap.put("54321", new Account("hong2", "54321", 100000));

        Account a = accountMap.get("12345");
        Account b = accountMap.get("54321");
        a.setBalance(a.getBalance() - 50000);
        b.setBalance(a.getBalance() + 50000);

        // 계좌 조회
        for (String ac : accountMap.keySet()) {
            System.out.println(accountMap.get(ac).getAccountNumber());
        }
    }
}

// Account 클래스 : 계좌주명(name - String), 계좌번호(accountNumber - String), 잔고(balance - long)
class Account {
    private String name;
    private String accountNumber;
    private long balance;

    public Account(String name, String accountNumber, long balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public long getBalance() {
        return balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }
}