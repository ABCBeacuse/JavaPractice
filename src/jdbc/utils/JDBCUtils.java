package jdbc.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * JDBC 封装工具类
 */
public class JDBCUtils {
    // 下方的所有属性只需要一份，所以定义为 static
    // 数据库连接
    private static String url;

    // 连接数据库的用户名
    private static String user;

    // 连接数据库的密码
    private static String password;

    // 连接数据库使用的驱动
    private static String driver;

    // static 代码块去初始化
    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src\\mysql3.properties"));
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            driver = properties.getProperty("driver");
            // 明确声明注册一下，这里起声明作用
            Class.forName(driver);
        } catch (IOException | ClassNotFoundException e) {
            // 将编译错误转换为运行错误
            // 调用者，可以选择捕获该异常，也可以选择默认处理该异常，比较方便
            throw new RuntimeException(e);
        }
    }

    // 连接数据库，返回 Connection
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            // 将编译错误转换为运行错误
            // 调用者，可以选择捕获该异常，也可以选择默认处理该异常，比较方便
            throw new RuntimeException(e);
        }
    }

    /**
     * 一般需要关闭的资源
     * 如果需要关闭资源，就传入对象，否则传入 null
     *
     * @param resultSet
     * @param statement  或者 PreparedStatement
     * @param connection
     */
    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
