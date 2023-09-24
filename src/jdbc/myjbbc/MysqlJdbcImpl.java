package jdbc.myjbbc;

/**
 * mysql 数据库实现了 jdbc 接口【模拟】
 *
 * 该模块由 mysql 厂商开发, 编写操作代码, 对数据库底层进行操作
 */
public class MysqlJdbcImpl implements JdbcInterface{

    @Override
    public Object getConnection() {
        System.out.println("成功连接数据库");
        return null;
    }

    @Override
    public void crud() {
        System.out.println("crud 操作");
    }

    @Override
    public void close() {
        System.out.println("断开连接");
    }
}
