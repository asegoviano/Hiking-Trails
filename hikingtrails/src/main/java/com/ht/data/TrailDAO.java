package com.ht.data;

import java.util.List;

import com.ht.data.entity.TrailEntity;
import com.ht.data.repository.TrailRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class TrailDAO implements TrailDAOInterface<TrailEntity> {

    @Autowired
    TrailRepository trailRepository;

    public List<TrailEntity> findAll() {
        return trailRepository.findAll();
    }
}
