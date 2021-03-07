package com.ht.data.entity;

import com.ht.model.Trail;

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

    private Trail trail;

    @Indexed(unique = true)
    private String user;

    public BookmarkEntity() {
        this.id = "";
        this.trail = new Trail();
        this.user = "";
    }

    public BookmarkEntity(String id, Trail trail, String user) {
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
        return "BookmarksEntity [id=" + id + ", trail=" + trail + ", user=" + user + "]";
    }

}
