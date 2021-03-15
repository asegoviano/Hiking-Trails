package com.ht.data;

/**
 * Angel Segoviano 
 * 2/20/2021
 * BookmarkDAOInterface
 * 
 */

import java.util.List;
import com.ht.data.entity.BookmarkEntity;

public interface BookmarkDAOInterface<T> {

    /**
     * creates a new instance of bookmarkEntity
     * 
     * @param t
     * @return new bookmark
     */
    public BookmarkEntity create(T t);

    /**
     * gets all bookmarkEntities from database
     * 
     * @return list of BookmarkEntities
     */
    public List<BookmarkEntity> findAll();

    /**
     * gets all bookmarks by a single user
     * 
     * @return list of all bookmarks by their user id
     */
    public List<BookmarkEntity> findAllByUserId(String id);

    /**
     * get a single bookmark by id
     * 
     * @param id
     * @return bookmark
     */
    public BookmarkEntity findById(String id);

    /**
     * deletes a bookmark by id
     * 
     * @param id
     */
    public boolean delete(String id);
}
