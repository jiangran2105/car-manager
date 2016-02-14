package com.jr.model;

/**
 * Created by jiangran on 16-2-5.
 */
public class Customer {
    private long id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 车牌号
     */
    private String carNo;
    /**
     * 手机号
     */
    private String moblie;
    /**
     * 保险名称，人保，平安。。。
     */
    private String insurance;
    /**
     * 保险开始日期
     */
    private long insuranceStartDate;
    /**
     * 保险到期日期
     */
    private long insuranceEndDate;
    /**
     * 车型id
     */
    private String  carName;
    /**
     * 车架号
     */
    private String driveNo;
    /**
     * 验车日期

     */
    private long checkDate;

    public Customer(long id, String name, String carNo, String moblie, String insurance, long insuranceStartDate, long insuranceEndDate, String carName, String driveNo, long checkDate) {
        this.id = id;
        this.name = name;
        this.carNo = carNo;
        this.moblie = moblie;
        this.insurance = insurance;
        this.insuranceStartDate = insuranceStartDate;
        this.insuranceEndDate = insuranceEndDate;
        this.carName = carName;
        this.driveNo = driveNo;
        this.checkDate = checkDate;
    }

    public long getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(long checkDate) {
        this.checkDate = checkDate;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String  carName) {
        this.carName = carName;
    }

    public String getDriveNo() {
        return driveNo;
    }

    public void setDriveNo(String driveNo) {
        this.driveNo = driveNo;
    }
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

}
