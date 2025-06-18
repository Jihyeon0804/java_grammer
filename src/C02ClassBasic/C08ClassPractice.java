package C02ClassBasic;

import java.util.ArrayList;
import java.util.List;

public class C08ClassPractice {
    public static void main(String[] args) {

        // 객체 선언 및 List에 2개 정도 add
        List<Account> list = new ArrayList<>();
        Account account1 = new Account("kim11", "123456789", 100);
        Account account2 = new Account("kim22", "123456789", 200);
        list.add(account1);
        list.add(account2);
        System.out.println(list);
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
}