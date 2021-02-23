/**
 * Angel Segoviano 
 * 12/10/2020
 * UserBusinessService
 * UserBusinessService implements the UserBusinessServiceInterface and calls the UserDAO and passes the objects that are needed.
 */
package com.ht.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ht.data.UserDAOInterface;
import com.ht.data.entity.UserEntity;
import com.ht.model.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserBusinessService implements UserBusinessServiceInterface {

    // variable for UserDAO interface and the user entity model
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
        System.out.println("==============Entering Business Service makeUser");
        // uses the user entity for the DAOInterface to call the create method and uses
        // the model for this method here
        UserEntity entity = new UserEntity(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(),
                user.getRole(), user.getStatus(), user.getUsername(), user.getPassword());
        UserEntity test = service.create(entity);
        User testUser = new User(test.getId(), test.getFirstName(), test.getLastName(), test.getEmail(), test.getRole(),
                test.getStatus(), test.getUsername(), test.getPassword());
        System.out.println("==============Leaving Business Service makeUser");
        return testUser;

    }

    /**
     * method used to validate that the user is found in the database
     * 
     * @param user taken to get the credentials
     */
    @Override
    public User verifyUser(String username, String password) {
        UserEntity userE = service.authenticate(username, password);
        User testUser = new User(userE.getId(), userE.getFirstName(), userE.getLastName(), userE.getEmail(),
                userE.getRole(), userE.getStatus(), userE.getUsername(), userE.getPassword());
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
        // calls the daointerface findall method
        List<UserEntity> userEntity = service.findAll();
        // creates an array list of the users
        List<User> userDomain = new ArrayList<User>();
        for (UserEntity entity : userEntity) {
            userDomain.add(new User(entity.getId(), entity.getFirstName(), entity.getLastName(), entity.getEmail(),
                    entity.getRole(), entity.getStatus(), entity.getUsername(), entity.getPassword()));
        }
        return userDomain;
    }

    /**
     * method for removing User
     */
    @Override
    public boolean removeUser(String id) {
        return service.delete(id);
    }

    @Override
    public Optional<UserEntity> findById(String id) {
        return service.findById(id);
    }

    @Override
    public String findbyUsername(String username) {
        return null;
    }

    /**
     * method for editing a user
     */
    @Override
    public boolean editUser(User user) {
        UserEntity userEntity = new UserEntity(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(),
                user.getRole(), user.getStatus(), user.getUsername(), user.getPassword());
        service.create(userEntity);
        return true;
    }
}
