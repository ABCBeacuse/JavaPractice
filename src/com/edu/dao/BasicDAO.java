package com.edu.dao;

import com.edu.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 开发 BasicDAO，是其他 DAO 的父类
 */
public class BasicDAO<T> {
    private QueryRunner queryRunner = new QueryRunner();

    // 开发通用的 dml 操作，针对任意的表
    public int update(String sql, Object... params) {
        Connection connection = null;

        try {
            connection = DruidUtils.getConnection();
            return queryRunner.update(connection, sql, params);
        } catch (SQLException e) {
            // 将编译异常转换为运行异常，抛出
            throw new RuntimeException(e);
        } finally {
            DruidUtils.close(null, null, connection);
        }
    }

    /**
     * 返回的结果是多行，针对任意表
     *
     * @param sql    sql 语句，可以有 ? 占位符
     * @param clazz  传入一个类的 Class 对象，比如 Account.class
     * @param params 传入 ? 的具体的值，可以是多个
     * @return 根据传入的 Account.class 返回对应的 ArrayList 集合
     */
    public List<T> queryMulti(String sql, Class<T> clazz, Object... params) {
        Connection connection = null;

        try {
            connection = DruidUtils.getConnection();
            return queryRunner.query(connection, sql, new BeanListHandler<>(clazz), params);
        } catch (SQLException e) {
            // 将编译异常转换为运行异常，抛出
            throw new RuntimeException(e);
        } finally {
            DruidUtils.close(null, null, connection);
        }
    }

    /**
     * 返回的结果是单行，针对任意表
     *
     * @param sql    sql 语句，可以有 ? 占位符
     * @param clazz  传入一个类的 Class 对象，比如 Account.class
     * @param params 传入 ? 的具体的值，可以是多个
     * @return 根据传入的 Account.class 返回对应的 ArrayList 集合
     */
    public T querySingleRow(String sql, Class<T> clazz, Object... params) {
        Connection connection = null;

        try {
            connection = DruidUtils.getConnection();
            return queryRunner.query(connection, sql, new BeanHandler<>(clazz), params);
        } catch (SQLException e) {
            // 将编译异常转换为运行异常，抛出
            throw new RuntimeException(e);
        } finally {
            DruidUtils.close(null, null, connection);
        }
    }

    /**
     * 返回的结果是单行单列，针对任意表
     *
     * @param sql    sql 语句，可以有 ? 占位符
     * @param params 传入 ? 的具体的值，可以是多个
     * @return Object 对象
     */
    public Object querySingles(String sql, Object... params) {
        Connection connection = null;

        try {
            connection = DruidUtils.getConnection();
            return queryRunner.query(connection, sql, new ScalarHandler(), params);
        } catch (SQLException e) {
            // 将编译异常转换为运行异常，抛出
            throw new RuntimeException(e);
        } finally {
            DruidUtils.close(null, null, connection);
        }
    }
}
