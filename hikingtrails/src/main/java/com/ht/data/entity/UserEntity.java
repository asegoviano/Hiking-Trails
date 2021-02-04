/**
 * Angel Segoviano 
 * 12/10/2020
 * User entity
 * Description----------------------
 */
package com.ht.data.entity;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class UserEntity {
    @Indexed(unique = true)
    String id;

    @Indexed(unique = true)
    String firstName;

    @Indexed(unique = true)
    String lastName;

    @Indexed(unique = true)
    String email;

    @Indexed(unique = true)
    String role;

    @Indexed(unique = true)
    String status;

    @Indexed(unique = true)
    String username;

    @Indexed(unique = true)
    String password;

    // Defaul Constructor
    public UserEntity() {
        id = "";
        firstName = "";
        lastName = "";
        email = "";
        role = "";
        status = "";
        username = "";
        password = "";
    }

    /**
     * Non-Default Constructor
     * 
     * @param id
     * @param firstName
     * @param lastName
     * @param email
     * @param role
     * @param status
     * @param username
     * @param password
     */
    public UserEntity(String id, String firstName, String lastName, String email, String role, String status,
            String username, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
        this.status = status;
        this.username = username;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
