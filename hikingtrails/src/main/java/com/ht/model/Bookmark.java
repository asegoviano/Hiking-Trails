package com.ht.model;

/**
 * Angel Segoviano 2/18/2021 Bookmarks model
 */
public class Bookmark {

    private String id;
    private Trail trail;
    private String user;

    /**
     * Default Contructor
     */
    public Bookmark() {
        id = "";
        this.trail = new Trail();
        this.user = "";
    }

    /**
     * Non-Default Contructor
     * 
     * @param id    string for bookmark id
     * @param trail model for trail
     * @param user  string for users ID
     */
    public Bookmark(String id, Trail trail, String user) {
        this.id = id;
        this.trail = trail;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Trail getTrail() {
        return trail;
    }

    public void setTrail(Trail trail) {
        this.trail = trail;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Bookmarks [id=" + id + ", trail=" + trail + ", user=" + user + "]";
    }

}
