package com.jr.model;

/**
 * Created by jiangran on 16-2-5.
 */
public class RepairHistoryDetail {
    private long id;
    private long reparId;
    private String departName;
    private String provider;
    private double price;

    public RepairHistoryDetail(long id, long reparId, String departName, double price,String provider) {
        this.id = id;
        this.reparId = reparId;
        this.departName = departName;
        this.price = price;
        this.provider=provider;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getReparId() {
        return reparId;
    }

    public void setReparId(Long reparId) {
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

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }
}
