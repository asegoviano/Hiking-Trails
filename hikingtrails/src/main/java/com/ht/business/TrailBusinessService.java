/**
 * Angel Segoviano 
 * 1/31/2021
 * TrailBusienssService 
 * TrailBusinessSevice implements the TrailBusinessServiceInterface and calls the TrailDAO and passes the objects that are needed.
 */
package com.ht.business;

import java.util.ArrayList;
import java.util.List;
import com.ht.data.TrailDAOInterface;
import com.ht.data.entity.TrailEntity;
import com.ht.model.Trail;
import org.springframework.beans.factory.annotation.Autowired;

public class TrailBusinessService implements TrailBusinessServiceInterface {

    /**
     * variable for TrailDAO interface and the user entity model
     */
    @Autowired
    TrailDAOInterface<TrailEntity> service;

    /**
     * method called to get a list of trails
     * 
     * @return list of all trails
     */
    @Override
    public List<Trail> getAllTrail() {
        // calls the DAOinterface findAll method
        List<TrailEntity> trailEntity = service.findAll();
        // create an array list of the trails
        List<Trail> trailDomain = new ArrayList<Trail>();
        for (TrailEntity entity : trailEntity) {
            trailDomain.add(new Trail(entity.getId(), entity.getTrailName(), entity.getCity(), entity.getState(),
                    entity.getTrailDistance(), entity.getDescription()));
        }
        return trailDomain;
    }

    @Override
    public Trail findById(String id) {
        TrailEntity trail = service.findById(id);
        Trail trailEntity = new Trail(trail.getId(), trail.getTrailName(), trail.getCity(), trail.getState(),
                trail.getTrailDistance(), trail.getDescription());
        return trailEntity;
    }

}
