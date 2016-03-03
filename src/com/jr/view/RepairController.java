package com.jr.view;

import com.jr.model.*;
import com.jr.services.CarMsgService;
import com.jr.services.CustomerService;
import com.jr.services.RepairService;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

import java.text.DateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jiangran on 16-2-13.
 */
public class RepairController {
    private ObservableList<CarDetailsBind> carDetailsObservableList = FXCollections.observableArrayList();
    private ObservableList<RepairHistoryBind> repairObservableList = FXCollections.observableArrayList();
    private ObservableList<RepairHistoryDetailBind> repairDetailObservableList = FXCollections.observableArrayList();

    public ObservableList<CarDetailsBind> getCarDetailsObservableList() {
        return carDetailsObservableList;
    }

    public ObservableList<RepairHistoryBind> getRepairObservableList() {
        return repairObservableList;
    }

    public ObservableList<RepairHistoryDetailBind> getRepairDetailObservableList() {
        return repairDetailObservableList;
    }

    /*public Customer findCustomer(String name){
        CustomerService cs=new CustomerService();
        Customer customer=cs.queryCustomerByName(name);
        return customer;
    }*/
    public void addRepair(String customerName, String carNo, String carName, double price, List<CarDetails> details){
        RepairService repairService=new RepairService();
        repairService.addRepair(customerName, carNo, carName, price, details);
    }

    public void findCarDetailsByCarName(){
        carDetailsObservableList.clear();
        CarMsgService cms=new CarMsgService();
        List<CarDetails> carDetails= cms.findDetailsAll();
        for (CarDetails d:carDetails) {
            CarDetailsBind cdb=new CarDetailsBind(new SimpleStringProperty(d.getName()),new SimpleStringProperty(String.valueOf(d.getPrice())),
                    new SimpleStringProperty(d.getProvider()),new SimpleStringProperty("1"));
            carDetailsObservableList.add(cdb);
        }
    }
    public void findRepairs(String name,String carNo){
        repairObservableList.clear();
        RepairService repairService=new RepairService();
        List<RepairHistory> repairHis = repairService.findRepairHis(name, carNo);
        for (RepairHistory rh:repairHis
             ) {
            RepairHistoryBind rhb=new RepairHistoryBind(new SimpleStringProperty(String.valueOf(rh.getId())),
                    new SimpleStringProperty(rh.getCustomer()),
                    new SimpleStringProperty(rh.getCarNo()),
                    new SimpleStringProperty(rh.getCarName()),
                    new SimpleStringProperty(String.valueOf(DateFormat.getDateInstance().format(new Date(rh.getCreateTime())))),
                    new SimpleStringProperty(String.valueOf(rh.getPrice())),
                    new SimpleStringProperty(rh.getRemark()));
            repairObservableList.add(rhb);
        }
    }
    public void findRepairDetails(Long repairId){
        repairDetailObservableList.clear();
        RepairService repairService=new RepairService();
        List<RepairHistoryDetail> repairHisDetails = repairService.findRepairHisDetails(repairId);
        for (RepairHistoryDetail d:repairHisDetails
             ) {
            RepairHistoryDetailBind db=new RepairHistoryDetailBind(new SimpleStringProperty(String.valueOf(d.getId())),
                    new SimpleStringProperty(String.valueOf(d.getReparId())),
                    new SimpleStringProperty(d.getDepartName()),
                    new SimpleStringProperty(d.getProvider()),
                    new SimpleStringProperty(String.valueOf(d.getPrice())));
            repairDetailObservableList.add(db);
        }
    }
    public void clearRepairHis(){
        RepairService repairService=new RepairService();
        repairService.clearHis();
    }
    public void initializeCustomerComobox(ComboBox box){
        box.setValue("请选择车主");
        box.getItems().clear();
        CustomerService customerService=new CustomerService();
        List<Customer> customers = customerService.queryCustomer("", "");
        List<String> CNames= customers.stream().map(customer -> {return customer.getName();}).distinct().collect(Collectors.toList());
        CNames.forEach(c->box.getItems().addAll(c));

    }
    public Customer initializeCarNoComobox(ComboBox box,String cusName){
        box.setValue("");
        box.getItems().clear();
        CustomerService customerService=new CustomerService();
        List<Customer> customers = customerService.queryCustomerByName(cusName);
        if(customers.size()>1){
            customers.forEach(c->box.getItems().add(c.getCarNo()));
        }
        return customers.size()>0?customers.get(0):null;
    }
    public Customer findCustomerByCarNo(String carNo){
        CustomerService customerService=new CustomerService();
        Customer customer = customerService.queryCustomerByCarNo(carNo);
        return customer;
    }
}
