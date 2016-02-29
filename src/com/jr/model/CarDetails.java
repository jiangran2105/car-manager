package com.jr.model;

/**
 * Created by jiangran on 16-2-5.
 */
public class CarDetails {
    private long id;
    private long carId;
    /**
     * 配件信息
     */
    private String departName;
    /**
     * 价格
     */
    private double price;
    /**
     * 供应商
     */
    private String provider;

    public CarDetails(){}
    public CarDetails(long carId,String provider, String departName, double price,long id) {
        this.provider = provider;
        this.departName = departName;
        this.price = price;
        this.carId=carId;
        this.id=id;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public String getName() {
        return departName;
    }

    public void setName(String name) {
        this.departName = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }
}
