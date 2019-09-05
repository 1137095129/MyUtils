package com.thhy.fixedassets.dao;

import com.thhy.fixedassets.domain.LendORReturn;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface LendORReturnDao {

    List<LendORReturn> findLendByUserInfo(int userId);

    List<LendORReturn> findReturnByRLId(int rlId);

    List<LendORReturn> findLendAndReturnByEquipmentId(int equipmentId);

    void applyNewLendORReturn(Map<String,Object> values);

    void examineLendORReturn(Map<String,Object> values);

    void lendORReturn(Map<String,Object> values);
}
