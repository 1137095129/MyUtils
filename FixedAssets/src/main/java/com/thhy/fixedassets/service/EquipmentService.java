package com.thhy.fixedassets.service;

import com.thhy.fixedassets.domain.Equipment;
import com.thhy.fixedassets.domain.Page;

import java.util.List;

public interface EquipmentService {

    List<Equipment> findEquipmentByCondition(Page page);

    void lendORReturn(int userId);

    List<Equipment> findEquipment(Page page);

    List<Equipment> findEquipmentByKind(Page page);

    void addNewEquipment(Equipment equipment);

    void updateStatus(int statusNo);

}
