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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class TrailBusinessService implements TrailBusinessInterface {

    Logger logger = LoggerFactory.getLogger(TrailBusinessService.class);

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
        logger.info("Entering getAllTrail() in TrailBusinessService");
        // calls the DAOinterface findAll method
        List<TrailEntity> trailEntity = service.findAll();
        // create an array list of the trails
        List<Trail> trailDomain = new ArrayList<Trail>();
        for (TrailEntity entity : trailEntity) {
            trailDomain.add(new Trail(entity.getId(), entity.getTrailName(), entity.getCity(), entity.getState(),
                    entity.getTrailDistance(), entity.getDescription()));
        }
        logger.info("Leaving getAllTrail() in TrailBusinessService");
        return trailDomain;
    }

    /**
     * method for finding a trail by their ID
     * 
     * @param id trail id
     * @return trailEntity
     */
    @Override
    public Trail findById(String id) {
        logger.info("Entering findById() in TrailBusinessService");
        TrailEntity trail = service.findById(id);
        Trail trailEntity = new Trail(trail.getId(), trail.getTrailName(), trail.getCity(), trail.getState(),
                trail.getTrailDistance(), trail.getDescription());
        logger.info("Leaving findById() in TrailBusinessService");
        return trailEntity;
    }
}
