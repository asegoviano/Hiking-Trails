package com.ht.data.entity;

/**
 * Angel Segoviano 
 * 2/20/2021
 * Bookmark Entity 
 */
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bookmarks")
public class BookmarkEntity {

    @Indexed(unique = true)
    private String id;

    private TrailEntity trail_id;

    private UserEntity user_id;

    public BookmarkEntity() {
        this.id = "";
        this.trail_id = new TrailEntity();
        this.user_id = new UserEntity();
    }

    public BookmarkEntity(String id, TrailEntity trail_id, UserEntity user_id) {
        this.id = id;
        this.trail_id = trail_id;
        this.user_id = user_id;
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

    @Override
    public String toString() {
        return "BookmarksEntity [id=" + id + ", trail_id=" + trail_id + ", user_id=" + user_id + "]";
    }

}
