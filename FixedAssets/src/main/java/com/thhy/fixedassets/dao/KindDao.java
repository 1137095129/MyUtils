package com.thhy.fixedassets.dao;

import com.thhy.fixedassets.domain.Kind;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KindDao {

    List<Kind> findKindNameByKindId(Integer kindId);

    Kind findKindAllByKindId(int kindId);

    void addNewKind(String kindName);

}
