/**
 * Angel Segoviano 
 * 12/10/2020
 * UserService 
 * REST Service API that communicates with the React front end application to send the data from one application to the other.
 */
package com.ht.services;

import java.util.ArrayList;
import java.util.List;
import com.ht.business.UserBusinessInterface;
import com.ht.data.entity.UserEntity;
import com.ht.model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// URI for connecting to React Application
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/userapi")
public class UserService {

    Logger logger = LoggerFactory.getLogger(UserService.class);

    // varaible for the user business service interface
    @Autowired
    UserBusinessInterface service;

    /**
     * rest service call to create a new user
     * 
     * @param user
     * @return user
     */
    @PostMapping("/create")
    UserEntity newUser(@RequestBody UserEntity user) {
        logger.info("Entering  newUser() in UserService");
        User newuser = new User(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getRole(),
                user.getStatus(), user.getUsername(), user.getPassword());
        newuser = service.makeUser(newuser);
        logger.info("Leaving  newUser() in UserService");
        return user;
    }

    /**
     * rest service call to authenticate a user attmepting to login.
     * 
     * @param user
     * @return user
     */
    @PostMapping("/authenticate")
    UserEntity authenticateUser(@RequestBody UserEntity user) {
        logger.info("Entering  authenticateUser() in UserService");
        User u = service.verifyUser(user.getUsername(), user.getPassword());
        UserEntity user1 = new UserEntity(u.getId(), u.getFirstName(), u.getLastName(), u.getEmail(), u.getRole(),
                u.getStatus(), u.getUsername(), u.getPassword());
        if (user.getUsername().equals(user1.getUsername()) && user.getPassword().equals(user1.getPassword()))
            System.out.println("user" + user1.toString());
        logger.info("Leaving  authenticateUser() in UserService");
        return user1;
    }

    /**
     * rest service call to find all users
     * 
     * @return list of all users
     */
    @GetMapping("/findAll")
    List<User> getAllUser() {
        logger.info("Entering  getAllUser() in UserService");
        List<User> user = new ArrayList<User>();
        user = service.getAllUser();
        logger.info("Leaving  getAllUser() in UserService");
        return user;
    }

    /**
     * rest service call to delete a user by id
     * 
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    Boolean deleteUser(@PathVariable("id") String id) {
        logger.info("Entering  deleteUser() in UserService");
        return service.removeUser(id);
    }

    /**
     * rest service call to edit a users information
     * 
     * @param user
     * @return
     */
    @PostMapping("/editUser")
    Boolean editUser(@RequestBody UserEntity user) {
        logger.info("Entering  editUser() in UserService");
        User u = new User(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getRole(),
                user.getStatus(), user.getUsername(), user.getPassword());
        logger.info("Leaving  editUser() in UserService");
        return service.editUser(u);
    }

    /**
     * rest service call to find user by id
     * 
     * @param id
     * @return
     */
    @GetMapping("/findByUserId/{id}")
    User findById(@PathVariable("id") String id) {
        logger.info("Entering  findById() in UserService");
        return service.findById(id);
    }
}
