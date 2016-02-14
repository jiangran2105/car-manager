package com.jr.model;

import javafx.beans.property.StringProperty;

/**
 * Created by jiangran on 16-2-14.
 */
public class RepairHistoryDetailBind {
    private StringProperty id;
    private StringProperty reparId;
    private StringProperty departName;
    private StringProperty provider;
    private StringProperty price;

    public RepairHistoryDetailBind(StringProperty id, StringProperty reparId, StringProperty departName, StringProperty provider, StringProperty price) {
        this.id = id;
        this.reparId = reparId;
        this.departName = departName;
        this.provider = provider;
        this.price = price;
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

    public String getReparId() {
        return reparId.get();
    }

    public StringProperty reparIdProperty() {
        return reparId;
    }

    public void setReparId(String reparId) {
        this.reparId.set(reparId);
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

    public String getProvider() {
        return provider.get();
    }

    public StringProperty providerProperty() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider.set(provider);
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
}
