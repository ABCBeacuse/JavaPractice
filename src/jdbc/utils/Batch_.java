package jdbc.utils;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 批量添加数据
 */
public class Batch_ {

    @Test
    void test() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement("insert into admin2 values (null, ?, ?)");

            long start = System.currentTimeMillis();
            // 不批量添加 5000 条数据
            for (int i = 0; i < 5000; i++) {
                preparedStatement.setString(1, "jack" + i);
                preparedStatement.setString(2, "666");
                // 立即执行，没有使用批量 Batch
                preparedStatement.executeUpdate();
            }
            long end = System.currentTimeMillis();
            System.out.println("没有使用批处理，所耗时为：" + (end - start));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // 释放资源
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }
    // 没有使用批处理，所耗时为：4501

    @Test
    void test2() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement("insert into admin2 values (null, ?, ?)");

            long start = System.currentTimeMillis();
            // 批量添加 5000 条数据
            for (int i = 0; i < 5000; i++) {
                preparedStatement.setString(1, "jack" + i);
                preparedStatement.setString(2, "666");
                // 使用 addBatch 批量添加，每次的 preparedStatement 表示的 sql 语句都不一样
                preparedStatement.addBatch();

                // 每 1000 条批量执行一次，并清空 Batch
                if ((i + 1) % 1000 == 0) {
                    preparedStatement.executeBatch();
                    // 清空
                    preparedStatement.clearBatch();
                }
            }
            long end = System.currentTimeMillis();
            System.out.println("使用批处理，所耗时为：" + (end - start));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // 释放资源
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }
    // 使用批处理，所耗时为：71
}
