package com.jr.model;

import javafx.beans.property.StringProperty;

/**
 * Created by jiangran on 16-2-12.
 */
public class CarBind {
    private StringProperty id;
    private StringProperty carName;

    public CarBind() {
    }

    public CarBind(StringProperty id, StringProperty carName) {
        this.id = id;
        this.carName = carName;
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

    public String getCarName() {
        return carName.get();
    }

    public StringProperty carNameProperty() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName.set(carName);
    }
}
