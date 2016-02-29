package com.jr.view;

import com.jr.model.CarDetails;
import com.jr.model.CarDetailsBind;
import com.jr.services.CarMsgService;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

import java.util.List;

/**
 * Created by jiangran on 16-2-11.
 */
public class CarController {
    private ObservableList<CarDetailsBind> carDetailsObservableList = FXCollections.observableArrayList();

    public ObservableList<CarDetailsBind> getCarDetailsObservableList() {
        return carDetailsObservableList;
    }


    private CarMsgService carMsgService=new CarMsgService();

    public void addDetails(String departName,String price,String provider){
        carMsgService.insertCarDetails(departName, price, provider);
    }
    public void fillCarDetailsObservableList(long carId){
        List<CarDetails> details= carMsgService.findDetailsById(carId);
        for (CarDetails d:details) {
            CarDetailsBind cdb=new CarDetailsBind(new SimpleStringProperty(d.getName()),new SimpleStringProperty(String.valueOf(d.getPrice())),
                    new SimpleStringProperty(d.getProvider()),new SimpleStringProperty(String.valueOf(d.getId())));
            carDetailsObservableList.add(cdb);
        }
    }
    public void queryDetailByCarName(String carName){
        List<CarDetails> details = carMsgService.findDetailsByName(carName);
        for (CarDetails d:details) {
            CarDetailsBind cdb=new CarDetailsBind(new SimpleStringProperty(d.getName()),new SimpleStringProperty(String.valueOf(d.getPrice())),
                    new SimpleStringProperty(d.getProvider()),new SimpleStringProperty(String.valueOf(d.getId())));
            carDetailsObservableList.add(cdb);
        }
    }
    public void deleteCarDetails(String id){
        carMsgService.deleteDetailsById(id);
    }
    public void deleteCars(String id){
        carMsgService.deleteCarsById(id);
    }
}
