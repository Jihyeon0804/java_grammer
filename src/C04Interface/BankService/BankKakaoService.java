package C04Interface.BankService;

public class BankKakaoService implements BankService {
    @Override
    public void deposit(long money, BankAccount ba) {
        // 현재 얼마있는지 조회하여
        // 그 금액과 money를 합산하여 updateBalance
        ba.updateBalance(ba.getBalance() + money);
    }

    @Override
    public boolean withdraw(long money, BankAccount ba) {
        // 현재 얼마있는지 조회 && 출금 금액과
        // 그 금액과 money를 차감하여 updateBalance
        // 출금 가능
        if (money <= ba.getBalance()) {
            ba.updateBalance(ba.getBalance() - money);
            return true;
        }
        // 출금 불가
        return false;
    }
}
