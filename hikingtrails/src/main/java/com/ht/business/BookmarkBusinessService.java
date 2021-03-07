package com.ht.business;

/**
 * Angel Segoviano 
 * 2/20/2021
 * BookmarkBusinessService
 * 
 */

import java.util.ArrayList;
import java.util.List;
import com.ht.data.BookmarkDAOInterface;
import com.ht.data.entity.BookmarkEntity;
import com.ht.model.Bookmark;
import org.springframework.beans.factory.annotation.Autowired;

public class BookmarkBusinessService implements BookmarkBusinessInterface<Bookmark> {

    // variable for BookmarkDAOInterface and the BookmarkEntity
    @Autowired
    BookmarkDAOInterface<BookmarkEntity> service;

    /**
     * method for adding a bookmark to the database
     * 
     * @param bookmark
     * @return returns the bookmark created
     */
    public Bookmark addBookmark(Bookmark bookmark) {
        // using the BookmarkEntity for the BookmarkDAOInterface that calls the create
        // method from BookmarkDAO
        BookmarkEntity entity = new BookmarkEntity(bookmark.getId(), bookmark.getTrail(), bookmark.getUser());
        BookmarkEntity newEntity = service.create(entity);
        // creates new enttiy in the Bookmark Database
        Bookmark bookmarkEntity = new Bookmark(newEntity.getId(), newEntity.getTrail(), newEntity.getUser());
        return bookmarkEntity;
    }

    /**
     * method for getting a list of all bookmarks
     * 
     * @return list of Boookmarks
     */
    @Override
    public List<Bookmark> getAllBookmarks() {
        // calls the findAll method from DAOInterface
        List<BookmarkEntity> bookmarkEntity = service.findAll();
        // creates an array list of the bookmarks
        List<Bookmark> bookmarkDomain = new ArrayList<Bookmark>();
        for (BookmarkEntity entity : bookmarkEntity) {
            bookmarkDomain.add(new Bookmark(entity.getId(), entity.getTrail(), entity.getUser()));
        }
        return bookmarkDomain;
    }

    /**
     * method for getting bookmarks by their User ID
     */
    @Override
    public List<Bookmark> getUserBookmark(Bookmark bookmark) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * method for finding a bookmark by their ID
     * 
     * @param id bookmark id
     * @return bookmarkEntity
     */
    @Override
    public Bookmark findById(String id) {
        BookmarkEntity bookmark = service.findById(id);
        Bookmark bookmarkEntity = new Bookmark(bookmark.getId(), bookmark.getTrail(), bookmark.getUser());
        return bookmarkEntity;
    }

    /**
     * removes Bookmark from the database
     * 
     * @param id
     */
    @Override
    public boolean removeBookmark(String id) {
        return service.delete(id);
    }

}
