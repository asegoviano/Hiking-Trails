/**
 * Angel Segoviano 
 * 12/10/2020
 * UserDAO
 * UserDAO that connects to the database and implements the UserDAO Interface
 */
package com.ht.data;

import java.util.List;
import com.ht.data.entity.UserEntity;
import com.ht.data.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDAO implements UserDAOInterface<UserEntity> {

    Logger logger = LoggerFactory.getLogger(UserDAO.class);

    // variable for the userRepository to call the rest service
    @Autowired
    UserRepository userRepository;

    /**
     * method used to create a user
     * 
     * @param user gets the information inputted and ands it into the database
     * @return user
     */
    @Override
    public UserEntity create(UserEntity user) {
        logger.info("Entering  create() in UserDAO");
        // user repository usese mongodb save to add the user to the database
        userRepository.save(user);
        logger.info("Leaving  create() in UserDAO");
        return user;

    }

    /**
     * gets an arraylist of all the users in the database
     * 
     * @return arraylist of users
     */
    @Override
    public List<UserEntity> findAll() {
        logger.info("Entering  findAll() in UserDAO");
        return userRepository.findAll();
    }

    /**
     * method for deleting a users account called by the user business service
     */
    @Override
    public boolean delete(String id) {
        logger.info("Entering  delete() in UserDAO");
        userRepository.deleteById(id);
        logger.info("Leaving  delete() in UserDAO");
        return true;
    }

    /**
     * method for updating a users account information called by the user business
     * service
     */
    @Override
    public boolean updateUser(UserEntity user) {
        logger.info("Entering  updateUser() in UserDAO");
        userRepository.save(user);
        logger.info("Leaving updateUser() in UserDAO");
        return true;
    }

    /**
     * method use authenticate the user logging in
     * 
     * @param username is taken to verify the credentials that were entered were
     *                 found in the database
     * @return the userentity to verify the user was found
     */
    @Override
    public UserEntity authenticate(String username, String password) {
        logger.info("Entering  authenticate() in UserDAO");
        return userRepository.findByUsernameAndPassword(username, password);
    }

    /**
     * finds the userEntity by id
     * 
     * @param id user id
     * @return userEntity
     */
    @Override
    public UserEntity findById(String id) {
        logger.info("Entering  findById() in UserDAO");
        return userRepository.findByID(id);
    }

    /**
     * find the userEntity by username
     * 
     * @param userEntity
     * @return userEntity
     */
    public UserEntity findByUsername(UserEntity userEntity) {
        logger.info("Entering  findByUsername() in UserDAO");
        return userRepository.findbyUsername(userEntity.getUsername());
    }
}
