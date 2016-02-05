package com.jr;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view/car.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
//        testSqllite();
    }

    private void testSqllite(){
        try
        {
            //连接SQLite的JDBC

            Class.forName("org.sqlite.JDBC");

            //建立一个数据库名zieckey.db的连接，如果不存在就在当前目录下创建之

            Connection conn = DriverManager.getConnection("jdbc:sqlite:zieckey.db");

            Statement stat = conn.createStatement();

            stat.executeUpdate( "create table tbl1(name varchar(20), salary int);" );//创建一个表，两列


            stat.executeUpdate( "insert into tbl1 values('ZhangSan',8000);" ); //插入数据

            stat.executeUpdate( "insert into tbl1 values('LiSi',7800);" );
            stat.executeUpdate( "insert into tbl1 values('WangWu',5800);" );
            stat.executeUpdate( "insert into tbl1 values('ZhaoLiu',9100);" );

            ResultSet rs = stat.executeQuery("select * from tbl1;"); //查询数据

            while (rs.next()) { //将查询到的数据打印出来

                System.out.print("name = " + rs.getString("name") + " "); //列属性一

                System.out.println("salary = " + rs.getString("salary")); //列属性二

            }
            rs.close();
            conn.close(); //结束数据库的连接

        }
        catch( Exception e )
        {
            e.printStackTrace ( );
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
