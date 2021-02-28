package com.ht.data.entity;

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

    TrailEntity trail_id;

    UserEntity user_id;

    @Indexed(unique = true)
    String userDistance;

    @Indexed(unique = true)
    String userDescription;

    public EventEntity() {
        id = "";
        this.trail_id = new TrailEntity();
        this.user_id = new UserEntity();
        userDistance = "";
        userDescription = "";
    }

    public EventEntity(String id, TrailEntity trail_id, UserEntity user_id, String userDistance,
            String userDescription) {
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

    public TrailEntity getTrail_id() {
        return trail_id;
    }

    public void setTrail_id(TrailEntity trail_id) {
        this.trail_id = trail_id;
    }

    public UserEntity getUser_id() {
        return user_id;
    }

    public void setUser_id(UserEntity user_id) {
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
        return "EventsEntity [id=" + id + ", trail_id=" + trail_id + ", userDescription=" + userDescription
                + ", userDistance=" + userDistance + ", user_id=" + user_id + "]";
    }
}
