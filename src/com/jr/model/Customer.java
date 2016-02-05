package com.jr.model;

/**
 * Created by jiangran on 16-2-5.
 */
public class Customer {
    private long id;
    private String name;
    private String carNo;
    private String moblie;
    private String insurance;
    private long insuranceStartDate;
    private long insuranceEndDate;
    private double maintenance;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public String getMoblie() {
        return moblie;
    }

    public void setMoblie(String moblie) {
        this.moblie = moblie;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public long getInsuranceStartDate() {
        return insuranceStartDate;
    }

    public void setInsuranceStartDate(long insuranceStartDate) {
        this.insuranceStartDate = insuranceStartDate;
    }

    public long getInsuranceEndDate() {
        return insuranceEndDate;
    }

    public void setInsuranceEndDate(long insuranceEndDate) {
        this.insuranceEndDate = insuranceEndDate;
    }

    public double getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(double maintenance) {
        this.maintenance = maintenance;
    }
}
