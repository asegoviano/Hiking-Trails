/**
 * Angel Segoviano 
 * 12/10/2020
 * UserDAO
 * UserDAO that connects to the database
 */
package com.ht.data;

import java.util.ArrayList;
import java.util.List;
import com.ht.data.entity.UserEntity;
import com.ht.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDAO implements UserDAOInterface<UserEntity> {

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
        System.out.println("==============Entering userDAO create method");
        // user repository usese mongodb save to add the user to the database
        userRepository.save(user);
        System.out.println("==============Leaving userDAO create method");
        return user;

    }

    /**
     * gets an arraylist of all the users in the database
     * 
     * @return arraylist of users
     */
    @Override
    public List<UserEntity> findAll() {
        List<UserEntity> user = new ArrayList<UserEntity>();
        try {
            Iterable<UserEntity> userIterable = (Iterable<UserEntity>) userRepository.findAll();
            userIterable.forEach(user::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean delete(String id) {
        userRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean updateUser(UserEntity user) {
        userRepository.save(user);
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
    public UserEntity authenticate(String username) {
        //
        return userRepository.findbyUsername(username);
    }

    @Override
    public boolean findByID() {
        return false;
    }

}
