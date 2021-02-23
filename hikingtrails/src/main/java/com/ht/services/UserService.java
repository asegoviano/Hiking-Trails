/**
 * Angel Segoviano 
 * 12/10/2020
 * UserService 
 * REST Service API that communicates with the React front end application to send the data from one application to the other.
 */
package com.ht.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ht.business.UserBusinessServiceInterface;
import com.ht.data.entity.UserEntity;
import com.ht.model.User;
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

    // varaible for the user business service interface
    @Autowired
    UserBusinessServiceInterface service;

    /**
     * rest service call to create a new user
     * 
     * @param user
     * @return user
     */
    @PostMapping("/create")
    UserEntity newUser(@RequestBody UserEntity user) {
        System.out.println("entering controller");
        User newuser = new User(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getRole(),
                user.getStatus(), user.getUsername(), user.getPassword());
        newuser = service.makeUser(newuser);
        System.out.println("LEAVING CONTROLER");
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
        System.out.println("testing authenticate");
        User u = service.verifyUser(user.getUsername(), user.getPassword());
        System.out.println("after authenticate");
        UserEntity user1 = new UserEntity(u.getId(), u.getFirstName(), u.getLastName(), u.getEmail(), u.getRole(),
                u.getStatus(), u.getUsername(), u.getPassword());
        if (user.getUsername().equals(user1.getUsername()) && user.getPassword().equals(user1.getPassword()))
            System.out.println("user has been authenticated");
        System.out.println("user" + user1.toString());
        return user1;
    }

    /**
     * rest service call to find all users
     * 
     * @return arraylist of all users
     */
    @GetMapping("/findAll")
    List<User> getAllUser() {
        List<User> user = new ArrayList<User>();
        user = service.getAllUser();
        return user;
    }

    /**
     * rest service call to delete a user
     * 
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    Boolean deleteUser(@PathVariable("id") String id) {
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
        User u = new User(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getRole(),
                user.getStatus(), user.getUsername(), user.getPassword());
        return service.editUser(u);
    }

    @GetMapping("/findByUserId/{id}")
    Optional<UserEntity> findById(@PathVariable("id") String id) {
        return service.findById(id);
    }
}
