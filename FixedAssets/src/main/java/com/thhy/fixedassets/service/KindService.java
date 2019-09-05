package com.thhy.fixedassets.service;

import com.thhy.fixedassets.domain.Kind;

import java.util.List;

public interface KindService {

    List<Kind> findKindNameByKindId(Integer kindId);

    Kind findKindAllByKindId(int kindId);

    void addNewKind(String kindName);

}
