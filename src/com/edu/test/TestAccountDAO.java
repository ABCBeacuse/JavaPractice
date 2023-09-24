package com.edu.test;

import com.edu.dao.AccountDAO;
import com.edu.domain.Account;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * 测试 AccountDAO 对 account 表的 CRUD 操作
 */
public class TestAccountDAO {

    private AccountDAO accountDAO = new AccountDAO();

    @Test
    void testMulti() {
        // 其中 Connection 对象已经在 queryMulti 方法中关闭，PreparedStatement，ResultSet 已经在 queryMulti 中的 query 方法中关闭
        List<Account> accounts = accountDAO.queryMulti("select * from account", Account.class);
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
    // Actor{id=2, name='马化腾', balance=10100.0}
    // Actor{id=3, name='jack', balance=13281.0}

    @Test
    void testSingleRow() {
        // 其中 Connection 对象已经在 querySingleRow 方法中关闭，PreparedStatement，ResultSet 已经在 querySingleRow 中的 query 方法中关闭
        Account account = accountDAO.querySingleRow("select * from account where id = ?", Account.class, 2);
        System.out.println(account);
    }
    // Actor{id=2, name='马化腾', balance=10100.0}

    @Test
    void testSingles() {
        Object o = accountDAO.querySingles("select name from account where id = ?", 3);
        System.out.println(o);
    }
    // jack

    /**
     * 测试 dml 操作
     */
    @Test
    void testDMLOperation() {
        int effectRow = accountDAO.update("insert into account values (null, ?, ?)", "小青", 23200);
        System.out.println(effectRow > 0 ? "执行成功" : "执行结果没有影响到数据库");
    }
    // 执行成功
}
