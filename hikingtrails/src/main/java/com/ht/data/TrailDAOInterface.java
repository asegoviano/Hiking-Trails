package com.ht.data;

import java.util.List;

import com.ht.data.entity.TrailEntity;

public interface TrailDAOInterface<T> {

    public List<TrailEntity> findAll();
}
