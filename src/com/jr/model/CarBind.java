package com.jr.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by jiangran on 16-2-12.
 */
public class CarBind {
    private StringProperty id;
    private StringProperty carName;
    private BooleanProperty select;

    public CarBind() {
    }

    public CarBind(StringProperty id, StringProperty carName) {
        this.id = id;
        this.carName = carName;
        this.select=new SimpleBooleanProperty(false);
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

    public boolean getSelect() {
        return select.get();
    }

    public BooleanProperty selectProperty() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select.set(select);
    }
}
