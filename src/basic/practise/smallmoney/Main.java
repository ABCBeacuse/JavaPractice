package basic.practise.smallmoney;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean loop = true;
        int choice;
        Scanner scanner = new Scanner(System.in);

        Note note = new Note();
        double money;
        do {
            System.out.println("\n======================零钱通菜单======================");
            System.out.println("\t\t\t\t 1 零钱通明细 \t\t\t\t");
            System.out.println("\t\t\t\t 2 收益入账 \t\t\t\t");
            System.out.println("\t\t\t\t 3 消费 \t\t\t\t");
            System.out.println("\t\t\t\t 4 退出 \t\t\t\t");
            System.out.println("请选择(1-4)：");

            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("\n======================零钱通明细======================");
                    System.out.println(note.getDetail());
                    break;
                case 2:
                    System.out.println("请输入入账金额：");
                    money = scanner.nextDouble();
                    note.enterAccount(money);
                    break;
                case 3:
                    System.out.println("请输入消费说明：");
                    String clear = scanner.next();
                    System.out.println("请输入消费金额：");
                    money = scanner.nextDouble();
                    note.outAccount(clear, money);
                    break;
                case 4:
                    String result;
                    System.out.println("请输入 y/n 来进行操作：");
                    do {
                        result = scanner.next();
                    } while (!"y".equals(result) && !"n".equals(result));
                    if ("y".equals(result)) {
                        loop = false;
                    }
                    break;
            }
        } while (loop);
    }
}
