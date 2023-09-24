package jdbc.myjbbc;

/**
 * Oracle数据库实现了 jdbc 接口【模拟】
 *
 * 该模块由 Oracle 厂商开发, 编写操作代码, 对数据库底层进行操作
 */
public class OracleJdbcImpl implements JdbcInterface{
    @Override
    public Object getConnection() {
        System.out.println("获得到 oracle 数据库的连接");
        return null;
    }

    @Override
    public void crud() {
        System.out.println("oracle 增删改查");
    }

    @Override
    public void close() {
        System.out.println("关闭 oracle 数据库的连接");
    }
}
