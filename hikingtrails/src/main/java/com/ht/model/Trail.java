package com.ht.model;

public class Trail {

    private String id;
    private String trailName;
    private String city;
    private String state;
    private String trailDistance;

    public Trail() {
        id = "";
        trailName = "";
        city = "";
        state = "";
        trailDistance = "";
    }

    public Trail(String id, String trailName, String city, String state, String trailDistance) {
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

    @Override
    public String toString() {
        return "Trails [city=" + city + ", id=" + id + ", state=" + state + ", trailDistance=" + trailDistance
                + ", trailName=" + trailName + "]";
    }

}
