package com.jr.services;

import com.jr.dao.BaseDao;
import com.jr.model.Customer;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by JIANGRAN on 2016/2/16.
 */
public class NotifyService {

    public List<Customer> findNotifyCustomerList(NotifyType type,Long begin,Long end){
        StringBuilder sql=new StringBuilder();
        sql.append("select * from customer where 1=1 ");
        switch (type){
            case insurance:
                sql.append(" and insuranceEndDate between :begin and :end");
                break;
            case checkDate:
                sql.append(" and checkDate between :begin and :end");
                break;
        }
        BaseDao baseDao=new BaseDao();
        MapSqlParameterSource parameterSource=new MapSqlParameterSource();
        parameterSource.addValue("begin",begin);
        parameterSource.addValue("end",end);
        List<Customer> customers = baseDao.executeQuery(sql.toString(), parameterSource, new RowMapper<Customer>() {
            @Override
            public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
                Customer customer = new Customer(resultSet.getLong("id"), resultSet.getString("userName")
                        , resultSet.getString("carNo"), resultSet.getString("mobile")
                        , resultSet.getString("manInsurance"),resultSet.getString("busInsurance"), resultSet.getLong("insuranceStartDate")
                        , resultSet.getLong("insuranceEndDate"), resultSet.getString("carName")
                        , resultSet.getString("driveNo"), resultSet.getLong("checkDate"));
                return customer;
            }
        });
        return customers;
    }
}
