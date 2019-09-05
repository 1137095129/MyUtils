package com.thhy.fixedassets.dao;

import com.thhy.fixedassets.domain.Equipment;
import com.thhy.fixedassets.domain.Page;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface EquipmentDao {

    List<Equipment> findEquipmentByCondition(Page page);

    void lendORReturn(int userId);

    List<Equipment> findEquipment(Page page);

    List<Equipment> findEquipmentByKind(Page page);

    void addNewEquipment(Map<String, Object> values);

    void updateStatus(int statusNo);

    Integer findLibraryCountByKindId(int kindId);

    Integer findTotalCountByKindId(int kindId);
}
