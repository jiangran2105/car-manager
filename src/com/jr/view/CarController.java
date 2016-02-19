package com.jr.view;

import com.jr.model.Car;
import com.jr.model.CarBind;
import com.jr.model.CarDetails;
import com.jr.model.CarDetailsBind;
import com.jr.services.CarMsgService;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

/**
 * Created by jiangran on 16-2-11.
 */
public class CarController {
    private ObservableList<CarDetailsBind> carDetailsObservableList = FXCollections.observableArrayList();
    private ObservableList<CarBind> carObservableList = FXCollections.observableArrayList();

    public ObservableList<CarDetailsBind> getCarDetailsObservableList() {
        return carDetailsObservableList;
    }

    public ObservableList<CarBind> getCarObservableList() {
        return carObservableList;
    }

    private CarMsgService carMsgService=new CarMsgService();

    public void fillCarDetailsObservableList(long carId){
        List<CarDetails> details= carMsgService.findDetailsById(carId);
        for (CarDetails d:details) {
            CarDetailsBind cdb=new CarDetailsBind(new SimpleStringProperty(d.getName()),new SimpleStringProperty(String.valueOf(d.getPrice())),
                    new SimpleStringProperty(d.getProvider()),new SimpleStringProperty(String.valueOf(d.getId())));
            carDetailsObservableList.add(cdb);
        }
    }
    public void addCarMsg(String carName,String departName,double price,String provider){
        Long carId=carMsgService.addRecord(carName,departName,price,provider);
        fillCarDetailsObservableList(carId);
    }
    public void queryCars(String carName){
        List<Car> cars =carMsgService.findAllCar(carName);
        for (Car c:cars) {
            CarBind cb=new CarBind(new SimpleStringProperty(String.valueOf(c.getId())),new SimpleStringProperty(c.getName()));
            carObservableList.add(cb);
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
}
