package com.jr.model;

/**
 * Created by jiangran on 16-2-5.
 */
public class CarDetails {
    private long carId;
    private String name;
    private double price;

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
