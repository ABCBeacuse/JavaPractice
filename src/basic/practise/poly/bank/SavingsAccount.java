package basic.practise.poly.bank;

public class SavingsAccount extends BankAccount {

    // 每月 3 次存取款免手续费
    private int freeTimes = 3;

    /**
     * 利率
     */
    private double rate = 0.01;

    public SavingsAccount(double balance) {
        super(balance);
    }

    public void withdraw(double amount) {
        if (freeTimes-- > 0) {
            super.withdraw(amount);
            return;
        }
        super.withdraw(amount + 1);
    }

    public void deposit(double amount) {
        if (freeTimes-- != 0) {
            super.deposit(amount);
            return;
        }
        super.deposit(amount - 1);
    }

    /**
     * 每个月产生利息，并重置交易次数
     */
    public void earnMonthlyInterest() {
        // 根据利率计算利息，然后存入。
        super.deposit(getBalance() * rate);
        freeTimes = 3;
    }

    public int getFreeTimes() {
        return freeTimes;
    }

    public void setFreeTimes(int freeTimes) {
        this.freeTimes = freeTimes;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
