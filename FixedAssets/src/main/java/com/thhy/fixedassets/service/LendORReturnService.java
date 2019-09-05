package com.thhy.fixedassets.service;

import com.thhy.fixedassets.domain.LendORReturn;

import java.util.List;
import java.util.Map;

public interface LendORReturnService {

    List<LendORReturn> findLendByUserInfo(int userId);

    List<LendORReturn> findReturnByRLId(int rlId);

    List<LendORReturn> findLendAndReturnByEquipmentId(int equipmentId);

    void applyNewLendORReturn(Map<String,Object> values);

    void examineLendORReturn(Map<String,Object> values);

    void lendORReturn(Map<String,Object> values);
}
