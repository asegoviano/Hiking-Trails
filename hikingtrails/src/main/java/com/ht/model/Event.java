package com.ht.model;

/**
 * Angel Segoviano 2/18/2021 Events model
 */
public class Event {

    private String id;
    private Trail trail;
    private String user;
    private String userDistance;
    private String userDescription;

    /**
     * Default Constructor
     */
    public Event() {
        id = "";
        this.trail = new Trail();
        this.user = "";
        userDistance = "";
        userDescription = "";
    }

    /**
     * Non-Default Constructor
     * 
     * @param id
     * @param trail
     * @param user
     * @param userDistance
     * @param userDescription
     */
    public Event(String id, Trail trail, String user, String userDistance, String userDescription) {
        this.id = id;
        this.trail = trail;
        this.user = user;
        this.userDistance = userDistance;
        this.userDescription = userDescription;
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
        return "Events [id=" + id + ", trail=" + trail + ", userDescription=" + userDescription + ", userDistance="
                + userDistance + ", user=" + user + "]";
    }

}
