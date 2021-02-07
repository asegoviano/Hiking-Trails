/**
 * Angel Segoviano 
 * 12/10/2020
 * UserRepository 
 * UserRepository connects to the UserEntity 
 */
package com.ht.data.repository;

import com.ht.data.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository extends MongoRepository<UserEntity, String> {

    /**
     * method created to find by the users username to autheticate their account
     * 
     * @param username
     * @return
     */
    @Query("{ 'username' : ?0 }")
    public UserEntity findbyUsername(String username);

    /**
     * method created to find by the users id
     * 
     * @param id
     * @return
     */
    @Query("{ 'id' : ?0 }")
    public UserEntity delete(String id);

}
