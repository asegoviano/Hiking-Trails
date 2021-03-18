/**
 * Angel Segoviano 
 * 12/10/2020
 * UserBusinessService
 * UserBusinessService implements the UserBusinessServiceInterface and calls the UserDAO and passes the objects that are needed.
 */
package com.ht.business;

import java.util.ArrayList;
import java.util.List;
import com.ht.data.UserDAOInterface;
import com.ht.data.entity.UserEntity;
import com.ht.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class UserBusinessService implements UserBusinessInterface {

    Logger logger = LoggerFactory.getLogger(UserBusinessService.class);

    // variable for UserDAO interface and the userEntity
    @Autowired
    UserDAOInterface<UserEntity> service;

    /**
     * method called to create a user in the database
     * 
     * @param user used to pass in users information from the rest service called
     *             UserServices
     */
    @Override
    public User makeUser(User user) {
        logger.info("Entering  makerUser() in UserBusinessService");
        // uses the user entity for the DAOInterface to call the create method and uses
        UserEntity entity = new UserEntity(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(),
                user.getRole(), user.getStatus(), user.getUsername(), user.getPassword());
        UserEntity test = service.create(entity);
        User testUser = new User(test.getId(), test.getFirstName(), test.getLastName(), test.getEmail(), test.getRole(),
                test.getStatus(), test.getUsername(), test.getPassword());
        logger.info("Leaving makeuser() in UserBusinessService");
        return testUser;

    }

    /**
     * method used to validate that the user is found in the database
     * 
     * @param user taken to get the credentials
     */
    @Override
    public User verifyUser(String username, String password) {
        logger.info("Entering verifyUser() in UserBusinessService");
        UserEntity userE = service.authenticate(username, password);
        User testUser = new User(userE.getId(), userE.getFirstName(), userE.getLastName(), userE.getEmail(),
                userE.getRole(), userE.getStatus(), userE.getUsername(), userE.getPassword());
        logger.info("Leaving verifyUser() in UserBusinessService");
        return testUser;
    }

    @Override
    public boolean checkDuplicate(User user) {
        return false;
    }

    /**
     * method used to get a list of users
     * 
     * @return list of all users
     */
    @Override
    public List<User> getAllUser() {
        logger.info("Entering getAllUser() in UserBusinessService");
        // calls the daointerface findall method
        List<UserEntity> userEntity = service.findAll();
        // creates an array list of the users
        List<User> userDomain = new ArrayList<User>();
        for (UserEntity entity : userEntity) {
            userDomain.add(new User(entity.getId(), entity.getFirstName(), entity.getLastName(), entity.getEmail(),
                    entity.getRole(), entity.getStatus(), entity.getUsername(), entity.getPassword()));
        }
        logger.info("Leaving getAllUser() in UserBusinessService");
        return userDomain;
    }

    /**
     * method for removing User
     */
    @Override
    public boolean removeUser(String id) {
        return service.delete(id);
    }

    /**
     * method for finding a user by their ID
     * 
     * @param id user id
     * @return userEntity
     */
    @Override
    public User findById(String id) {
        logger.info("Entering findById() in UserBusinessService");
        UserEntity user = service.findById(id);
        User userEntity = new User(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(),
                user.getRole(), user.getStatus(), user.getUsername(), user.getPassword());
        logger.info("Leaving findById() in UserBusinessService");
        return userEntity;
    }

    @Override
    public String findbyUsername(String username) {
        return null;
    }

    /**
     * method for editing a user
     * 
     * @param user
     * @return the results of the updated user
     */
    @Override
    public boolean editUser(User user) {
        logger.info("Entering editUser() in UserBusinessService");
        UserEntity userEntity = new UserEntity(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(),
                user.getRole(), user.getStatus(), user.getUsername(), user.getPassword());
        service.create(userEntity);
        logger.info("Leaving editUser() in UserBusinessService");
        return true;
    }
}
