package com.mhl.domain;

/**
 * 餐桌的类，对应数据库中 表 diningTable
 */
public class Table {
    private Integer id;
    private Integer status;
    private String orderName;
    private String orderTel;

    // ApacheDBUtils 底层的反射 需要无参构造器
    public Table() {
    }

    public Table(Integer id, Integer status, String orderName, String orderTel) {
        this.id = id;
        this.status = status;
        this.orderName = orderName;
        this.orderTel = orderTel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderTel() {
        return orderTel;
    }

    public void setOrderTel(String orderTel) {
        this.orderTel = orderTel;
    }

    @Override
    public String toString() {
        return "\nTable{" +
                "id=" + id +
                ", status=" + status +
                ", orderName='" + orderName + '\'' +
                ", orderTel='" + orderTel + '\'' +
                '}';
    }
}
