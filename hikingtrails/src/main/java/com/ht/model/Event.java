package com.ht.model;

/**
 * Angel Segoviano 2/18/2021 Events model
 */
public class Event {

    private String id;
    private Trail trail_id;
    private User user_id;
    private String userDistance;
    private String userDescription;

    public Event() {
        id = "";
        this.trail_id = new Trail();
        this.user_id = new User();
        userDistance = "";
        userDescription = "";
    }

    public Event(String id, Trail trail_id, User user_id, String userDistance, String userDescription) {
        this.id = id;
        this.trail_id = trail_id;
        this.user_id = user_id;
        this.userDistance = userDistance;
        this.userDescription = userDescription;
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

    public String getUserDistance() {
        return userDistance;
    }

    public void setUserDistance(String userDistance) {
        this.userDistance = userDistance;
    }

    public String getUserDescription() {
        return userDescription;
    }

    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription;
    }

    @Override
    public String toString() {
        return "Events [id=" + id + ", trail_id=" + trail_id + ", userDescription=" + userDescription
                + ", userDistance=" + userDistance + ", user_id=" + user_id + "]";
    }

}
