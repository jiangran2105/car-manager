package com.jr.services;

import com.jr.dao.BaseDao;
import com.jr.model.Car;
import com.jr.model.CarDetails;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by jiangran on 16-2-5.
 */
public class CarMsgService  {

    public Long insertCar(Car car){
        String sql1="insert into car(id,carName) values(null,:carName);";
        String sql2="select max(id) from car;";
        SqlParameterSource namedParameters = new MapSqlParameterSource("carName", car.getName());
        BaseDao baseDao=new BaseDao();
        baseDao.executeUpdate(sql1,namedParameters);
        Long carId=baseDao.executeQueryOne(sql2,new MapSqlParameterSource(),Long.TYPE);
        return carId;
    }
    public void insertCarDetails(CarDetails carDetails){
        String sql="insert into car_details(id,carId,departName,price,provider) values (null,:carId,:departName,:price,:provider)";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("carId",carDetails.getCarId());
        namedParameters.addValue("departName",carDetails.getName());
        namedParameters.addValue("price",carDetails.getPrice());
        namedParameters.addValue("provider",carDetails.getProvider());
        BaseDao baseDao=new BaseDao();
        baseDao.executeUpdate(sql,namedParameters);
    }
    public Long carIsExist(String carName){
        String sql="select id from car where carName=:carName limit 1";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource("carName",carName);
        BaseDao baseDao=new BaseDao();
        Long carId=baseDao.executeQueryOne(sql,namedParameters,Long.TYPE);
        return carId;
    }
    public Long addRecord(String carName,String departName,double price,String provider){
        Long carId=carIsExist(carName);
        if(carId!=null){
            CarDetails details=new CarDetails(carId,provider,departName,price);
            this.insertCarDetails(details);
        }else {
            Car car=new Car(0,carName);
            carId=this.insertCar(car);
            CarDetails details=new CarDetails(carId,provider,departName,price);
            this.insertCarDetails(details);
        }
        return carId;
    }
    public List<Car> findAllCar(String name){
        String sql="select * from car";
        if(!name.equals("")){
            sql+=" where carName like '%"+name.trim()+"%' ";
        }
        BaseDao baseDao=new BaseDao();
        List<Car> cars=baseDao.executeQuery(sql, new MapSqlParameterSource(), new RowMapper<Car>() {
            public Car mapRow(ResultSet resultSet, int i) throws SQLException {
                Car car=new Car(resultSet.getLong("id"),resultSet.getString("carName"));
                return car;
            }
        });
        return cars;
    }
    public List<CarDetails> findDetailsById(long carId){

        String sql="select * from car_details where carId=:carId";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource("carId",carId);
        BaseDao baseDao=new BaseDao();
        List<CarDetails> details=baseDao.executeQuery(sql, namedParameters, new RowMapper<CarDetails>() {
            public CarDetails mapRow(ResultSet resultSet, int i) throws SQLException {
                CarDetails details=new CarDetails(resultSet.getLong("carId"),resultSet.getString("provider")
                ,resultSet.getString("departName"),resultSet.getDouble("price"));
                return details;
            }
        });
        return details;
    }
    public List<CarDetails> findDetailsByName(String carName){

        String sql="select cd.* from car_details cd left join car c on cd.carId=c.id where c.carName=:carName";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource("carName",carName);
        BaseDao baseDao=new BaseDao();
        List<CarDetails> details=baseDao.executeQuery(sql, namedParameters, new RowMapper<CarDetails>() {
            public CarDetails mapRow(ResultSet resultSet, int i) throws SQLException {
                CarDetails details=new CarDetails(resultSet.getLong("carId"),resultSet.getString("provider")
                        ,resultSet.getString("departName"),resultSet.getDouble("price"));
                return details;
            }
        });
        return details;
    }
}
