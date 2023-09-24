package com.mhl.service;

import com.mhl.dao.EmployeeDAO;
import com.mhl.domain.Employee;

/**
 * employee 表相关的服务层
 */
public class EmployeeService {
    private EmployeeDAO employeeDAO = new EmployeeDAO();

    /**
     * 登录
     *
     * @param empId 员工号
     * @param pwd   密码
     * @return
     */
    public Employee login(String empId, String pwd) {
        // 如果返回 null, 则证明数据库中没有查找到指定用户, 即登录失败
        return employeeDAO.querySingleRow("select * from employee where empId = ? and password = md5(?)", Employee.class, empId, pwd);
    }
}
