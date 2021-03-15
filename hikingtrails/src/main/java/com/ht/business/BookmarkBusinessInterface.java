package com.ht.business;

/**
 * Angel Segoviano 
 * 2/20/2021
 * BookmarklBusinessInterface 
 * 
 */

import java.util.List;
import com.ht.model.Bookmark;

public interface BookmarkBusinessInterface<T> {

    /**
     * @param bookmark
     * @return true if bookmark was added
     */
    public Bookmark addBookmark(Bookmark bookmark);

    /**
     * removes a bookmark
     * 
     * @param id
     */
    public boolean removeBookmark(String id);

    /**
     * used for display all bookmarks
     * 
     * @return a list of BookmarkEntity instances
     */
    public List<Bookmark> getAllBookmarks();

    /**
     * used for display all bookmarks by a user id
     * 
     * @param bookmark
     * @return a list of BookmarkEntity instance by user id
     */
    public List<Bookmark> getAllByUserId(String id);

    /**
     * finds the specefied bookmark
     * 
     * @param id
     * @return bookmarkEntity
     */
    public Bookmark findById(String id);
}
