package com.myopttest.opttest.dao;

import com.myopttest.opttest.domain.OptLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface OptLogDao {

    OptLog findById(int id);
    List<OptLog> findAll();
    void addLog(OptLog optLog);
    List<OptLog> findByKind(@Param("value") Map<String,Object> value);
    List<OptLog> findByTime(@Param("value") Map<String,Object> value);
    List<OptLog> findByKindAndTime(@Param("value") Map<String,Object> value);

}
