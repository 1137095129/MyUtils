package com.thhy.fixedassets.service.impl;

import com.thhy.fixedassets.dao.KindDao;
import com.thhy.fixedassets.domain.Kind;
import com.thhy.fixedassets.service.KindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KindServiceImpl implements KindService {

    @Autowired
    private KindDao kindDao;

    /**
     * 根据种类编号查询种类
     * @param kindId 当kindId不为空时查询全部，否则只查询一条
     * @return
     */
    @Override
    public List<Kind> findKindNameByKindId(Integer kindId) {
        return kindDao.findKindNameByKindId(kindId);
    }

    /**
     * 根据种类编号查询种类
     * @param kindId
     * @return
     */
    @Override
    public Kind findKindAllByKindId(int kindId) {
        return kindDao.findKindAllByKindId(kindId);
    }

    /**
     * 新增种类
     * @param kindName
     */
    @Override
    public void addNewKind(String kindName) {
        kindDao.addNewKind(kindName);
    }
}
