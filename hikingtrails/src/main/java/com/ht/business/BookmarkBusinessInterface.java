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

    public Bookmark addBookmark(Bookmark bookmark);

    public boolean removeBookmark(String id);

    public List<Bookmark> getAllBookmarks();

    public List<Bookmark> getUserBookmark(Bookmark bookmark);

    public Bookmark findById(String id);
}
