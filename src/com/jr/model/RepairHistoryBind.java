package com.jr.model;

import javafx.beans.property.StringProperty;

/**
 * Created by jiangran on 16-2-14.
 */
public class RepairHistoryBind {
    private StringProperty id;
    private StringProperty customer;
    private StringProperty carNo;
    private StringProperty carName;
    private StringProperty createTime;
    private StringProperty price;
    private StringProperty remark;

    public RepairHistoryBind(StringProperty id, StringProperty customer, StringProperty carNo, StringProperty carName, StringProperty createTime, StringProperty price, StringProperty remark) {
        this.id = id;
        this.customer = customer;
        this.carNo = carNo;
        this.carName = carName;
        this.createTime = createTime;
        this.price = price;
        this.remark = remark;
    }

    public String getId() {
        return id.get();
    }

    public StringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getCustomer() {
        return customer.get();
    }

    public StringProperty customerProperty() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer.set(customer);
    }

    public String getCarNo() {
        return carNo.get();
    }

    public StringProperty carNoProperty() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo.set(carNo);
    }

    public String getCarName() {
        return carName.get();
    }

    public StringProperty carNameProperty() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName.set(carName);
    }

    public String getCreateTime() {
        return createTime.get();
    }

    public StringProperty createTimeProperty() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime.set(createTime);
    }

    public String getPrice() {
        return price.get();
    }

    public StringProperty priceProperty() {
        return price;
    }

    public void setPrice(String price) {
        this.price.set(price);
    }

    public String getRemark() {
        return remark.get();
    }

    public StringProperty remarkProperty() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark.set(remark);
    }
}
