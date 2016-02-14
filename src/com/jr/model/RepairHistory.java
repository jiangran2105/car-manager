package com.jr.model;

/**
 * Created by jiangran on 16-2-5.
 */
public class RepairHistory {
    private long id;
    private String customer;
    private String carNo;
    private String carName;
    private long createTime;
    private double price;
    private String remark;

    public RepairHistory(long id, String customer, String carNo, String carName, long createTime, double price, String remark) {
        this.id = id;
        this.customer = customer;
        this.carNo = carNo;
        this.carName = carName;
        this.createTime = createTime;
        this.price = price;
        this.remark = remark;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
