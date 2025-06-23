package C04Interface.BankService;

public interface BankService {

    void deposit(long money, BankAccount ba);

    boolean withdraw(long money, BankAccount ba);
}
