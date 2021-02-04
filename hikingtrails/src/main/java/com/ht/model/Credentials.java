/**
 * Angel Segoviano 
 * 12/10/2020
 * Credentials model
 * Description----------------------
 */
package com.ht.model;

public class Credentials {

    private String username;
    private String password;

    /**
     * Default Constructor
     */
    public Credentials() {
        username = "";
        password = "";
    }

    /**
     * Non-Default Constructor
     * 
     * @param username string for users username
     * @param password string for users password
     */
    public Credentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * 
     * @return
     */
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
