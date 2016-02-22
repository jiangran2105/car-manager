package com.jr.view;

import com.jr.model.Car;
import com.jr.model.Customer;
import com.jr.model.CustomerBind;
import com.jr.services.CarMsgService;
import com.jr.services.CustomerService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jiangran on 16-2-13.
 */
public class CustomerController {
    public long isEdit=0L;//默认0为新增，否则为id为更新
    private ObservableList<CustomerBind> customerObservableList= FXCollections.observableArrayList();

    public ObservableList<CustomerBind> getCustomerObservableList() {
        return customerObservableList;
    }

    public void initializeCarComobox(ComboBox box){
        box.setValue("请选择车型");
        box.getItems().clear();
        CarMsgService cms=new CarMsgService();
        List<Car> carList=cms.findAllCar("");
        for (Car c:carList
             ) {
            box.getItems().add(c.getName());
        }
    }
    public void addCustomer(String userName,String carNo,String mobile,String insurance,
                            Long insuranceStartDate,Long insuranceEndDate,String carname,String driveNo,Long checkDate ){
        CustomerService cs=new CustomerService();
        if(isEdit!=0L){
            cs.updateCustomer(userName, carNo, mobile, insurance, insuranceStartDate, insuranceEndDate, carname, driveNo, checkDate,isEdit);
        }else {
            cs.addCustomer(userName, carNo, mobile, insurance, insuranceStartDate, insuranceEndDate, carname, driveNo, checkDate);
        }
        queryAllCustomer();
        isEdit=0L;
    }
    public void queryAllCustomer(){
        queryCustomer("","");
    }
    public void queryCustomer(String name,String carNo){
        CustomerService cs=new CustomerService();
        List<Customer> customers=cs.queryCustomer(carNo,name);
        customerObservableList.clear();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        customerObservableList.addAll(customers.stream().map(c -> new CustomerBind(String.valueOf(c.getId()),
                String.valueOf(c.getName()),
                String.valueOf(c.getCarNo()),
                String.valueOf(c.getMoblie()),
                String.valueOf(c.getInsurance()),
                String.valueOf(format.format(new Date(c.getInsuranceStartDate()))),
                String.valueOf(format.format(new Date(c.getInsuranceEndDate()))),
                String.valueOf(c.getCarName()),
                String.valueOf(c.getDriveNo()),
                String.valueOf(format.format(new Date(c.getCheckDate()))))).collect(Collectors.toList()));
    }
    public void deleteCustomer(String name,String carNo,String id){
        CustomerService cs=new CustomerService();
        cs.deleteById(id);
        List<Customer> customers=cs.queryCustomer(carNo,name);
        customerObservableList.clear();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        customerObservableList.addAll(customers.stream().map(c -> new CustomerBind(String.valueOf(c.getId()),
                String.valueOf(c.getName()),
                String.valueOf(c.getCarNo()),
                String.valueOf(c.getMoblie()),
                String.valueOf(c.getInsurance()),
                String.valueOf(format.format(new Date(c.getInsuranceStartDate()))),
                String.valueOf(format.format(new Date(c.getInsuranceEndDate()))),
                String.valueOf(c.getCarName()),
                String.valueOf(c.getDriveNo()),
                String.valueOf(format.format(new Date(c.getCheckDate()))))).collect(Collectors.toList()));
    }

}
