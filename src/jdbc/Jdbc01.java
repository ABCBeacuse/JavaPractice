package jdbc;

import com.mysql.cj.jdbc.Driver;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Jdbc01 {
    public static void main(String[] args) throws SQLException {
        // 注册驱动 (每个驱动程序类必须实现的接口)
        Driver driver = new Driver();

        // jdbc:mysql:// 规定好协议, 通过 jdbc 的方式连接 mysql
        // localhost 主机, 可以是 ip 地址
        // 3306 表示 mysql 监听的端口
        // testdb 连接到 mysql dbms 的 testdb 数据库
        // mysql 连接的本质就是前面学过的 socket 连接
        String url = "jdbc:mysql://localhost:3306/testdb";

        // 将用户名和密码放入 Properties 对象
        Properties properties = new Properties();
        // 规定好键名 为 user, password
        properties.setProperty("user", "root");
        properties.setProperty("password", "root");
        // 获取数据库连接
        // 尝试使数据库连接到给定的URL。 如果驱动程序意识到连接到给定的URL是错误的，驱动程序应该返回“null”。
        Connection connect = driver.connect(url, properties);

        // 创建一个 Statement对象，用于将SQL语句发送到数据库。
        Statement statement = connect.createStatement();
        // 执行给定的SQL语句，这可能是 INSERT ， UPDATE ，或 DELETE语句，返回影响的行数。或者不返回任何内容，如SQL DDL语句的SQL语句。
        int rows = statement.executeUpdate("insert into actor values (null, '成龙', '男', '1980-11-11', '1232130412')");

        System.out.println(rows > 0 ? "成功" : "失败");

        // 释放资源 Statement 对象的数据库和JDBC资源
        statement.close();
        connect.close();
    }

    @Test
    void test() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class<?> driverClass = Class.forName("com.mysql.cj.jdbc.Driver");
        // 这里的 Driver 是 java.sql.Driver 接口（规范JDBC接口）
        Driver driver = (Driver) driverClass.newInstance();
        String url = "jdbc:mysql://localhost:3306/testdb";

        // 将用户名和密码放入 Properties 对象
        Properties properties = new Properties();
        // 规定好键名 为 user, password
        properties.setProperty("user", "root");
        properties.setProperty("password", "root");
        Connection connect = driver.connect(url, properties);
    }

    @Test
    void test2() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class<?> driverClass = Class.forName("com.mysql.cj.jdbc.Driver");
        // 这里的 Driver 是 java.sql.Driver 接口（规范JDBC接口）
        Driver driver = (Driver) driverClass.newInstance();

        DriverManager.registerDriver(driver); // 注册 Driver 驱动
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "root");

        System.out.println(connection);
        // com.mysql.cj.jdbc.ConnectionImpl@2df9b86

        // 释放资源
        connection.close();
    }

    @Test
    void test3() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 每个驱动包中的 Driver 对象，都有一个静态代码，即加载完毕后自动注册

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "root");
        System.out.println(connection);
        // com.mysql.cj.jdbc.ConnectionImpl@793be5ca

        // 释放资源
        connection.close();
    }

    @Test
    void test4() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "root");
        System.out.println(connection);
        // com.mysql.cj.jdbc.ConnectionImpl@793be5ca

        // 释放资源
        connection.close();
    }

    @Test
    void test5() throws IOException, ClassNotFoundException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql3.properties"));

        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");

        // driver 类加载完毕后自动注册到 DriverManager
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
        // com.mysql.cj.jdbc.ConnectionImpl@793be5ca

        // 释放资源
        connection.close();
    }
}
