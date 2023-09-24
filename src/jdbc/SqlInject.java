package jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * 演示使用 Statement 时造成的 SQL 注入问题
 */
public class SqlInject {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入用户名: ");
        // next() 发现有 空格 或者 单引号，会被认为输入结束
        // nextLine() 回车才算结束
        String name = scanner.nextLine();
        System.out.print("请输入密码: ");
        String pwd = scanner.nextLine();

        // 创建 Properties 对象用来读取配置文件中的数据库信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql3.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");

        // 注册数据库驱动，实际上驱动在第一次被加载的时候就已经注册完毕，这里为了明确声明一下
        Class.forName(driver);

        // 连接数据库，获取 Connection 对象
        Connection connection = DriverManager.getConnection(url, user, password);

        // 获取 Statement 对象，用来传输 SQL 语句，并返回结果。（Statement 存在 SQL 注入）
        Statement statement = connection.createStatement();

        ResultSet set = statement.executeQuery("select count(*) from admin where `name` = '" + name + "'AND `password` = '" + pwd + "'");
        if(set.next()) {
            int count = set.getInt(1);
            System.out.println("存在 " + count + " 用户");
            System.out.println(count > 0 ? "成功登录" : "登录失败");
        }

        // 释放资源
        set.close();
        statement.close();
        connection.close();
    }
}
