package jdbc.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.jupiter.api.Test;

import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * C3P0 数据库连接池的测试，速度慢，但是比较稳定，Spring，hibernate 默认使用
 */
public class C3P0DataSource {
    public static void main(String[] args) throws IOException, PropertyVetoException, SQLException {
        // 创建一个连接池的基本对象
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        // 创建 Properties 对象，读取配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql3.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");

        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(user);
        dataSource.setPassword(password);

        // 设置数据源的初始连接数
        dataSource.setInitialPoolSize(10);
        // 设置连接池最大可以存放的连接数
        dataSource.setMaxPoolSize(50);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            // 从连接池中获取一个连接
            Connection connection = dataSource.getConnection();
            // 连接使用完毕，将连接放回到连接池中
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("连接 5000 次使用的时间 " + (end - start));
    }

    @Test
    void test1() throws SQLException {
        // 参数为配置文件 c3p0-config.xml 文件中配置的设置空间的 name
        ComboPooledDataSource dataSource = new ComboPooledDataSource("hsp_edu");

        // 因为配置文件 c3p0-config.xml 中配置了内容，所以可以直接请求连接
        Connection connection = dataSource.getConnection();
        System.out.println("连接成功");
        connection.close();
    }
}
