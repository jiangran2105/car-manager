package com.jr.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by jiangran on 16-2-13.
 */
public class CustomerBind {
    private StringProperty id;
    /**
     * 姓名
     */
    private StringProperty name;
    /**
     * 车牌号
     */
    private StringProperty carNo;
    /**
     * 手机号
     */
    private StringProperty moblie;
    /**
     * 交强险
     */
    private StringProperty manInsurance;
    /**
     * 商业险
     */
    private StringProperty busInsurance;
    /**
     * 保险开始日期
     */
    private StringProperty insuranceStartDate;
    /**
     * 保险到期日期
     */
    private StringProperty insuranceEndDate;
    /**
     * 车型id
     */
    private StringProperty  carName;
    /**
     * 车架号
     */
    private StringProperty driveNo;

    public boolean getSelect() {
        return select.get();
    }

    public BooleanProperty selectProperty() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select.set(select);
    }

    private BooleanProperty select;

    public CustomerBind(String id,String name, String carNo, String moblie, String manInsurance,String busInsurance, String insuranceStartDate, String insuranceEndDate, String carName, String driveNo, String checkDate) {
        this.id=new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.carNo = new SimpleStringProperty(carNo);
        this.moblie = new SimpleStringProperty(moblie);
        this.manInsurance = new SimpleStringProperty(manInsurance);
        this.busInsurance=new SimpleStringProperty(busInsurance);
        this.insuranceStartDate = new SimpleStringProperty(insuranceStartDate);
        this.insuranceEndDate = new SimpleStringProperty(insuranceEndDate);
        this.carName = new SimpleStringProperty(carName);
        this.driveNo = new SimpleStringProperty(driveNo);
        this.checkDate = new SimpleStringProperty(checkDate);
        this.select=new SimpleBooleanProperty(false);
    }

    /**
     * 验车日期

     */


    private StringProperty checkDate;

    public String getId() {
        return id.get();
    }

    public StringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
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

    public String getMoblie() {
        return moblie.get();
    }

    public StringProperty moblieProperty() {
        return moblie;
    }

    public void setMoblie(String moblie) {
        this.moblie.set(moblie);
    }

    public String getManInsurance() {
        return manInsurance.get();
    }

    public StringProperty manInsuranceProperty() {
        return manInsurance;
    }

    public void setManInsurance(String manInsurance) {
        this.manInsurance.set(manInsurance);
    }

    public String getBusInsurance() {
        return busInsurance.get();
    }

    public StringProperty busInsuranceProperty() {
        return busInsurance;
    }

    public void setBusInsurance(String busInsurance) {
        this.busInsurance.set(busInsurance);
    }

    public String getInsuranceStartDate() {
        return insuranceStartDate.get();
    }

    public StringProperty insuranceStartDateProperty() {
        return insuranceStartDate;
    }

    public void setInsuranceStartDate(String insuranceStartDate) {
        this.insuranceStartDate.set(insuranceStartDate);
    }

    public String getInsuranceEndDate() {
        return insuranceEndDate.get();
    }

    public StringProperty insuranceEndDateProperty() {
        return insuranceEndDate;
    }

    public void setInsuranceEndDate(String insuranceEndDate) {
        this.insuranceEndDate.set(insuranceEndDate);
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

    public String getDriveNo() {
        return driveNo.get();
    }

    public StringProperty driveNoProperty() {
        return driveNo;
    }

    public void setDriveNo(String driveNo) {
        this.driveNo.set(driveNo);
    }

    public String getCheckDate() {
        return checkDate.get();
    }

    public StringProperty checkDateProperty() {
        return checkDate;
    }

    public void setCheckDate(String checkDate) {
        this.checkDate.set(checkDate);
    }
}
