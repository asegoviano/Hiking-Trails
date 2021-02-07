package com.ht.business;

import java.util.ArrayList;
import java.util.List;

import com.ht.data.TrailDAOInterface;
import com.ht.data.entity.TrailEntity;
import com.ht.model.Trail;
import org.springframework.beans.factory.annotation.Autowired;

public class TrailBusinessService implements TrailBusinessServiceInterface {

    @Autowired
    TrailDAOInterface<TrailEntity> service;

    @Override
    public List<Trail> getAllTrail() {
        List<TrailEntity> trailEntity = service.findAll();
        List<Trail> trailDomain = new ArrayList<Trail>();
        for (TrailEntity entity : trailEntity) {
            trailDomain.add(new Trail(entity.getId(), entity.getTrailName(), entity.getCity(), entity.getState(),
                    entity.getTrailDistance(), entity.getDescription()));
        }
        return trailDomain;
    }
}
