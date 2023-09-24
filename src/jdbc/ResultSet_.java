package jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * 演示 select 语句返回 ResultSet, 并取出结果
 */
public class ResultSet_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        // 使用 Properties 对象读取配置文件信息
        Properties properties = new Properties();

        properties.load(new FileInputStream("src\\mysql3.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");

        // 使用反射加载 Driver 类, 自动注册到 DriverManager, 因为已经自动注册了, 这里还是建议写上
        Class.forName(driver);

        // 使用 DriverManager
        Connection connection = DriverManager.getConnection(url, user, password);

        // 获取 statement 对象，用来将 SQL 语句传递给 mysql
        Statement statement = connection.createStatement();

        // 执行 select 语句查询，执行给定的SQL语句，该语句返回单个 ResultSet对象。
        ResultSet resultSet = statement.executeQuery("select id, `name`, sex, borthdate from actor");

        // 使用 while 遍历 ResultSet 对象
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String sex = resultSet.getString(3);
            Date date = resultSet.getDate(4);

            System.out.println(id + " " + name + " " + sex + " " + date);
        }

        // 关闭释放资源
        // ResultSet释放此 ResultSet对象的数据库和JDBC资源，而不是等待其自动关闭时发生。
        resultSet.close();
        statement.close();
        connection.close();
    }
}
