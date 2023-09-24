package jdbc.utils;

import jdbc.domain.Actor;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 德鲁伊连接池的使用
 */
public class DruidUtilsUse {
    public static void main(String[] args) {
        // 获取对象连接
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DruidUtils.getConnection();
            // 创建一个 PreparedStatement 对象，用来查询消息
            statement = connection.prepareStatement("select * from account");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Double balance = resultSet.getDouble("balance");
                System.out.println(id + " " + name + " " + balance);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // 关闭资源
            DruidUtils.close(resultSet, statement, connection);
        }
    }

    @Test
    void test() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        // 创建 ArrayList 来存储 ResultSet 中的行记录
        ArrayList<Actor> list = new ArrayList<>();
        try {
            connection = DruidUtils.getConnection();
            preparedStatement = connection.prepareStatement("select * from account");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Double balance = resultSet.getDouble("balance");
                // 向 ArrayList 数组中存储 Actor 对象
                list.add(new Actor(id, name, balance));
            }
            // 数据库中的数据已全部存储到 ArrayList 数组中
            System.out.println(list);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // 关闭资源（目前数据已经全部存储到了 ArrayList 数组中，而 ArrayList 数组与 Connection 没有任何关系，即当连接断开后也可以使用）
            JDBCUtils.close(resultSet, preparedStatement, connection);
        }
        // 因为已经存储到了数组 ArrayList 中，与数据库连接 connection 没有任何关系，所以可以返回 数组列表
        // return list;
    }
}
