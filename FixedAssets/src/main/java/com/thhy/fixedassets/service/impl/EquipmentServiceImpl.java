package com.thhy.fixedassets.service.impl;

import com.thhy.fixedassets.dao.EquipmentDao;
import com.thhy.fixedassets.domain.Equipment;
import com.thhy.fixedassets.domain.Page;
import com.thhy.fixedassets.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    @Autowired
    private EquipmentDao equipmentDao;

    /**
     * 用户查询自己名下及相关设备信息（已借和已还）
     * @param page 包含分页信息、查询条件信息
     * @return
     */
    @Override
    public List<Equipment> findEquipmentByCondition(Page page) {
        return equipmentDao.findEquipmentByCondition(page);
    }

    /**
     * 修改设备所有人信息（设备被借走时该字段显示借走人的相关信息，否则不显示任何信息）
     * @param userId 所有人的编号，无所有人时为null
     */
    @Override
    @Transactional
    public void lendORReturn(Integer userId) {

        equipmentDao.lendORReturn(userId);

    }

    /**
     *根据 设备类型、设备型号、单价区间 等条件查询
     * @param page
     * @return
     */
    @Override
    public List<Equipment> findEquipment(Page page) {
        return equipmentDao.findEquipment(page);
    }

    /**
     * 根据类型查询设备
     * @param page
     * @return
     */
    @Override
    public List<Equipment> findEquipmentByKind(Page page) {
        return equipmentDao.findEquipmentByKind(page);
    }

    /**
     * 添加新的设备信息
     * @param values
     */
    @Override
    @Transactional
    public void addNewEquipment(Map<String, Object> values) {
        equipmentDao.addNewEquipment(values);
    }

    /**
     * 修改设备状态
     * @param statusNo 状态码
     */
    @Override
    @Transactional
    public void updateStatus(int statusNo) {
        equipmentDao.updateStatus(statusNo);
    }
}
