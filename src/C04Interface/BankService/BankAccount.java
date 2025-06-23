package C04Interface.BankService;

public class BankAccount {

    private String accountNumber;
    private Long balance = 0L;

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    // 최종 확정 금액을 통해 update (연산X)
    // 아래의 메서드를 입/출금 모두에 사용
    public void updateBalance(long balance) {
        this.balance = balance;
    }

    public Long getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                '}';
    }
}
