package com.jr;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.*;


public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        initalDataBase();
        Parent root = FXMLLoader.load(getClass().getResource("view/car.fxml"));
        primaryStage.setTitle("Hello World");
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

            stat.executeUpdate("CREATE TABLE IF NOT EXISTS car(id INTEGER PRIMARY KEY, carName TEXT);");//创建一个表，两列
            stat.executeUpdate("CREATE TABLE IF NOT EXISTS car_details(id INTEGER PRIMARY KEY, carId INTEGER,departName TEXT,price REAL,provider TEXT);");
            stat.executeUpdate("CREATE TABLE IF NOT EXISTS customer(id INTEGER PRIMARY KEY, userName TEXT,carNo TEXT,mobile TEXT," +
                    "insurance TEXT,insuranceStartDate INTEGER,insuranceEndDate INTEGER,carName TEXT,driveNo TEXT,checkDate INTEGER);");
            stat.executeUpdate("CREATE TABLE IF NOT EXISTS reparation(id INTEGER PRIMARY KEY, customerName TEXT,carNo TEXT,carName TEXT,createDate INTEGER," +
                    "price REAL,remark TEXT);");
            stat.executeUpdate("CREATE TABLE IF NOT EXISTS reparation_details(id INTEGER PRIMARY KEY, reparId INTEGER,departName TEXT,price REAL,provider TEXT);");



            /*stat.executeUpdate( "insert into tbl1 values('ZhangSan',8000);" ); //插入数据

            stat.executeUpdate( "insert into tbl1 values('LiSi',7800);" );
            stat.executeUpdate( "insert into tbl1 values('WangWu',5800);" );
            stat.executeUpdate( "insert into tbl1 values('ZhaoLiu',9100);" );

            ResultSet rs = stat.executeQuery("select * from tbl1;"); //查询数据

            while (rs.next()) { //将查询到的数据打印出来

                System.out.print("name = " + rs.getString("name") + " "); //列属性一

                System.out.println("salary = " + rs.getString("salary")); //列属性二

            }
            rs.close();*/

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stat != null) {
                    stat.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
