package jdbc.myjbbc;

/**
 * 模拟 Java 厂商提出的数据库连接规范
 *
 * 接口方法默认 public abstract
 */
public interface JdbcInterface {
    /**
     * 得到数据库的连接对象
     *
     * @return
     */
    Object getConnection();

    /**
     * crud 操作
     */
    void crud();

    /**
     * 关闭数据库连接
     */
    void close();
}
