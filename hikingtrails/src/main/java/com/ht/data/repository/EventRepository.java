package com.ht.data.repository;

/**
 * Angel Segoviano 
 * 2/20/2021
 * EventRepository 
 * EventRepository connects to the EventEntity
 * 
 */

import com.ht.data.entity.EventEntity;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventRepository extends MongoRepository<EventEntity, String> {

    /**
     * method for finding a Event by its ID
     * 
     * @param id
     * @returns the event specefied by the id
     */
    @Query("{ 'id' : ?0 }")
    public EventEntity findByID(String id);
}
