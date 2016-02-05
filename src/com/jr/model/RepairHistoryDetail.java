package com.jr.model;

/**
 * Created by jiangran on 16-2-5.
 */
public class RepairHistoryDetail {
    private long id;
    private String reparId;
    private String departName;
    private double price;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getReparId() {
        return reparId;
    }

    public void setReparId(String reparId) {
        this.reparId = reparId;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
