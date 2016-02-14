package com.jr.dao;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;


/**
 * Created by jiangran on 16-2-11.
 */
public class BaseDao {
    private DriverManagerDataSource dataSource;
    private  NamedParameterJdbcTemplate jdbcTemplate;
    public BaseDao(){
        dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("org.sqlite.JDBC");
        dataSource.setUrl("jdbc:sqlite:car.db");
        jdbcTemplate=new NamedParameterJdbcTemplate(dataSource);

    }
    public  void execute(List<String> batchSql){
        for (String sql:batchSql) {
            jdbcTemplate.execute(sql,null);
        }
    }
    public  void executeUpdate(String sql,SqlParameterSource param){
        jdbcTemplate.update(sql,param);
    }

    public  <T> T executeQueryOne(String sql,SqlParameterSource param,Class<T> type){
        T result= null;
        try {
            result = jdbcTemplate.queryForObject(sql,param,type);
        } catch (DataAccessException e) {
            return null;
        }
        return result;
    }
    public  <T> List<T> executeQuery(String sql,SqlParameterSource param,RowMapper<T> mapper){
        List<T> result=jdbcTemplate.query(sql,param,mapper);
        return result;
    }
}
