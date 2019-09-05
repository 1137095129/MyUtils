package com.thhy.fixedassets.dao;

import com.thhy.fixedassets.domain.Model;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ModelDao {

    List<Model> findModelAll(Integer modelId);

    void addNewModel(Map<String,Object> values);

    void updateModelByModelId(Map<String,Object> values);

}
