package com.ht.data.repository;

/**
 * Angel Segoviano 
 * 2/20/2021
 * BookmarkRepository 
 * BookmarkRepository connects to the BookmarkEntity
 * 
 */

import com.ht.data.entity.BookmarkEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface BookmarkRepository extends MongoRepository<BookmarkEntity, String> {

    /**
     * method for finding a Bookmark by its ID
     * 
     * @param id
     * @returns the bookmark specefied by the id
     */
    @Query("{ 'id' : ?0 }")
    public BookmarkEntity findByID(String id);
}
