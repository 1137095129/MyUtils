package com.thhy.fixedassets.service.impl;

import com.thhy.fixedassets.dao.LendORReturnDao;
import com.thhy.fixedassets.domain.LendORReturn;
import com.thhy.fixedassets.service.LendORReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LendORReturnServiceImpl implements LendORReturnService {

    @Autowired
    private LendORReturnDao lendORReturnDao;

    /**
     * 查询一个用户名下所有的已借出信息
     * @param userId
     * @return
     */
    @Override
    public List<LendORReturn> findLendByUserInfo(int userId) {
        return lendORReturnDao.findLendByUserInfo(userId);
    }

    /**
     * 查询一条已借出记录所关联的所有归还信息
     * @param rlId 已借出记录的编号
     * @return
     */
    @Override
    public List<LendORReturn> findReturnByRLId(int rlId) {
        return lendORReturnDao.findReturnByRLId(rlId);
    }

    /**
     * 查询某个设备的所有已审核并通过的借出及归还信息
     * @param equipmentId
     * @return
     */
    @Override
    public List<LendORReturn> findLendAndReturnByEquipmentId(int equipmentId) {
        return lendORReturnDao.findLendAndReturnByEquipmentId(equipmentId);
    }

    /**
     *申请借出或归还
     * @param values
     */
    @Override
    public void applyNewLendORReturn(Map<String, Object> values) {
        lendORReturnDao.applyNewLendORReturn(values);
    }

    /**
     * 审核借出或归还
     * @param values
     */
    @Override
    public void examineLendORReturn(Map<String, Object> values) {
        lendORReturnDao.examineLendORReturn(values);
    }

    /**
     * 借出或归还
     * @param values
     */
    @Override
    public void lendORReturn(Map<String, Object> values) {
        lendORReturnDao.lendORReturn(values);
    }
}
