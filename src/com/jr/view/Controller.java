package com.jr.view;
import com.jr.model.*;
import com.jr.services.NotifyType;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Callback;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Controller {
    Log log= LogFactory.getLog(Controller.class);

    @FXML
    private TabPane tabPane;

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

    /*************维修信息**************/
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

    /*************维修信息**************/
    @FXML
    private TableView<CustomerBind> niTable;
    @FXML
    private TableColumn<CustomerBind, String> cniName;
    @FXML
    private TableColumn<CustomerBind, String> cniCarNo;
    @FXML
    private TableColumn<CustomerBind, String> cniMoblie;
    @FXML
    private TableColumn<CustomerBind, String> cniInsurance;
    @FXML
    private TableColumn<CustomerBind, String> cniInsuranceStartDate;
    @FXML
    private TableColumn<CustomerBind, String> cniInsuranceEndDate;
    @FXML
    private TableColumn<CustomerBind, String> cniDriveNo;
    @FXML
    private TableColumn<CustomerBind, String> cniCarName;
    @FXML
    private TableColumn<CustomerBind, String> cniCheckDate;

    @FXML
    private TableView<CustomerBind> ncTable;
    @FXML
    private TableColumn<CustomerBind, String> cncName;
    @FXML
    private TableColumn<CustomerBind, String> cncCarNo;
    @FXML
    private TableColumn<CustomerBind, String> cncMoblie;
    @FXML
    private TableColumn<CustomerBind, String> cncInsurance;
    @FXML
    private TableColumn<CustomerBind, String> cncInsuranceStartDate;
    @FXML
    private TableColumn<CustomerBind, String> cncInsuranceEndDate;
    @FXML
    private TableColumn<CustomerBind, String> cncDriveNo;
    @FXML
    private TableColumn<CustomerBind, String> cncCarName;
    @FXML
    private TableColumn<CustomerBind, String> cncCheckDate;

    @FXML
    private  void initialize() {
        initializeCarModule();
        initializeCustomerModule();
        initializeRepairModule();
        initializeNeedInsuranceModule();
        initializeNeedCheckModule();

        NotifyController notifyController=new NotifyController();
        notifyController.queryNotifyCustomer(NotifyType.insurance);
        niTable.setItems(notifyController.getCustomerObservableList());
        
        tabPane.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> {
            String tabId=newValue.getId();
            switch (tabId){
                case "customer":
                    clearCustomerField();
                    break;
                case "car":
                    clearCarField();
                    break;
                case "repair":
                    clearRepairField();
                    break;
                case "needInsurance":
                    notifyController.queryNotifyCustomer(NotifyType.insurance);
                    niTable.setItems(notifyController.getCustomerObservableList());
                    break;
                case "needCheck":
                    notifyController.queryNotifyCustomer(NotifyType.checkDate);
                    ncTable.setItems(notifyController.getCustomerObservableList());
                    break;
            }
        }));


    }

    /**
     * 初始化客户信息模块
     */
    private void initializeCustomerModule(){
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
        ctAdd.setOnAction(event1 -> {
            customerController.addCustomer(ctName.getText(),ctCarNo.getText(),ctMobile.getText(),
                    ctInsurance.getText(),ctInsuranceStartDate.getValue().toEpochDay()*24*3600*1000,
                    ctInsuranceEndDate.getValue().toEpochDay()*24*3600*1000,ctCar.getValue().toString(),ctDriveNo.getText(),ctCheckDate.getValue().toEpochDay()*24*3600*1000);
            ctTable.setItems(customerController.getCustomerObservableList());
        });

        ctquery.setOnAction(event -> {
            customerController.queryCustomer(ctqName.getText(),ctqCarNo.getText());
            ctTable.setItems(customerController.getCustomerObservableList());
        });

        ctTable.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> {
            if(newValue!=null){
                ctName.setText(newValue.getName());
                ctCarNo.setText(newValue.getCarNo());
                ctMobile.setText(newValue.getMoblie());
                ctInsurance.setText(newValue.getInsurance());
                ctCar.setValue(newValue.getCarName());
                ctInsuranceStartDate.setValue(LocalDate.parse(newValue.getInsuranceStartDate()));
                ctInsuranceEndDate.setValue(LocalDate.parse(newValue.getInsuranceEndDate()));
                ctCheckDate.setValue(LocalDate.parse(newValue.getCheckDate()));
                ctDriveNo.setText(newValue.getDriveNo());
                customerController.isEdit=Long.valueOf(newValue.getId());
            }
        }));
    }
    /**
     * 初始化车辆信息模块
     */
    private void initializeCarModule(){
        cdtDepartName.setCellValueFactory(c->c.getValue().departNameProperty());
        cdtPrice.setCellValueFactory(c->c.getValue().priceProperty());
        cdtProvider.setCellValueFactory(c->c.getValue().providerProperty());
        cdtId.setCellValueFactory(c->c.getValue().idProperty());
        carAdd.setOnAction(event -> {
            CarController carController=new CarController();
            carController.addCarMsg(carName.getText(),carDepart.getText(),Double.valueOf(carPrice.getText()),carProvider.getText());
            carDetailsTable.setItems(carController.getCarDetailsObservableList());
        });
        cId.setCellValueFactory(c->c.getValue().idProperty());
        cName.setCellValueFactory(c->c.getValue().carNameProperty());
        carQuery.setOnAction(event -> {
            CarController carController=new CarController();
            carController.queryCars(carQueryName.getText());
            carTable.setItems(carController.getCarObservableList());
        });
        ccdtDepartName.setCellValueFactory(c->c.getValue().departNameProperty());
        ccdtPrice.setCellValueFactory(c->c.getValue().priceProperty());
        ccdtProvider.setCellValueFactory(c->c.getValue().providerProperty());
        carTable.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> {
            if(newValue!=null){
                CarController carController=new CarController();
                carController.fillCarDetailsObservableList(Long.valueOf(newValue.getId()));
                ccDetailsTable.setItems(carController.getCarDetailsObservableList());
            }
        }));

    }

    /**
     * 初始化维修记录模块
     */
    private void initializeRepairModule(){
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

        rName.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER)  {
                Customer customer=repairController.findCustomer(rName.getText());
                if(customer!=null){
                    rCarNo.setText(customer.getCarNo());
                    rCarName.setValue(customer.getCarName());
                    repairController.findCarDetailsByCarName(customer.getCarName());
                    rDetailsTable.setItems(repairController.getCarDetailsObservableList());
                }

            }
        });
        rcSelect.setCellFactory(param -> {
            return new CheckBoxTableCell<CarDetailsBind, Boolean>();
        });
        radd.setOnAction(event -> {
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
                    clearRepairField();
                }
            });
        });
        rQuery.setOnAction(event -> {
            repairController.findRepairs();
            rRepairTable.setItems(repairController.getRepairObservableList());
        });
        rRepairTable.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> {
            if(newValue!=null){
                repairController.findRepairDetails(Long.valueOf(newValue.getId()));
                rRepairDetailsTable.setItems(repairController.getRepairDetailObservableList());
            }
        }));
    }

    private void initializeNeedInsuranceModule(){
        cniName.setCellValueFactory(c->c.getValue().nameProperty());
        cniCarNo.setCellValueFactory(c->c.getValue().carNoProperty());
        cniMoblie.setCellValueFactory(c->c.getValue().moblieProperty());
        cniInsurance.setCellValueFactory(c->c.getValue().insuranceProperty());
        cniInsuranceStartDate.setCellValueFactory(c->c.getValue().insuranceStartDateProperty());
        cniInsuranceEndDate.setCellValueFactory(c->c.getValue().insuranceEndDateProperty());
        cniCarName.setCellValueFactory(c->c.getValue().carNameProperty());
        cniDriveNo.setCellValueFactory(c->c.getValue().driveNoProperty());
        cniCheckDate.setCellValueFactory(c->c.getValue().checkDateProperty());
    }
    private void initializeNeedCheckModule(){
        cncName.setCellValueFactory(c->c.getValue().nameProperty());
        cncCarNo.setCellValueFactory(c->c.getValue().carNoProperty());
        cncMoblie.setCellValueFactory(c->c.getValue().moblieProperty());
        cncInsurance.setCellValueFactory(c->c.getValue().insuranceProperty());
        cncInsuranceStartDate.setCellValueFactory(c->c.getValue().insuranceStartDateProperty());
        cncInsuranceEndDate.setCellValueFactory(c->c.getValue().insuranceEndDateProperty());
        cncCarName.setCellValueFactory(c->c.getValue().carNameProperty());
        cncDriveNo.setCellValueFactory(c->c.getValue().driveNoProperty());
        cncCheckDate.setCellValueFactory(c->c.getValue().checkDateProperty());
    }

    private void clearCustomerField(){
        ctName.clear();
        ctCarNo.clear();
        ctMobile.clear();
        ctInsurance.clear();
        ctInsuranceStartDate.setValue(null);
        ctInsuranceEndDate.setValue(null);
        ctDriveNo.clear();
        ctCheckDate.setValue(null);
        ctCar.setValue("请选择车型");
        ctqCarNo.clear();
        ctqName.clear();
        ctTable.getItems().clear();
    }
    private void clearCarField(){
        carName.clear();
        carDepart.clear();
        carPrice.clear();
        carProvider.clear();
        carQueryName.clear();
        carDetailsTable.getItems().clear();
        carTable.getItems().clear();
        ccDetailsTable.getItems().clear();

    }
    private void clearRepairField(){
        rName.clear();
        rCarNo.clear();
        rCarName.setValue("");
        rDetailsTable.getItems().clear();
    }
}

