package jdbc.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * Druid 德鲁伊连接池测试
 */
public class DruidDataSource {
    public static void main(String[] args) throws Exception {
        // 创建一个 Properties 对象，用来读取配置文件信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\druid.properties"));

        // 使用 数据库连接池工厂 创建一个 Druid 数据库连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        Connection connection = dataSource.getConnection();
        System.out.println("连接成功");
        connection.close();
    }
}
