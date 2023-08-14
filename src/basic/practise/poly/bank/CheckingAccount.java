package basic.practise.poly.bank;

public class CheckingAccount extends BankAccount{

    public CheckingAccount(double balance) {
        super(balance);
    }

    public void deposit(double amount) {
        super.deposit(amount - 1);
        // 1 块钱入银行账号
    }

    public void withdraw(double amount) {
        super.withdraw(amount + 1);
        // 1 块钱入银行账号
    }
}
