package com.ht.data.entity;

import com.ht.model.Trail;

/**
 * Angel Segoviano 
 * 2/20/2021
 * Event Entity 
 */
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "events")
public class EventEntity {

    @Indexed(unique = true)
    String id;

    Trail trail;

    @Indexed(unique = true)
    String user;

    @Indexed(unique = true)
    String userDistance;

    @Indexed(unique = true)
    String userDescription;

    /**
     * Default Constructor
     */
    public EventEntity() {
        id = "";
        this.trail = new Trail();
        this.user = "";
        userDistance = "";
        userDescription = "";
    }

    /**
     * Non-Default Constructor
     * @param id
     * @param trail
     * @param user
     * @param userDistance
     * @param userDescription
     */
    public EventEntity(String id, Trail trail, String user, String userDistance, String userDescription) {
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
        return "EventsEntity [id=" + id + ", trail=" + trail + ", userDescription=" + userDescription
                + ", userDistance=" + userDistance + ", user=" + user + "]";
    }
}
