/**
 * Angel Segoviano 
 * 1/31/2021
 * TrailDAO 
 * TrailDAO thatconnects to the database and calls the TrailDAOInterface
 */
package com.ht.data;

import java.util.List;
import com.ht.data.entity.TrailEntity;
import com.ht.data.repository.TrailRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TrailDAO implements TrailDAOInterface<TrailEntity> {

    /**
     * variable for the TrailRepository to call the rest service
     */
    @Autowired
    TrailRepository trailRepository;

    /**
     * calls the findall method from the trail business service to return a list of
     * trails
     */
    public List<TrailEntity> findAll() {
        return trailRepository.findAll();
    }

    public TrailEntity findById(String id) {
        return trailRepository.findByID(id);
    }

}
