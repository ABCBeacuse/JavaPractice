package com.mhl.view;

import com.mhl.domain.Employee;
import com.mhl.domain.Table;
import com.mhl.service.EmployeeService;
import com.mhl.service.TableService;

import java.util.List;
import java.util.Scanner;

public class MHLView {

    private boolean loop = true;

    private String key = "";

    // service 层
    private EmployeeService employeeService = new EmployeeService();

    private TableService tableService = new TableService();

    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new MHLView().mainView();
    }

    private void listAllTable() {
        List<Table> tables = tableService.list();
        System.out.println("\n餐桌编号\t\t餐桌状态");
        for (Table table : tables) {
            System.out.println("\n" + table.getId() + "\t\t\t" + (table.getStatus() == 1 ? "已被预定" : "未被预定"));
        }
    }

    public void mainView() {
        while (loop) {
            System.out.println("==================满汉楼==================");
            System.out.println("\t\t 1 登录满汉楼");
            System.out.println("\t\t 2 退出满汉楼");
            System.out.print("请输入选择：");
            key = scanner.nextLine();
            switch (key) {
                case "1":
                    System.out.print("输入员工号：");
                    String empId = scanner.nextLine();
                    System.out.print("输入密  码：");
                    String pwd = scanner.nextLine();
                    Employee employee = employeeService.login(empId, pwd);
                    if (employee != null) {
                        // 登录成功
                        System.out.println("==================登录成功 [ " + employee.getName() + " ] ==================");
                        // 显示二级菜单，这里二级菜单是循环操作，所以做成 while
                        while (loop) {
                            System.out.println("\n==================满汉楼(二级菜单)==================");
                            System.out.println("\t\t 1 显示餐桌状态");
                            System.out.println("\t\t 2 预定餐桌");
                            System.out.println("\t\t 3 显示所有菜品");
                            System.out.println("\t\t 4 点餐服务");
                            System.out.println("\t\t 5 查看账单");
                            System.out.println("\t\t 6 结账");
                            System.out.println("\t\t 9 退出满汉楼");
                            System.out.print("请输入选择：");
                            key = scanner.nextLine();
                            switch (key) {
                                case "1":
                                    listAllTable();
                                    break;
                                case "2":
                                    System.out.println("预定餐桌");
                                    break;
                                case "3":
                                    System.out.println("显示所有菜品");
                                    break;
                                case "4":
                                    System.out.println("点餐服务");
                                    break;
                                case "5":
                                    System.out.println("查看账单");
                                    break;
                                case "6":
                                    System.out.println("结账");
                                    break;
                                case "9":
                                    loop = false;
                                    break;
                                default:
                                    System.out.println("输入有误，请重新输入。");
                            }
                        }
                    } else {
                        System.out.println("登录失败，用户名或密码不存在。");
                    }
                    break;
                case "2":
                    loop = false;
                    break;
                default:
                    System.out.println("输入有误，请重新输入。");
            }
        }
        System.out.println("你退出了满汉楼系统~");
    }
}
