package basic.qq.client.view;

import basic.qq.client.service.MessageClientService;
import basic.qq.client.service.UserClientService;

import java.util.Scanner;

/**
 * QQ 客户端界面
 */
public class QQView {
    /**
     * 控制主菜单是否循环
     */
    private boolean loop = true;

    /**
     * 控制二级菜单是否循环
     */
    private boolean secondLoop = true;

    /**
     * 用户键盘输入
     */
    private String key;

    /**
     * 客户端 service 汇总，暂时用户 登录 / 注册用户
     */
    private UserClientService userClientService = new UserClientService();

    /**
     * 客户端 消息服务 汇总
     */
    private MessageClientService messageClientService = new MessageClientService();

    public static void main(String[] args) {
        new QQView().mainMenu();
    }

    /**
     * 客户端主菜单
     */
    private void mainMenu() {
        Scanner scanner = new Scanner(System.in);
        while (loop) {
            System.out.println("=============欢迎登录网络通信系统=============");
            System.out.println("\t\t 1 登录系统");
            System.out.println("\t\t 9 退出系统");
            System.out.print("请输入你的选择: ");

            key = scanner.next();
            switch (key) {
                case "1":
                    System.out.print("请输入用户号: ");
                    String userId = scanner.next();
                    System.out.print("请输入密  码: ");
                    String pwd = scanner.next();
                    if (userClientService.checkUser(userId, pwd)) {
                        System.out.println("\n=============网络通信系统二级菜单（用户 " + userId + "）=============");
                        System.out.println("\t\t 1 显示在线用户列表");
                        System.out.println("\t\t 2 群发消息");
                        System.out.println("\t\t 3 私聊消息");
                        System.out.println("\t\t 4 发送文件");
                        System.out.println("\t\t 9 退出当前账号");
                        // 登录成功
                        while (secondLoop) {
                            System.out.print("请输入你的选择: ");
                            key = scanner.next();
                            switch (key) {
                                case "1":
                                    // 向服务端发送请求 在线用户信息列表 的 Message
                                    userClientService.requestOnlineFriends();
                                    break;
                                case "2":
                                    System.out.print("请输入需要群发的消息：");
                                    String s = scanner.next();
                                    messageClientService.sendMessageToAll(userId, s);
                                    break;
                                case "3":
                                    System.out.print("请输入接收人的账号：");
                                    String getter = scanner.next();
                                    System.out.print("请输入需要发送的信息：");
                                    String content = scanner.next();
                                    messageClientService.directMessage(userId, getter, content);
                                    break;
                                case "4":
                                    System.out.print("请输入接收人：");
                                    getter = scanner.next();
                                    System.out.print("请输入需要转发的文件路径：");
                                    String path = scanner.next();
                                    System.out.print("请输入需要存储到的目标路径：");
                                    String dest = scanner.next();
                                    messageClientService.transFileMessage(path, userId, getter, dest);
                                    break;
                                case "9":
                                    userClientService.logout();
                                    secondLoop = false;
                                    break;
                            }
                        }
                    } else {
                        System.out.println("登录失败");
                    }
                    break;
                case "9":
                    System.out.println("退出系统");
                    loop = false;
                    break;
            }
        }
    }
}
