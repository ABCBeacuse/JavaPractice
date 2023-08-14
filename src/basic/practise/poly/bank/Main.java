package basic.practise.poly.bank;

public class Main {
    public static void main(String[] args) {
        SavingsAccount account = new SavingsAccount(1000);
        account.deposit(100);
        account.deposit(100);
        account.deposit(100);
        System.out.println(account.getBalance());

        account.deposit(100);
        System.out.println(account.getBalance());

        // 月初，定时器自动调用一下 添加利息 和 重置存取款次数的 方法
        account.earnMonthlyInterest();
        System.out.println(account.getBalance());
        account.withdraw(100);
        account.withdraw(100);
        account.withdraw(100);
        System.out.println(account.getBalance());
        account.deposit(100);
        System.out.println(account.getBalance());
    }
}
