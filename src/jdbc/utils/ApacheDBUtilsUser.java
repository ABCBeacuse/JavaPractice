package jdbc.utils;

import jdbc.domain.Actor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * ApacheDBUtils 工具的使用
 */
public class ApacheDBUtilsUser {
    /**
     * ApacheDBUtils 工具类的查询
     */
    @Test
    void Query() throws SQLException {
        // 从连接池中获取连接
        Connection connection = DruidUtils.getConnection();
        // 创建 QueryRunner 对象
        QueryRunner queryRunner = new QueryRunner();

        /**
         * query 方法就是执行 sql 语句，得到 ResultSet 封装到 ArrayList 集合中，并返回该集合
         * sql 也可以查询部分列，如果查询的是部分列，则最后封装后的实例对象中没有数据的属性的值为 null
         * new BeanListHandler<>(Actor.class)：在将 ResultSet 中的每行数据 -> Actor 对象 -> 封装到 ArrayList
         * ！！！ 底层使用反射机制来获取 Actor 类的属性，然后进行封装
         *
         * 最后有一个可变参数 Obejct... params，eg：1 就是给 sql 语句中的 ? 赋值，可以有多个值，因为是可变参数
         *
         * !!! query 方法中会创建一个 PreparedStatement 对象，一个 ResultSet 对象，并且使用完毕后会自动关闭
         */
        List<Actor> list = queryRunner.query(connection, "select * from account", new BeanListHandler<>(Actor.class));

        for (Actor actor : list) {
            System.out.println(actor);
        }

        // 释放资源
        DruidUtils.close(null, null, connection);
    }

    /**
     * 查询 返回 单行数据
     *
     * @throws SQLException
     */
    @Test
    void test2() throws SQLException {
        // 从连接池中获取连接
        Connection connection = DruidUtils.getConnection();
        // 创建 QueryRunner 对象
        QueryRunner queryRunner = new QueryRunner();
        // 查询的值，仅有一行，于是采用另一种 Handler 进行处理，最后一个参数是可变参数，2 代表给 sql 语句中的第一个 ? 占位符赋值 2
        Actor query = queryRunner.query(connection, "select * from account where id = ?", new BeanHandler<>(Actor.class), 2);
        System.out.println(query);

        // 释放资源，同样 PreparedStatement 和 ResultSet 都在 query 方法中，使用完毕后已经关闭 close()。
        DruidUtils.close(null, null, connection);
    }

    /**
     * 查询返回 单行单列
     *
     * @throws SQLException
     */
    @Test
    void test3() throws SQLException {
        Connection connection = DruidUtils.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        // new ScalarHandler()，当返回值为单行单列时使用，此时 query 返回的是 Object
        Object query = queryRunner.query(connection, "select name from account where id = ?", new ScalarHandler(), 1);
        System.out.println(query);

        // 释放资源，同样 PreparedStatement 和 ResultSet 都在 query 方法中，使用完毕后已经关闭 close()。
        DruidUtils.close(null, null, connection);
    }

    /**
     * 更新操作
     */
    @Test
    void updateOperation() throws SQLException {
        // 从连接池中获取连接
        Connection connection = DruidUtils.getConnection();
        // 创建 QueryRunner 对象
        QueryRunner queryRunner = new QueryRunner();

        // 执行 dml 操作的是 update() 方法
        // 返回的值是受影响的行数 affectRow
        int affectRow = queryRunner.update(connection, "UPDATE account SET name = ? WHERE id = ?", "张三丰", 1);
        System.out.println(affectRow > 0 ? "执行成功" : "执行没有影响到表");

        // 释放资源，同样 PreparedStatement 和 ResultSet 都在 query 方法中，使用完毕后已经关闭 close()。
        DruidUtils.close(null, null, connection);
    }

    /**
     * 插入操作
     */
    @Test
    void insertOperation() throws SQLException {
        // 从连接池中获取连接
        Connection connection = DruidUtils.getConnection();
        // 创建 QueryRunner 对象
        QueryRunner queryRunner = new QueryRunner();

        // 执行 dml 操作的是 update() 方法
        // 返回的值是受影响的行数 affectRow
        int affectRow = queryRunner.update(connection, "INSERT INTO account VALUES (null, ?, ?)", "jack", 13281);
        System.out.println(affectRow > 0 ? "执行成功" : "执行没有影响到表");

        // 释放资源，同样 PreparedStatement 和 ResultSet 都在 query 方法中，使用完毕后已经关闭 close()。
        DruidUtils.close(null, null, connection);
    }

    /**
     * 删除操作
     *
     * @throws SQLException
     */
    @Test
    void deleteOperation() throws SQLException {
        // 从连接池中获取连接
        Connection connection = DruidUtils.getConnection();
        // 创建 QueryRunner 对象
        QueryRunner queryRunner = new QueryRunner();

        // 执行 dml 操作的是 update() 方法
        // 返回的值是受影响的行数 affectRow
        int affectRow = queryRunner.update(connection, "DELETE FROM account WHERE id = ?", 1);
        System.out.println(affectRow > 0 ? "执行成功" : "执行没有影响到表");

        // 释放资源，同样 PreparedStatement 和 ResultSet 都在 query 方法中，使用完毕后已经关闭 close()。
        DruidUtils.close(null, null, connection);
    }
}
