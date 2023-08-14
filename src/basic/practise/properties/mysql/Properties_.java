package basic.practise.properties.mysql;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class Properties_ {

    @Test
    void test() throws IOException {
        BufferedReader stream = new BufferedReader(new FileReader("src\\mysql.properties"));
        String line = "";
        while ((line = stream.readLine()) != null) {
            String[] split = line.split("=");
            // 如果我们需要获取到 ip 值
            if ("ip".equals(split[0])) {
                System.out.println(split[0] + "的值是：" + split[1]);
            }

        }
        stream.close();
    }

    @Test
    void test2() throws IOException {
        // 创建 Properties 对象
        Properties properties = new Properties();
        // 读取配置文件（将文件数据 -> 内存）
        properties.load(new FileReader("src\\mysql2.properties"));
        // 遍历
        properties.list(System.out);

        // 根据键来获得键值
        String ip = properties.getProperty("ip");
        String pwd = properties.getProperty("pwd");
        System.out.println(ip + "\t" + pwd);
    }

    /**
     * user=root
     * pwd=12345
     * ip=192.168.1.13
     * 192.168.1.13	12345
     */

    @Test
    void test3() throws IOException {
        // 创建 Properties 对象
        Properties properties = new Properties();
        // 读取 mysql.properties 的配置信息
        properties.load(new FileReader("src\\mysql.properties"));

        // 添加新的 key-val
        properties.setProperty("charset", "utf-8");
        properties.setProperty("port", "3306");
        properties.setProperty("user", "123汤姆"); // 存入的是中文的 unicode 码值

        // 存储到新文件
        properties.store(new FileWriter("src\\mysql2.properties"), null);
    }
}
