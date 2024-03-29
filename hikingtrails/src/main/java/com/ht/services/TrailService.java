/**
 * Angel Segoviano 
 * 1/31/2021
 * TrailService 
 * REST Service API that communicates with the React front end application to send the data from one application to the other.
 */
package com.ht.services;

import java.util.ArrayList;
import java.util.List;
import com.ht.business.TrailBusinessInterface;
import com.ht.model.Trail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//URI for connecting to React Application
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/trailapi")
public class TrailService {

    Logger logger = LoggerFactory.getLogger(TrailService.class);

    /**
     * variable for the trail business service interface
     */
    @Autowired
    TrailBusinessInterface service;

    /**
     * rest service call to find all trails
     * 
     * @return arryalist of all trails
     */
    @GetMapping("/findAll")
    List<Trail> getAllTrail() {
        logger.info("Entering getAllTrail() in TrailService");
        List<Trail> trail = new ArrayList<Trail>();
        trail = service.getAllTrail();
        logger.info("Leaving getAllTrail() in TrailService");
        return trail;
    }

    /**
     * rest service call for finding trail by ID
     * 
     * @param id
     * @return results of Trail Entity
     */
    @GetMapping("/findByTrailId/{id}")
    Trail findById(@PathVariable("id") String id) {
        logger.info("Entering findById() in TrailService");
        return service.findById(id);
    }
}
