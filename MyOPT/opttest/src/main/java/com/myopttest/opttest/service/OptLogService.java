package com.myopttest.opttest.service;

import com.myopttest.opttest.domain.OptLog;

import java.util.List;
import java.util.Map;

public interface OptLogService {
    OptLog findById(int id);
    List<OptLog> findAll();
    void addLog(OptLog optLog);
    List<OptLog> findByKind(Map<String,Object> value);
    List<OptLog> findByTime(Map<String,Object> value);
    List<OptLog> findByKindAndTime(Map<String,Object> value);
}
