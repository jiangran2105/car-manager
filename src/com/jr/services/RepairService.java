package com.jr.services;

import com.jr.dao.BaseDao;
import com.jr.model.CarDetails;
import com.jr.model.RepairHistory;
import com.jr.model.RepairHistoryDetail;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by jiangran on 16-2-5.
 */
public class RepairService {
    public void addRepair(String customerName, String carNo, String carName, double price, List<CarDetails> details){
        BaseDao baseDao=new BaseDao();
        String sql1="select max(id) from reparation";
        Integer repairId=baseDao.executeQueryOne(sql1,new MapSqlParameterSource(),Integer.TYPE);
        repairId=repairId!=null?repairId+1:1;

        String sql2="insert into reparation (id,customerName,carNo,carName,createDate,price) " +
                "values(:id,:customerName,:carNo,:carName,:createDate,:price)";
        MapSqlParameterSource reparationParam=new MapSqlParameterSource();
        reparationParam.addValue("id",repairId);
        reparationParam.addValue("customerName",customerName);
        reparationParam.addValue("carNo",carNo);
        reparationParam.addValue("carName",carName);
        reparationParam.addValue("createDate", System.currentTimeMillis());
        reparationParam.addValue("price",price);
        baseDao.executeUpdate(sql2,reparationParam);

        for (CarDetails cd:details
             ) {
            String sql3="insert into reparation_details(id , reparId ,departName ,price,provider ) " +
                    "values (null,:reparId ,:departName ,:price,:provider)";
            MapSqlParameterSource param=new MapSqlParameterSource();
            param.addValue("reparId",repairId);
            param.addValue("departName",cd.getName());
            param.addValue("provider",cd.getProvider());
            param.addValue("price",cd.getPrice());
            baseDao.executeUpdate(sql3,param);
        }
    }
    public List<RepairHistory> findRepairHis(){
        String sql="select * from reparation";
        BaseDao baseDao=new BaseDao();
        List<RepairHistory> repairHistories = baseDao.executeQuery(sql, new MapSqlParameterSource(), new RowMapper<RepairHistory>() {
            @Override
            public RepairHistory mapRow(ResultSet resultSet, int i) throws SQLException {
                return new RepairHistory(resultSet.getLong("id"),
                        resultSet.getString("customerName"), resultSet.getString("carNo"),
                        resultSet.getString("carName"), resultSet.getLong("createDate"),
                        resultSet.getDouble("price"), "");
            }
        });
        return repairHistories;
    }
    public List<RepairHistoryDetail> findRepairHisDetails(Long hisId){
        String sql="select * from reparation_details where reparId=:reparId";
        MapSqlParameterSource param=new MapSqlParameterSource();
        param.addValue("reparId",hisId);
        BaseDao baseDao=new BaseDao();
        List<RepairHistoryDetail> repairHisDetails = baseDao.executeQuery(sql, param, new RowMapper<RepairHistoryDetail>() {
            @Override
            public RepairHistoryDetail mapRow(ResultSet resultSet, int i) throws SQLException {
                return new RepairHistoryDetail(resultSet.getLong("id"),
                        resultSet.getLong("reparId"), resultSet.getString("departName"),
                        resultSet.getDouble("price"), resultSet.getString("provider"));
            }
        });
        return repairHisDetails;
    }
}
