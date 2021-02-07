/**
 * Angel Segoviano 
 * 12/10/2020
 * User model
 */
package com.ht.model;

public class User {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String role;
    private String status;
    private String username;
    private String password;

    /**
     * Defualt constructor
     */
    public User() {
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
     * @param id        string for users's id
     * @param firstName string for users First Name
     * @param lastName  string for users Last Name
     * @param email     string for users Email
     * @param role      string for users role on website
     * @param status    string for user's account status
     * @param username  username
     * @param password  password
     */
    public User(String id, String firstName, String lastName, String email, String role, String status, String username,
            String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
        this.status = status;
        this.username = username;
        this.password = password;
    }

    /**
     * gets users id
     * 
     * @return users id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
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

    @Override
    public String toString() {
        return "User [email=" + email + ", firstName=" + firstName + ", id=" + id + ", lastName=" + lastName
                + ", password=" + password + ", role=" + role + ", status=" + status + ", username=" + username + "]";
    }

}
