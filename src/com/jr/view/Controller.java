package com.jr.view;
import com.jr.model.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Callback;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Controller {
    @FXML
    private TextField ctName;
    @FXML
    private TextField ctCarNo;
    @FXML
    private TextField ctMobile;
    @FXML
    private TextField ctInsurance;
    @FXML
    private DatePicker ctInsuranceStartDate;
    @FXML
    private DatePicker ctInsuranceEndDate;
    @FXML
    private TextField ctDriveNo;
    @FXML
    private DatePicker ctCheckDate;
    @FXML
    private ComboBox ctCar;
    @FXML
    private Button ctAdd;
    @FXML
    private TextField ctqCarNo;
    @FXML
    private TextField ctqName;
    @FXML
    private Button ctquery;

    @FXML
    private TableView<CustomerBind> ctTable;
    @FXML
    private TableColumn<CustomerBind, String> ctcName;
    @FXML
    private TableColumn<CustomerBind, String> ctcCarNo;
    @FXML
    private TableColumn<CustomerBind, String> ctcMoblie;
    @FXML
    private TableColumn<CustomerBind, String> ctcInsurance;
    @FXML
    private TableColumn<CustomerBind, String> ctcInsuranceStartDate;
    @FXML
    private TableColumn<CustomerBind, String> ctcInsuranceEndDate;
    @FXML
    private TableColumn<CustomerBind, String> ctcDriveNo;
    @FXML
    private TableColumn<CustomerBind, String> ctcCarName;
    @FXML
    private TableColumn<CustomerBind, String> ctcCheckDate;

    /*************车辆信息**************/
    @FXML
    private TextField carName;
    @FXML
    private TextField carDepart;
    @FXML
    private TextField carPrice;
    @FXML
    private TextField carProvider;
    @FXML
    private Button carAdd;

    @FXML
    private TableView<CarDetailsBind> carDetailsTable;
    @FXML
    private TableColumn<CarDetailsBind, String> cdtDepartName;
    @FXML
    private TableColumn<CarDetailsBind, String> cdtPrice;
    @FXML
    private TableColumn<CarDetailsBind, String> cdtProvider;
    @FXML
    private TableColumn<CarDetailsBind, String> cdtId;

    @FXML
    private Button carQuery;
    @FXML
    private TableView<CarBind> carTable;
    @FXML
    private TableColumn<CarBind,String> cName;
    @FXML
    private TableColumn<CarBind,String> cId;
    @FXML
    private TextField carQueryName;

    @FXML
    private TableView<CarDetailsBind> ccDetailsTable;
    @FXML
    private TableColumn<CarDetailsBind, String> ccdtDepartName;
    @FXML
    private TableColumn<CarDetailsBind, String> ccdtPrice;
    @FXML
    private TableColumn<CarDetailsBind, String> ccdtProvider;

    /*************车辆信息**************/
    @FXML
    private TextField rName;
    @FXML
    private TextField rCarNo;
    @FXML
    private ComboBox rCarName;
    @FXML
    private TextField rTotalPrice;

    @FXML
    private TableView<CarDetailsBind> rDetailsTable;
    @FXML
    private TableColumn<CarDetailsBind, Boolean> rcSelect;
    @FXML
    private TableColumn<CarDetailsBind, String> rcDepartName;
    @FXML
    private TableColumn<CarDetailsBind, String> rcPrice;
    @FXML
    private TableColumn<CarDetailsBind, String> rcProvider;
    @FXML
    private Button radd;
    @FXML
    private Button rQuery;
    @FXML
    private TableView<RepairHistoryBind> rRepairTable;
    @FXML
    private TableColumn<RepairHistoryBind, String> rcCustomer;
    @FXML
    private TableColumn<RepairHistoryBind, String> rcCarNo;
    @FXML
    private TableColumn<RepairHistoryBind, String> rcCarName;
    @FXML
    private TableColumn<RepairHistoryBind, String> rcCreatetime;
    @FXML
    private TableColumn<RepairHistoryBind, String> rcTotalPrice;


    @FXML
    private TableView<RepairHistoryDetailBind> rRepairDetailsTable;
    @FXML
    private TableColumn<RepairHistoryDetailBind, String> rdcDepartName;
    @FXML
    private TableColumn<RepairHistoryDetailBind, String> rdcPrice;
    @FXML
    private TableColumn<RepairHistoryDetailBind, String> rdcProvider;


    @FXML
    private  void initialize() {
        initializeCarMoudle();
        initializeCustomerMoudle();
        initializeRepairMoudle();

    }

    /**
     * 初始化客户信息模块
     */
    private void initializeCustomerMoudle(){
        CustomerController customerController=new CustomerController();
        customerController.initializeCarComobox(ctCar);
        ctcName.setCellValueFactory(c->c.getValue().nameProperty());
        ctcCarNo.setCellValueFactory(c->c.getValue().carNoProperty());
        ctcMoblie.setCellValueFactory(c->c.getValue().moblieProperty());
        ctcInsurance.setCellValueFactory(c->c.getValue().insuranceProperty());
        ctcInsuranceStartDate.setCellValueFactory(c->c.getValue().insuranceStartDateProperty());
        ctcInsuranceEndDate.setCellValueFactory(c->c.getValue().insuranceEndDateProperty());
        ctcCarName.setCellValueFactory(c->c.getValue().carNameProperty());
        ctcDriveNo.setCellValueFactory(c->c.getValue().driveNoProperty());
        ctcCheckDate.setCellValueFactory(c->c.getValue().checkDateProperty());
        ctAdd.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                customerController.addCustomer(ctName.getText(),ctCarNo.getText(),ctMobile.getText(),
                        ctInsurance.getText(),ctInsuranceStartDate.getValue().toEpochDay()*24*3600*1000,
                        ctInsuranceEndDate.getValue().toEpochDay()*24*3600*1000,ctCar.getValue().toString(),ctDriveNo.getText(),ctCheckDate.getValue().toEpochDay()*24*3600*1000);
               ctTable.setItems(customerController.getCustomerObservableList());
//                Date d=new Date(1454371200000L);
            }
        });
        ctquery.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                customerController.queryCustomer(ctqName.getText(),ctqCarNo.getText());
                ctTable.setItems(customerController.getCustomerObservableList());
            }
        });
        ctTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<CustomerBind>() {
            @Override
            public void changed(ObservableValue<? extends CustomerBind> observable, CustomerBind oldValue, CustomerBind newValue) {
                if(newValue!=null){
                    ctName.setText(newValue.getName());
                    ctCarNo.setText(newValue.getCarNo());
                    ctMobile.setText(newValue.getMoblie());
                    ctInsurance.setText(newValue.getInsurance());
                    ctCar.setValue(newValue.getCarName());
                    ctInsuranceStartDate.setValue(LocalDate.ofEpochDay(Long.valueOf(newValue.getInsuranceStartDate())/24/3600/1000));
                    ctInsuranceEndDate.setValue(LocalDate.ofEpochDay(Long.valueOf(newValue.getInsuranceEndDate())/24/3600/1000));
                    ctCheckDate.setValue(LocalDate.ofEpochDay(Long.valueOf(newValue.getCheckDate())/24/3600/1000));
                    customerController.isEdit=Long.valueOf(newValue.getId());
                }
            }
        });
    }
    /**
     * 初始化车辆信息模块
     */
    private void initializeCarMoudle(){
        cdtDepartName.setCellValueFactory(c->c.getValue().departNameProperty());
        cdtPrice.setCellValueFactory(c->c.getValue().priceProperty());
        cdtProvider.setCellValueFactory(c->c.getValue().providerProperty());
        cdtId.setCellValueFactory(c->c.getValue().idProperty());
        carAdd.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                CarController carController=new CarController();
                carController.addCarMsg(carName.getText(),carDepart.getText(),Double.valueOf(carPrice.getText()),carProvider.getText());
                carDetailsTable.setItems(carController.getCarDetailsObservableList());
            }
        });
        cId.setCellValueFactory(c->c.getValue().idProperty());
        cName.setCellValueFactory(c->c.getValue().carNameProperty());
        carQuery.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                CarController carController=new CarController();
                carController.queryCars(carQueryName.getText());
                carTable.setItems(carController.getCarObservableList());
            }
        });
        ccdtDepartName.setCellValueFactory(c->c.getValue().departNameProperty());
        ccdtPrice.setCellValueFactory(c->c.getValue().priceProperty());
        ccdtProvider.setCellValueFactory(c->c.getValue().providerProperty());
        carTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<CarBind>() {
            @Override
            public void changed(ObservableValue<? extends CarBind> observable, CarBind oldValue, CarBind newValue) {
                if(newValue!=null){
                    CarController carController=new CarController();
                    carController.fillCarDetailsObservableList(Long.valueOf(newValue.getId()));
                    ccDetailsTable.setItems(carController.getCarDetailsObservableList());
                }

            }
        });

    }

    private void initializeRepairMoudle(){
        RepairController repairController=new RepairController();
        rcDepartName.setCellValueFactory(c->c.getValue().departNameProperty());
        rcProvider.setCellValueFactory(c->c.getValue().providerProperty());
        rcPrice.setCellValueFactory(c->c.getValue().priceProperty());
        rcSelect.setCellValueFactory(c->c.getValue().selectProperty());

        rcCustomer.setCellValueFactory(c->c.getValue().customerProperty());
        rcTotalPrice.setCellValueFactory(c->c.getValue().priceProperty());
        rcCarNo.setCellValueFactory(c->c.getValue().carNoProperty());
        rcCarName.setCellValueFactory(c->c.getValue().carNameProperty());
        rcCreatetime.setCellValueFactory(c->c.getValue().createTimeProperty());

        rdcDepartName.setCellValueFactory(c->c.getValue().departNameProperty());
        rdcProvider.setCellValueFactory(c->c.getValue().providerProperty());
        rdcPrice.setCellValueFactory(c->c.getValue().priceProperty());

        rName.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER)  {
                    Customer customer=repairController.findCustomer(rName.getText());
                    if(customer!=null){
                        rCarNo.setText(customer.getCarNo());
                        rCarName.setValue(customer.getCarName());
                        repairController.findCarDetailsByCarName(customer.getCarName());
                        rDetailsTable.setItems(repairController.getCarDetailsObservableList());
                    }

                }
            }
        });
        rcSelect.setCellFactory(new Callback<TableColumn<CarDetailsBind, Boolean>, TableCell<CarDetailsBind, Boolean>>() {
            @Override
            public TableCell<CarDetailsBind, Boolean> call(TableColumn<CarDetailsBind, Boolean> param) {
                return new CheckBoxTableCell<CarDetailsBind, Boolean>();
            }
        });
        radd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                List<CarDetails> details=new ArrayList<CarDetails>();
                Double totalPrice=0.0;
                for (CarDetailsBind c:rDetailsTable.getItems()
                     ) {
                    if(c.getSelect()){
                        Double price=Double.valueOf(c.getPrice());
                        totalPrice+=price;
                        CarDetails cd=new CarDetails(0L,c.getProvider(),c.getDepartName(),price);
                        details.add(cd);
                    }
                }
                repairController.addRepair(rName.getText(),rCarNo.getText(),rCarName.getValue().toString(),totalPrice,details);
                Alert alert=new Alert(Alert.AlertType.INFORMATION,"添加成功");
                alert.showAndWait().ifPresent(response -> {
                    if (response == ButtonType.OK) {
                        System.out.print("ok");
                    }
                });


            }
        });
        rQuery.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                repairController.findRepairs();
                rRepairTable.setItems(repairController.getRepairObservableList());
            }
        });
        rRepairTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<RepairHistoryBind>() {
            @Override
            public void changed(ObservableValue<? extends RepairHistoryBind> observable, RepairHistoryBind oldValue, RepairHistoryBind newValue) {
                if(newValue!=null){
                    repairController.findRepairDetails(Long.valueOf(newValue.getId()));
                    rRepairDetailsTable.setItems(repairController.getRepairDetailObservableList());
                }
            }
        });
    }
}
