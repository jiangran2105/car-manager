package com.jr.model;

import javafx.beans.property.*;

/**
 * Created by jiangran on 16-2-11.
 */
public class CarDetailsBind {
    private StringProperty departName;
    private StringProperty price;
    private StringProperty provider;
    private StringProperty id;
    private BooleanProperty select;

    public CarDetailsBind(StringProperty departName, StringProperty price, StringProperty provider, StringProperty id) {
        this.departName = departName;
        this.price = price;
        this.provider = provider;
        this.id = id;
        this.select=new SimpleBooleanProperty(false);
    }

    public String getDepartName() {
        return departName.get();
    }

    public StringProperty departNameProperty() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName.set(departName);
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

    public String getProvider() {
        return provider.get();
    }

    public StringProperty providerProperty() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider.set(provider);
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
