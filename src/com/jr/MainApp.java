package com.jr;

import com.jr.util.CommonUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.*;
import java.time.LocalDate;


public class MainApp extends Application {

    Log log  = LogFactory.getLog(MainApp.class);
    @Override
    public void start(Stage primaryStage) throws Exception {
        initalDataBase();
        Parent root = FXMLLoader.load(getClass().getResource("view/car.fxml"));
        primaryStage.setTitle("客户与车辆管理");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    private void initalDataBase() {
        Connection conn = null;
        Statement stat = null;
        try {
            //连接SQLite的JDBC
            Class.forName("org.sqlite.JDBC");
            //建立一个数据库名zieckey.db的连接，如果不存在就在当前目录下创建之
            conn = DriverManager.getConnection("jdbc:sqlite:car.db");
            stat = conn.createStatement();
            stat.executeUpdate("CREATE TABLE IF NOT EXISTS car_details(id INTEGER PRIMARY KEY, departName TEXT,price REAL,provider TEXT);");
            stat.executeUpdate("CREATE TABLE IF NOT EXISTS customer(id INTEGER PRIMARY KEY, userName TEXT,carNo TEXT,mobile TEXT," +
                    "manInsurance TEXT,busInsurance TEXT,insuranceStartDate INTEGER,insuranceEndDate INTEGER,carName TEXT,driveNo TEXT,checkDate INTEGER);");
            stat.executeUpdate("CREATE TABLE IF NOT EXISTS reparation(id INTEGER PRIMARY KEY, customerName TEXT,carNo TEXT,carName TEXT,createDate INTEGER," +
                    "price REAL,remark TEXT);");
            stat.executeUpdate("CREATE TABLE IF NOT EXISTS reparation_details(id INTEGER PRIMARY KEY, reparId INTEGER,departName TEXT,price REAL,provider TEXT);");

        } catch (Exception e) {
            log.error(new CommonUtil().getTrace(e));
        } finally {
            try {
                if (stat != null) {
                    stat.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                log.error(new CommonUtil().getTrace(e));
            }
        }
    }

    public static void main(String[] args) {
        LocalDate now=LocalDate.now();
        if(now.compareTo(LocalDate.parse("2016-09-01"))<0){
            launch(args);
        }
    }
}
