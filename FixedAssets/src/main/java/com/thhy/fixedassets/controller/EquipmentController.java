package com.thhy.fixedassets.controller;


import com.thhy.fixedassets.dao.EquipmentDao;
import com.thhy.fixedassets.domain.Equipment;
import com.thhy.fixedassets.domain.Page;
import com.thhy.fixedassets.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/equipment")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    /**
     * 用户查询自己名下及相关设备信息（已借和已还）
     * @param page 包含分页信息、查询条件信息
     * @return
     */
    public List<Equipment> findEquipmentByCondition(Page page) {
        return equipmentService.findEquipmentByCondition(page);
    }

    /**
     * 修改设备所有人信息（设备被借走时该字段显示借走人的相关信息，否则不显示任何信息）
     * @param userId 所有人的编号，无所有人时为null
     */
    public void lendORReturn(Integer userId) {

        equipmentService.lendORReturn(userId);

    }

    /**
     *根据 设备类型、设备型号、单价区间 等条件查询
     * @param page
     * @return
     */
    public List<Equipment> findEquipment(Page page) {
        return equipmentService.findEquipment(page);
    }

    /**
     * 根据类型查询设备
     * @param page
     * @return
     */
    public List<Equipment> findEquipmentByKind(Page page) {
        return equipmentService.findEquipmentByKind(page);
    }

    /**
     * 添加新的设备信息
     * @param values
     */
    public void addNewEquipment(Map<String, Object> values) {
        equipmentService.addNewEquipment(values);
    }

    /**
     * 修改设备状态
     * @param statusNo 状态码
     */
    public void updateStatus(int statusNo) {
        equipmentService.updateStatus(statusNo);
    }
}
