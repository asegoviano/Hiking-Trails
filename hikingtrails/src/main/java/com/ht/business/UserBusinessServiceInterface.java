/**
 * Angel Segoviano 
 * 12/10/2020
 * UserBusinessService Interace
 * the user business interface is implemented in the user business service which calls the methods that are listed below.
 */
package com.ht.business;

import java.util.List;
import com.ht.model.User;

public interface UserBusinessServiceInterface {
    /**
     * 
     * @param user is taken for the create method
     * @return true the user if it was added into the database
     */
    public User makeUser(User user);

    /**
     * authenticates the users username and password
     * 
     * @param user takes in the users username and password and checks the database
     *             if the user exist
     * @return true if the user is found in the databases
     */
    public User authentication(String user);

    public boolean checkDuplicate(User user);

    /**
     * used to get a list of all users in the database
     * 
     * @return a list of users
     */
    public List<User> getAllUser();

    public String findById(String Id);

    public boolean removeUser(String id);

    /**
     * method used to search through the database by their username
     * 
     * @param username is taken to the users credentials
     * @return the user with the same credentials
     */
    public String findbyUsername(String username);

    public boolean editUser(User user);
}
