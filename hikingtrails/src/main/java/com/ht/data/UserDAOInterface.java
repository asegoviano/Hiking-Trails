/**
 * Angel Segoviano 
 * 12/10/2020
 * UserDAOInterface
 * implemented bythe UserDAO 
 */
package com.ht.data;

import java.util.List;
import com.ht.data.entity.UserEntity;

public interface UserDAOInterface<T> {

    /**
     * used to create a new user and add into the database
     * 
     * @return user if the user was created
     */
    public UserEntity create(T t);

    /**
     * method used to return list of all users
     * 
     * @return arraylist of users
     */
    public List<UserEntity> findAll();

    /**
     * deletes a user by ID
     * 
     * @param id
     */
    public boolean delete(String id);

    /**
     * updates the user from the database
     * 
     * @param user
     * @return
     */
    public boolean updateUser(UserEntity user);

    /**
     * 
     * @param user passes the user entity to find the credentials of the user within
     *             the database
     * @return user entity to verify the user exit
     */
    public UserEntity authenticate(String username, String password);

    /**
     * get a single user by id
     * 
     * @param id
     * @return user
     */
    public UserEntity findById(String id);

}
