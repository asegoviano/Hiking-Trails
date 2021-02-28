package com.ht.model;

/**
 * Angel Segoviano 2/18/2021 Bookmarks model
 */
public class Bookmark {

    private String id;
    private Trail trail_id;
    private User user_id;

    public Bookmark() {
        id = "";
        this.trail_id = new Trail();
        this.user_id = new User();
    }

    public Bookmark(String id, Trail trailEntity, User userEntity) {
        this.id = id;
        this.trail_id = trailEntity;
        this.user_id = userEntity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Trail getTrail_id() {
        return trail_id;
    }

    public void setTrail_id(Trail trail_id) {
        this.trail_id = trail_id;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Bookmarks [id=" + id + ", trail_id=" + trail_id + ", user_id=" + user_id + "]";
    }

}
