package com.ht.data.entity;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "trail")
public class TrailEntity {

    @Indexed(unique = true)
    String id;

    @Indexed(unique = true)
    String trailName;

    @Indexed(unique = true)
    String city;

    @Indexed(unique = true)
    String state;

    @Indexed(unique = true)
    String trailDistance;

    public TrailEntity() {
        id = "";
        trailName = "";
        city = "";
        state = "";
        trailDistance = "";
    }

    public TrailEntity(String id, String trailName, String city, String state, String trailDistance) {
        this.id = id;
        this.trailName = trailName;
        this.city = city;
        this.state = state;
        this.trailDistance = trailDistance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTrailName() {
        return trailName;
    }

    public void setTrailName(String trailName) {
        this.trailName = trailName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTrailDistance() {
        return trailDistance;
    }

    public void setTrailDistance(String trailDistance) {
        this.trailDistance = trailDistance;
    }

}
