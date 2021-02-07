/**
 * Angel Segoviano 
 * 1/31/2021
 * TrailRepository 
 * TrailRepository connects to the TrailEntity
 */
package com.ht.data.repository;

import com.ht.data.entity.TrailEntity;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TrailRepository extends MongoRepository<TrailEntity, String> {

}
