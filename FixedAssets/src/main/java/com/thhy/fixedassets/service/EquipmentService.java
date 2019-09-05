package com.thhy.fixedassets.service;

import com.thhy.fixedassets.domain.Equipment;
import com.thhy.fixedassets.domain.Page;

import java.util.List;
import java.util.Map;

public interface EquipmentService {

    List<Equipment> findEquipmentByCondition(Page page);

    void lendORReturn(Integer userId);

    List<Equipment> findEquipment(Page page);

    List<Equipment> findEquipmentByKind(Page page);

    void addNewEquipment(Map<String, Object> values);

    void updateStatus(int statusNo);

}
