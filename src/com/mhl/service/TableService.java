package com.mhl.service;


import com.mhl.dao.TableDAO;
import com.mhl.domain.Table;

import java.util.List;

/**
 * employee 表相关的服务层
 */
public class TableService {
    private TableDAO tableDAO = new TableDAO();

    /**
     * 列出所有桌子的状态
     *
     * @return
     */
    public List<Table> list() {
        return tableDAO.queryRows("select id, status from diningTable", Table.class);
    }

    /**
     * 预定桌子
     *
     * @param id
     * @return
     */
}
