package basic.practise.poly.bank;

public class BankAccount {

    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    /**
     * 存款
     * @param amount
     */
    public void deposit(double amount) {
        balance += amount;
    }

    /**
     * 取款
     * @param amount
     */
    public void withdraw(double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
