package com.ht.data.repository;

import com.ht.data.entity.TrailEntity;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TrailRepository extends MongoRepository<TrailEntity, String> {

}
