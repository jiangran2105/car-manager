package com.jr.view;
import com.jr.model.*;
import com.jr.services.NotifyType;
import javafx.beans.property.BooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
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
    private MenuItem clearRH;

    @FXML
    private TextField ctName;
    @FXML
    private TextField ctCarNo;
    @FXML
    private TextField ctMobile;
    @FXML
    private TextField ctManInsurance;
    @FXML
    private TextArea ctBusInsurance;
    @FXML
    private DatePicker ctInsuranceStartDate;
    @FXML
    private DatePicker ctInsuranceEndDate;
    @FXML
    private TextField ctDriveNo;
    @FXML
    private DatePicker ctCheckDate;
    @FXML
    private TextField ctCar;
    @FXML
    private Button ctAdd;
    @FXML
    private Button ctClear;
    @FXML
    private TextField ctqCarNo;
    @FXML
    private TextField ctqName;
    @FXML
    private Button ctquery;
    @FXML
    private Button ctDelete;

    @FXML
    private TableView<CustomerBind> ctTable;
    @FXML
    private TableColumn<CustomerBind,Boolean> ctcSelect;
    @FXML
    private TableColumn<CustomerBind, String> ctcName;
    @FXML
    private TableColumn<CustomerBind, String> ctcCarNo;
    @FXML
    private TableColumn<CustomerBind, String> ctcMoblie;
    @FXML
    private TableColumn<CustomerBind, String> ctcManInsurance;
    @FXML
    private TableColumn<CustomerBind, String> ctcBusInsurance;
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
    private TextField carDepart;
    @FXML
    private TextField carPrice;
    @FXML
    private TextField carProvider;
    @FXML
    private Button carAdd;
    @FXML
    private Button detailDelete;

    @FXML
    private TableView<CarDetailsBind> carDetailsTable;
    @FXML
    private TableColumn<CarDetailsBind,Boolean> cdtSelect;
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
    private Button carDelete;
    @FXML
    private TextField carQueryName;


    /*************维修信息**************/
    @FXML
    private ComboBox rName;
    @FXML
    private ComboBox rCarNo;
    @FXML
    private TextField rCarName;
    @FXML
    private TextArea rRemark;
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
    private Button rDelete;
    @FXML
    private TextField rqCusName;
    @FXML
    private TextField rqCarNo;
    @FXML
    private TableView<RepairHistoryBind> rRepairTable;
    @FXML
    private TableColumn<RepairHistoryBind, Boolean> rbcSelect;
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
    private TableColumn<RepairHistoryBind, String> rcRemark;
    @FXML
    private TableColumn<RepairHistoryBind, String> rbcId;

    @FXML
    private TableView<RepairHistoryDetailBind> rRepairDetailsTable;
    @FXML
    private TableColumn<RepairHistoryDetailBind, String> rdcDepartName;
    @FXML
    private TableColumn<RepairHistoryDetailBind, String> rdcPrice;
    @FXML
    private TableColumn<RepairHistoryDetailBind, String> rdcProvider;

    /*************保险到期提醒**************/
    @FXML
    private TableView<CustomerBind> niTable;
    @FXML
    private TableColumn<CustomerBind, String> cniName;
    @FXML
    private TableColumn<CustomerBind, String> cniCarNo;
    @FXML
    private TableColumn<CustomerBind, String> cniMoblie;
    @FXML
    private TableColumn<CustomerBind, String> cniManInsurance;
    @FXML
    private TableColumn<CustomerBind, String> cniBusInsurance;
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
    /*************车检到期提醒**************/
    @FXML
    private TableView<CustomerBind> ncTable;
    @FXML
    private TableColumn<CustomerBind, String> cncName;
    @FXML
    private TableColumn<CustomerBind, String> cncCarNo;
    @FXML
    private TableColumn<CustomerBind, String> cncMoblie;
    @FXML
    private TableColumn<CustomerBind, String> cncManInsurance;
    @FXML
    private TableColumn<CustomerBind, String> cncBusInsurance;
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
        clearRH.setOnAction(event -> {
            RepairController repairController=new RepairController();
            repairController.clearRepairHis();
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"清空成功");
        });
    }

    /**
     * 初始化客户信息模块
     */
    private void initializeCustomerModule(){
        CustomerController customerController=new CustomerController();
        ctcName.setCellValueFactory(c->c.getValue().nameProperty());
        ctcCarNo.setCellValueFactory(c->c.getValue().carNoProperty());
        ctcMoblie.setCellValueFactory(c->c.getValue().moblieProperty());
        ctcManInsurance.setCellValueFactory(c->c.getValue().manInsuranceProperty());
        ctcBusInsurance.setCellValueFactory(c->c.getValue().busInsuranceProperty());
        ctcInsuranceStartDate.setCellValueFactory(c->c.getValue().insuranceStartDateProperty());
        ctcInsuranceEndDate.setCellValueFactory(c->c.getValue().insuranceEndDateProperty());
        ctcCarName.setCellValueFactory(c->c.getValue().carNameProperty());
        ctcDriveNo.setCellValueFactory(c->c.getValue().driveNoProperty());
        ctcCheckDate.setCellValueFactory(c->c.getValue().checkDateProperty());
        ctcSelect.setCellValueFactory(c->c.getValue().selectProperty());
        ctcSelect.setCellFactory(param -> {
            return new CheckBoxTableCell<CustomerBind,Boolean>();
        });
        ctAdd.setOnAction(event1 -> {
            customerController.addCustomer(ctName.getText().trim(),ctCarNo.getText().trim(),ctMobile.getText().trim(),
                    ctManInsurance.getText().trim(),ctBusInsurance.getText().trim(),ctInsuranceStartDate.getValue().toEpochDay()*24*3600*1000,
                    ctInsuranceEndDate.getValue().toEpochDay()*24*3600*1000,ctCar.getText().trim(),ctDriveNo.getText().trim(),ctCheckDate.getValue().toEpochDay()*24*3600*1000);
            ctTable.setItems(customerController.getCustomerObservableList());
        });
        ctClear.setOnAction(event1 -> {
            this.clearCustomerField();
        });
        ctquery.setOnAction(event -> {
            customerController.queryCustomer(ctqName.getText(),ctqCarNo.getText());
            ctTable.setItems(customerController.getCustomerObservableList());
        });
        ctDelete.setOnAction(event -> {
            StringBuilder id=new StringBuilder();
            ObservableList<CustomerBind> items = ctTable.getItems();
            for (CustomerBind cb:items
                 ) {
                if(cb.getSelect()){
                    id.append(cb.getId()).append(",");
                }
            }
            if(id.length()>0){
                Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"确定删除选中用户吗",ButtonType.OK);
                alert.showAndWait().ifPresent(r->{
                    if (r==ButtonType.OK){
                        customerController.deleteCustomer(ctqName.getText(),ctqCarNo.getText(),id.substring(0,id.length()-1));
                        ctTable.setItems(customerController.getCustomerObservableList());
                    }
                });
            }else {
                Alert alert=new Alert(Alert.AlertType.INFORMATION,"请选择至少一个用户",ButtonType.OK);
                alert.show();
            }
        });
        ctTable.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> {
            if(newValue!=null){
                ctName.setText(newValue.getName());
                ctCarNo.setText(newValue.getCarNo());
                ctMobile.setText(newValue.getMoblie());
                ctManInsurance.setText(newValue.getManInsurance());
                ctBusInsurance.setText(newValue.getBusInsurance());
                ctCar.setText(newValue.getCarName());
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
        cdtSelect.setCellFactory(param->{return new CheckBoxTableCell<CarDetailsBind,Boolean>();});
        cdtSelect.setCellValueFactory(c->c.getValue().selectProperty());
        cdtDepartName.setCellValueFactory(c->c.getValue().departNameProperty());
        cdtPrice.setCellValueFactory(c->c.getValue().priceProperty());
        cdtProvider.setCellValueFactory(c->c.getValue().providerProperty());
        cdtId.setCellValueFactory(c->c.getValue().idProperty());
        carAdd.setOnAction(event -> {
            if(!carDepart.getText().trim().equals("")){
                CarController carController=new CarController();
                carController.addDetails(carDepart.getText(),carPrice.getText().trim().equals("")?"0":carPrice.getText().trim(),carProvider.getText());
                carDetailsTable.setItems(carController.getCarDetailsObservableList());
            }
        });
        detailDelete.setOnAction(event1 -> {
            StringBuilder sb=new StringBuilder();
            carDetailsTable.getItems().forEach(carDetailsBind -> {
                if(carDetailsBind.getSelect()){
                    sb.append(carDetailsBind.getId()).append(",");
                }
            });
            if(sb.length()>0){
                Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"确定删除已选配件吗");
                alert.showAndWait().ifPresent(buttonType -> {
                    if (buttonType.equals(ButtonType.OK)){
                        CarController carController=new CarController();
                        carController.deleteCarDetails(sb.substring(0,sb.length()-1));
                        carDetailsTable.setItems(carController.getCarDetailsObservableList());
                    }
                });
            }else{
                Alert alert=new Alert(Alert.AlertType.WARNING,"请选择要删除的配件");
                alert.show();
            }
        });

        carQuery.setOnAction(event -> {
            CarController carController=new CarController();
            carController.queryDetailByName(carQueryName.getText().trim());
            carDetailsTable.setItems(carController.getCarDetailsObservableList());
        });
        

    }

    /**
     * 初始化维修记录模块
     */
    private void initializeRepairModule(){
        RepairController repairController=new RepairController();
        rcDepartName.setCellValueFactory(c->c.getValue().departNameProperty());
        rcProvider.setCellValueFactory(c->c.getValue().providerProperty());
        rcProvider.setCellFactory(TextFieldTableCell.forTableColumn());
        rcPrice.setCellFactory(TextFieldTableCell.forTableColumn());
        rcPrice.setCellValueFactory(c->c.getValue().priceProperty());
        rcSelect.setCellValueFactory(c->c.getValue().selectProperty());
        rbcSelect.setCellFactory(param->{return new CheckBoxTableCell<RepairHistoryBind,Boolean>();});
        rbcSelect.setCellValueFactory(c->c.getValue().selectProperty());

        rcCustomer.setCellValueFactory(c->c.getValue().customerProperty());
        rcTotalPrice.setCellValueFactory(c->c.getValue().priceProperty());
        rcRemark.setCellValueFactory(c->c.getValue().remarkProperty());
        rbcId.setCellValueFactory(c->c.getValue().idProperty());
        rcCarNo.setCellValueFactory(c->c.getValue().carNoProperty());
        rcCarName.setCellValueFactory(c->c.getValue().carNameProperty());
        rcCreatetime.setCellValueFactory(c->c.getValue().createTimeProperty());

        rdcDepartName.setCellValueFactory(c->c.getValue().departNameProperty());
        rdcProvider.setCellValueFactory(c->c.getValue().providerProperty());
        rdcPrice.setCellValueFactory(c->c.getValue().priceProperty());


        rName.getSelectionModel().selectedItemProperty().addListener(((observable2, oldValue2, newValue2) -> {
            if(newValue2!=null){
                Customer customer = repairController.initializeCarNoComobox(rCarNo, newValue2.toString().trim());
                if(customer!=null){
                    rCarNo.setValue(customer.getCarNo());
                    rCarName.setText(customer.getCarName());
                }
            }
        }));
        rCarNo.getSelectionModel().selectedItemProperty().addListener(((observable2, oldValue2, newValue2) -> {
            if(newValue2!=null&&!newValue2.equals("")){
                Customer customer = repairController.findCustomerByCarNo(newValue2.toString().trim());
                rCarName.setText(customer.getCarName());
            }
        }));
        rcSelect.setCellFactory(param -> {
            return new CheckBoxTableCell<CarDetailsBind, Boolean>();
        });
        /*rCarName.getSelectionModel().selectedItemProperty().addListener(((observable1, oldValue1, newValue1) -> {
            if(newValue1!=null&&!newValue1.toString().equals("")){
                repairController.findCarDetailsByCarName(newValue1.toString());
                rDetailsTable.setItems(repairController.getCarDetailsObservableList());
            }
        }));*/
        radd.setOnAction(event -> {
            List<CarDetails> details=new ArrayList<CarDetails>();
            Double totalPrice=0.0;
            for (CarDetailsBind c:rDetailsTable.getItems()
                    ) {
                if(c.getSelect()){
                    Double price=Double.valueOf(c.getPrice());
                    totalPrice+=price;
                    CarDetails cd=new CarDetails(c.getProvider(),c.getDepartName(),price,0);
                    details.add(cd);
                }
            }
            repairController.addRepair(rName.getValue().toString().trim(),rCarNo.getValue().toString().trim(),rCarName.getText().trim(),totalPrice,rRemark.getText().trim(),details);
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"添加成功");
            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    clearRepairField();
                }
            });
        });
        rQuery.setOnAction(event -> {
            repairController.findRepairs(rqCusName.getText().trim(),rqCarNo.getText().trim());
            rRepairTable.setItems(repairController.getRepairObservableList());
        });
        rDelete.setOnAction(event -> {
            StringBuilder sb=new StringBuilder();
            rRepairTable.getItems().forEach(repairHistoryBind -> {
                if(repairHistoryBind.getSelect()){
                    sb.append(repairHistoryBind.getId()).append(",");
                }
            });
            if(sb.length()>0){
                Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"确定删除已选配件吗");
                alert.showAndWait().ifPresent(buttonType -> {
                    if (buttonType.equals(ButtonType.OK)){
                        repairController.deleteHis(rqCusName.getText().trim(),rqCarNo.getText().trim(),sb.substring(0,sb.length()-1));
                        rRepairTable.setItems(repairController.getRepairObservableList());
                    }
                });
            }else{
                Alert alert=new Alert(Alert.AlertType.WARNING,"请选择要删除的配件");
                alert.show();
            }
        });
        rRepairTable.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> {
            if(newValue!=null){
                repairController.findRepairDetails(Long.valueOf(newValue.getId()));
                rRepairDetailsTable.setItems(repairController.getRepairDetailObservableList());
            }
        }));
    }

    /**
     * 初始化保险提醒模块
     */
    private void initializeNeedInsuranceModule(){
        cniName.setCellValueFactory(c->c.getValue().nameProperty());
        cniCarNo.setCellValueFactory(c->c.getValue().carNoProperty());
        cniMoblie.setCellValueFactory(c->c.getValue().moblieProperty());
        cniManInsurance.setCellValueFactory(c->c.getValue().manInsuranceProperty());
        cniBusInsurance.setCellValueFactory(c->c.getValue().busInsuranceProperty());
        cniInsuranceStartDate.setCellValueFactory(c->c.getValue().insuranceStartDateProperty());
        cniInsuranceEndDate.setCellValueFactory(c->c.getValue().insuranceEndDateProperty());
        cniCarName.setCellValueFactory(c->c.getValue().carNameProperty());
        cniDriveNo.setCellValueFactory(c->c.getValue().driveNoProperty());
        cniCheckDate.setCellValueFactory(c->c.getValue().checkDateProperty());
    }

    /**
     * 初始化车检提醒模块
     */
    private void initializeNeedCheckModule(){
        cncName.setCellValueFactory(c->c.getValue().nameProperty());
        cncCarNo.setCellValueFactory(c->c.getValue().carNoProperty());
        cncMoblie.setCellValueFactory(c->c.getValue().moblieProperty());
        cncManInsurance.setCellValueFactory(c->c.getValue().manInsuranceProperty());
        cncBusInsurance.setCellValueFactory(c->c.getValue().busInsuranceProperty());
        cncInsuranceStartDate.setCellValueFactory(c->c.getValue().insuranceStartDateProperty());
        cncInsuranceEndDate.setCellValueFactory(c->c.getValue().insuranceEndDateProperty());
        cncCarName.setCellValueFactory(c->c.getValue().carNameProperty());
        cncDriveNo.setCellValueFactory(c->c.getValue().driveNoProperty());
        cncCheckDate.setCellValueFactory(c->c.getValue().checkDateProperty());
    }

    private void clearCustomerField(){
        CustomerController customerController=new CustomerController();
        customerController.isEdit=0;
        ctName.clear();
        ctCarNo.clear();
        ctMobile.clear();
        ctManInsurance.clear();
        ctBusInsurance.clear();
        ctInsuranceStartDate.setValue(null);
        ctInsuranceEndDate.setValue(null);
        ctDriveNo.clear();
        ctCheckDate.setValue(null);
        ctCar.clear();
        ctqCarNo.clear();
        ctqName.clear();
        ctTable.getItems().clear();
    }
    private void clearCarField(){
        CarController carController=new CarController();
        carDepart.clear();
        carPrice.clear();
        carProvider.clear();
        carQueryName.clear();
        carDetailsTable.getItems().clear();

    }
    private void clearRepairField(){
        CustomerController customerController=new CustomerController();
        RepairController repairController=new RepairController();
        rCarNo.getItems().clear();
        rCarNo.setValue("");
        repairController.initializeCustomerComobox(rName);
        rCarName.clear();
        rRemark.clear();
        rDetailsTable.getItems().clear();
        repairController.findCarDetailsByCarName();
        rDetailsTable.setItems(repairController.getCarDetailsObservableList());
    }
}

