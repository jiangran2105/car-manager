package com.jr.dao;
import com.jr.util.CommonUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;
import java.util.Map;


/**
 * Created by jiangran on 16-2-11.
 */
public class BaseDao {
    private DriverManagerDataSource dataSource;
    private  NamedParameterJdbcTemplate jdbcTemplate;
    Log log= LogFactory.getLog(BaseDao.class);

    public BaseDao(){
        dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("org.sqlite.JDBC");
        dataSource.setUrl("jdbc:sqlite:car.db");
        jdbcTemplate=new NamedParameterJdbcTemplate(dataSource);

    }
    public  void execute(List<String> batchSql){
        try {
            for (String sql:batchSql) {
                jdbcTemplate.update(sql,new MapSqlParameterSource());
            }
        } catch (DataAccessException e) {
            log.error(new CommonUtil().getTrace(e));
        }
    }
    public  void executeUpdate(String sql,MapSqlParameterSource param){
        try {
            jdbcTemplate.update(sql,param);
        } catch (DataAccessException e) {
            log.error(String.format("sql:%s param:%s exception:%s",sql,map2String(param.getValues()),new CommonUtil().getTrace(e)));
        }
    }

    public  <T> T executeQueryOne(String sql,MapSqlParameterSource param,Class<T> type){
        T result= null;
        try {
            result = jdbcTemplate.queryForObject(sql,param,type);
        } catch (DataAccessException e) {
            log.error(String.format("sql:%s param:%s exception:%s",sql,map2String(param.getValues()),new CommonUtil().getTrace(e)));
            return null;
        }
        return result;
    }
    public  <T> List<T> executeQuery(String sql,MapSqlParameterSource param,RowMapper<T> mapper){
        List<T> result= null;
        try {
            result = jdbcTemplate.query(sql,param,mapper);
        } catch (DataAccessException e) {
            log.error(String.format("sql:%s param:%s exception:%s",sql,map2String(param.getValues()),new CommonUtil().getTrace(e)));
        }
        return result;
    }
    private String map2String(Map<String, Object> values){
        StringBuilder p=new StringBuilder();
        for (String key:values.keySet()
                ) {
            p.append(key).append(":").append(values.get(key));
        }
        return p.toString();
    }
}
