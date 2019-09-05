package com.thhy.fixedassets.service.impl;

import com.thhy.fixedassets.dao.ModelDao;
import com.thhy.fixedassets.domain.Model;
import com.thhy.fixedassets.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ModelServiceImpl implements ModelService {

    @Autowired
    private ModelDao modelDao;

    /**
     * 查询所有型号
     * @param modelId
     * @return
     */
    @Override
    public List<Model> findModelAll(Integer modelId) {
        return modelDao.findModelAll(modelId);
    }

    /**
     * 添加新型号
     * @param values
     */
    @Override
    public void addNewModel(Map<String, Object> values) {
        modelDao.addNewModel(values);
    }

    /**
     * 修改型号
     * @param values
     */
    @Override
    public void updateModelByModelId(Map<String, Object> values) {
        modelDao.updateModelByModelId(values);
    }
}
