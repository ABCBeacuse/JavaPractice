package jdbc.utils;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class JDBCUtilsUse {

    @Test
    void testSelect() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement("select * from admin");
            // 因为上方没有占位符，所以可以直接执行，不需要使用 setXxx() 方法
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String password = resultSet.getString("password");
                System.out.println(id + "\t" + name + "\t" + password);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // 关闭资源
            JDBCUtils.close(resultSet, preparedStatement, connection);
        }
    }

    @Test
    void testDML() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement("UPDATE admin SET password = ? WHERE name = ?");
            // 给占位符赋值
            preparedStatement.setString(1, "123456");
            preparedStatement.setString(2, "rose");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }
}
