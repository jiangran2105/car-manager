package com.jr.services;

import com.jr.dao.BaseDao;
import com.jr.model.CarDetails;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by jiangran on 16-2-5.
 */
public class CarMsgService  {


    public void insertCarDetails(String departName,String price,String provider){
        String sql="insert into car_details(id,departName,price,provider) values (null,:departName,:price,:provider)";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("departName",departName);
        namedParameters.addValue("price",Double.parseDouble(price));
        namedParameters.addValue("provider",provider);
        BaseDao baseDao=new BaseDao();
        baseDao.executeUpdate(sql,namedParameters);
    }
    public List<CarDetails> findDetailsById(long carId){

        String sql="select * from car_details where carId=:carId";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource("carId",carId);
        BaseDao baseDao=new BaseDao();
        List<CarDetails> details=baseDao.executeQuery(sql, namedParameters, new RowMapper<CarDetails>() {
            public CarDetails mapRow(ResultSet resultSet, int i) throws SQLException {
                CarDetails details=new CarDetails(resultSet.getString("provider")
                ,resultSet.getString("departName"),resultSet.getDouble("price"),resultSet.getLong("id"));
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
                CarDetails details=new CarDetails(resultSet.getString("provider")
                        ,resultSet.getString("departName"),resultSet.getDouble("price"),resultSet.getLong("id"));
                return details;
            }
        });
        return details;
    }
    public void deleteDetailsById(String ids){
        String sql="delete from car_details where id in("+ids+")";
        BaseDao baseDao=new BaseDao();
        baseDao.executeUpdate(sql,new MapSqlParameterSource());
    }
    public void deleteCarsById(String ids){
        String sql="delete from car where id in("+ids+");delete from car_details where carId in("+ids+")";
        BaseDao baseDao=new BaseDao();
        baseDao.executeUpdate(sql,new MapSqlParameterSource());
    }
}
