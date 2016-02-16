package com.jr.view;

import com.jr.model.Customer;
import com.jr.model.CustomerBind;
import com.jr.services.NotifyService;
import com.jr.services.NotifyType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by JIANGRAN on 2016/2/16.
 */
public class NotifyController {
    private long dayOfSec=24*3600*1000;
    private ObservableList<CustomerBind> customerObservableList= FXCollections.observableArrayList();
    public ObservableList<CustomerBind> getCustomerObservableList() {
        return customerObservableList;
    }

    public void queryNotifyCustomer(NotifyType type){
        NotifyService notifyService=new NotifyService();
        long begin=LocalDate.now().toEpochDay()*dayOfSec;
        long end = LocalDate.now().toEpochDay() * dayOfSec + 30 * dayOfSec;
        List<Customer> notifyCustomerList = notifyService.findNotifyCustomerList(type, begin, end);
        customerObservableList.clear();
        customerObservableList.addAll(notifyCustomerList.stream().map(c -> new CustomerBind(String.valueOf(c.getId()),
                String.valueOf(c.getName()),
                String.valueOf(c.getCarNo()),
                String.valueOf(c.getMoblie()),
                String.valueOf(c.getInsurance()),
                String.valueOf(DateFormat.getDateInstance().format(new Date(c.getInsuranceStartDate()))),
                String.valueOf(DateFormat.getDateInstance().format(new Date(c.getInsuranceEndDate()))),
                String.valueOf(c.getCarName()),
                String.valueOf(c.getDriveNo()),
                String.valueOf(DateFormat.getDateInstance().format(new Date(c.getCheckDate()))))).collect(Collectors.toList()));
    }
}
