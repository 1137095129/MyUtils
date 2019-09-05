package com.thhy.fixedassets.dao;

import com.thhy.fixedassets.domain.Equipment;
import com.thhy.fixedassets.domain.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentDao {

    List<Equipment> findEquipmentByCondition(Page page);

    void lendORReturn(int userId);

    List<Equipment> findEquipment(Page page);

    List<Equipment> findEquipmentByKind(Page page);

    void addNewEquipment(Equipment equipment);

    void updateStatus(int statusNo);
}
