package com.jr.services;

import com.jr.dao.BaseDao;
import com.jr.model.Customer;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by jiangran on 16-2-5.
 */
public class CustomerService {
    public void addCustomer(String userName,String carNo,String mobile,String manInsurance,String busInsurance,
                            Long insuranceStartDate,Long insuranceEndDate,String carname,String driveNo,Long checkDate){
        String sql="insert into customer(id,userName,carNo,mobile,manInsurance,busInsurance,insuranceStartDate,insuranceEndDate,carName,driveNo,checkDate) " +
                "values(null,:userName,:carNo,:mobile,:manInsurance,:busInsurance,:insuranceStartDate,:insuranceEndDate,:carName,:driveNo,:checkDate)";
        MapSqlParameterSource parameterSource=new MapSqlParameterSource();
        parameterSource.addValue("userName",userName);
        parameterSource.addValue("carNo",carNo);
        parameterSource.addValue("mobile",mobile);
        parameterSource.addValue("manInsurance",manInsurance);
        parameterSource.addValue("busInsurance",busInsurance);
        parameterSource.addValue("insuranceStartDate",insuranceStartDate);
        parameterSource.addValue("insuranceEndDate",insuranceEndDate);
        parameterSource.addValue("carName",carname);
        parameterSource.addValue("driveNo",driveNo);
        parameterSource.addValue("checkDate",checkDate);
        BaseDao baseDao=new BaseDao();
        baseDao.executeUpdate(sql,parameterSource);
    }
    public void updateCustomer(String userName,String carNo,String mobile,String manInsurance,String busInsurance,
                            Long insuranceStartDate,Long insuranceEndDate,String carname,String driveNo,Long checkDate,Long id){
        String sql="update customer set userName=:userName,carNo=:carNo,mobile=:mobile,manInsurance=:manInsurance," +
                "busInsurance=:busInsurance,insuranceStartDate=:insuranceStartDate,insuranceEndDate=:insuranceEndDate," +
                "carName=:carName,driveNo=:driveNo,checkDate=:checkDate " +
                " where id=:id";
        MapSqlParameterSource parameterSource=new MapSqlParameterSource();
        parameterSource.addValue("userName",userName);
        parameterSource.addValue("carNo",carNo);
        parameterSource.addValue("mobile",mobile);
        parameterSource.addValue("manInsurance",manInsurance);
        parameterSource.addValue("busInsurance",busInsurance);
        parameterSource.addValue("insuranceStartDate",insuranceStartDate);
        parameterSource.addValue("insuranceEndDate",insuranceEndDate);
        parameterSource.addValue("carName",carname);
        parameterSource.addValue("driveNo",driveNo);
        parameterSource.addValue("checkDate",checkDate);
        parameterSource.addValue("id",id);
        BaseDao baseDao=new BaseDao();
        baseDao.executeUpdate(sql,parameterSource);
    }
    public List<Customer> queryCustomer(String carNo,String name){
        String sql="select * from customer where 1=1 ";
        if(!carNo.equals("")){
            sql+=" and carNo like '%"+carNo+"%'";
        }
        if(!name.equals("")){
            sql+=" and userName like '%"+name+"%'";
        }
        sql+=" order by id desc";
        BaseDao baseDao=new BaseDao();
        List<Customer> customers=baseDao.executeQuery(sql, new MapSqlParameterSource(), new RowMapper<Customer>() {
            @Override
            public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
                Customer customer=new Customer(resultSet.getLong("id"),resultSet.getString("userName")
                        ,resultSet.getString("carNo"),resultSet.getString("mobile")
                        ,resultSet.getString("manInsurance"),resultSet.getString("busInsurance"),resultSet.getLong("insuranceStartDate")
                        ,resultSet.getLong("insuranceEndDate"),resultSet.getString("carName")
                        ,resultSet.getString("driveNo"),resultSet.getLong("checkDate"));
                return customer;
            }
        });
        return customers;
    }
    public List<Customer> queryCustomerByName(String name){
        String sql="select id,userName,carNo,mobile,manInsurance,busInsurance,insuranceStartDate,insuranceEndDate,carName,driveNo,checkDate from customer where userName='"+name+"'";
        BaseDao baseDao=new BaseDao();
        List<Customer> customers=baseDao.executeQuery(sql,new MapSqlParameterSource(), new RowMapper<Customer>() {
            @Override
            public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
                Customer customer=new Customer(resultSet.getLong("id"),resultSet.getString("userName")
                        ,resultSet.getString("carNo"),resultSet.getString("mobile")
                        ,resultSet.getString("manInsurance"),resultSet.getString("busInsurance"),resultSet.getLong("insuranceStartDate")
                        ,resultSet.getLong("insuranceEndDate"),resultSet.getString("carName")
                        ,resultSet.getString("driveNo"),resultSet.getLong("checkDate"));
                return customer;
            }
        });
        return customers;
    }
    public Customer queryCustomerByCarNo(String carNo){
        String sql="select id,userName,carNo,mobile,manInsurance,busInsurance,insuranceStartDate,insuranceEndDate,carName,driveNo,checkDate from customer where carNo='"+carNo+"'";
        BaseDao baseDao=new BaseDao();
        List<Customer> customers=baseDao.executeQuery(sql,new MapSqlParameterSource(), new RowMapper<Customer>() {
            @Override
            public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
                Customer customer=new Customer(resultSet.getLong("id"),resultSet.getString("userName")
                        ,resultSet.getString("carNo"),resultSet.getString("mobile")
                        ,resultSet.getString("manInsurance"),resultSet.getString("busInsurance"),resultSet.getLong("insuranceStartDate")
                        ,resultSet.getLong("insuranceEndDate"),resultSet.getString("carName")
                        ,resultSet.getString("driveNo"),resultSet.getLong("checkDate"));
                return customer;
            }
        });
        return customers.get(0);
    }
    public void deleteById(String id){
        String sql="delete from customer where id in("+id+")";
        BaseDao baseDao=new BaseDao();
        baseDao.executeUpdate(sql,new MapSqlParameterSource());
    }

}
