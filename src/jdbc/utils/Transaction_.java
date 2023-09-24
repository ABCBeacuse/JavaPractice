package jdbc.utils;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Transaction_ {

    /**
     * 转账实例（不存在事务回滚）
     */
    @Test
    void test() {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = JDBCUtils.getConnection();
            // 转账第一步（一个人扣款）
            statement = connection.prepareStatement("update account set `balance` = `balance` - 100 where id = 1");
            statement.executeUpdate();

            // 引起异常，导致 SQL 语句执行一半
            int n = 1 / 0;
            // 转账第二部（另一个收款）
            statement = connection.prepareStatement("update account set `balance` = `balance` + 100 where id = 2");
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("转账过程出错");
            e.printStackTrace();
        } finally {
            // 释放资源
            JDBCUtils.close(null, statement, connection);
        }
    }

    /**
     * 转账实例（开启事务）
     */
    @Test
    void test2() {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = JDBCUtils.getConnection();
            // 关闭 connection 的默认提交，（同时也是开启事务）
            connection.setAutoCommit(false);
            // 转账第一步（一个人扣款）
            statement = connection.prepareStatement("update account set balance = balance - 100 where id = 1");
            statement.executeUpdate();

            // 引起异常，导致 SQL 语句执行一半
//            int n = 1 / 0;
            // 转账第二部（另一个收款）
            statement = connection.prepareStatement("update account set balance = balance + 100 where id = 2");
            statement.executeUpdate();

            // 如果没有出错，最后提交事务
            connection.commit();

        } catch (Exception e ) {
            try {
                // 回滚事务中 SQL 语句的执行结果
                connection.rollback();
                System.out.println("执行出错，回滚事务");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        } finally {
            // 释放资源
            JDBCUtils.close(null, statement, connection);
        }
    }
}
