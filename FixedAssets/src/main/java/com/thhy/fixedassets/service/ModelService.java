package com.thhy.fixedassets.service;

import com.thhy.fixedassets.domain.Model;

import java.util.List;
import java.util.Map;

public interface ModelService {

    List<Model> findModelAll(Integer modelId);

    void addNewModel(Map<String,Object> values);

    void updateModelByModelId(Map<String,Object> values);

}
