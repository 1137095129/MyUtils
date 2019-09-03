package com.myopttest.opttest.service.impl;

import com.myopttest.opttest.dao.OptLogDao;
import com.myopttest.opttest.domain.OptLog;
import com.myopttest.opttest.service.OptLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class OptLogServiceImpl implements OptLogService {

    @Autowired
    private OptLogDao optLogDao;

    @Override
    public OptLog findById(int id) {
        return optLogDao.findById(id);
    }

    @Override
    public List<OptLog> findAll() {
        return optLogDao.findAll();
    }

    @Override
    @Transactional
    public void addLog(OptLog optLog) {
        optLogDao.addLog(optLog);
    }

    @Override
    public List<OptLog> findByKind(Map<String, Object> value) {
        return optLogDao.findByKind(value);
    }

    @Override
    public List<OptLog> findByTime(Map<String, Object> value) {
        return optLogDao.findByTime(value);
    }

    @Override
    public List<OptLog> findByKindAndTime(Map<String, Object> value) {
        return optLogDao.findByKindAndTime(value);
    }
}
