/**
 * Angel Segoviano 
 * 1/31/2021
 * TrailRepository 
 * TrailRepository connects to the TrailEntity
 */
package com.ht.data.repository;

import com.ht.data.entity.TrailEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface TrailRepository extends MongoRepository<TrailEntity, String> {

    /**
     * method for finding a trail by its ID
     * 
     * @param id
     * @returns the trail specefied by the id
     */
    @Query("{ 'id' : ?0 }")
    public TrailEntity findByID(String id);
}
