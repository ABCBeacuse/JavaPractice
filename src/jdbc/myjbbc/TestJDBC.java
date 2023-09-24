package jdbc.myjbbc;

public class TestJDBC {
    public static void main(String[] args) {
        // 完成对 mysql 的操作
        JdbcInterface jdbcInterface = new MysqlJdbcImpl();

        // 通过接口来调用实现类 [动态绑定]
        jdbcInterface.getConnection();
        jdbcInterface.crud();
        jdbcInterface.close();

        System.out.println("====================");
        jdbcInterface = new OracleJdbcImpl();
        jdbcInterface.getConnection();
        jdbcInterface.crud();
        jdbcInterface.close();
    }
}
