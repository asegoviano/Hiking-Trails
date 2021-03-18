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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BookmarkBusinessService implements BookmarkBusinessInterface<Bookmark> {

    Logger logger = LoggerFactory.getLogger(BookmarkBusinessService.class);

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
        logger.info("Entering addBookmark() in BookmarkBusinessService");
        // using the BookmarkEntity for the BookmarkDAOInterface that calls the create
        BookmarkEntity entity = new BookmarkEntity(bookmark.getId(), bookmark.getTrail(), bookmark.getUser());
        BookmarkEntity newEntity = service.create(entity);
        // creates new enttiy in the Bookmark Database
        Bookmark bookmarkEntity = new Bookmark(newEntity.getId(), newEntity.getTrail(), newEntity.getUser());
        logger.info("Leaving addBookmark() in BookmarkBusinessService");
        return bookmarkEntity;
    }

    /**
     * method for getting a list of all bookmarks
     * 
     * @return list of Boookmarks
     */
    @Override
    public List<Bookmark> getAllBookmarks() {
        logger.info("Entering getAllBookmarks() in BookmarkBusinessService");
        // calls the findAll method from DAOInterface
        List<BookmarkEntity> bookmarkEntity = service.findAll();
        // creates an array list of the bookmarks
        List<Bookmark> bookmarkDomain = new ArrayList<Bookmark>();
        for (BookmarkEntity entity : bookmarkEntity) {
            bookmarkDomain.add(new Bookmark(entity.getId(), entity.getTrail(), entity.getUser()));
        }
        logger.info("Leaving getAllBookmarks() in BookmarkBusinessService");
        return bookmarkDomain;
    }

    /**
     * method for getting bookmarks by their User ID
     */
    @Override
    public List<Bookmark> getAllByUserId(String id) {
        logger.info("Entering getAllByUserId() in BookmarkBusinessService");
        List<BookmarkEntity> bookmarkEntity = service.findAllByUserId(id);
        List<Bookmark> bookmarkDomain = new ArrayList<Bookmark>();
        for (BookmarkEntity entity : bookmarkEntity) {
            bookmarkDomain.add(new Bookmark(entity.getId(), entity.getTrail(), entity.getUser()));
        }
        logger.info("Leaving getAllByUserId() in BookmarkBusinessService");
        return bookmarkDomain;
    }

    /**
     * method for finding a bookmark by their ID
     * 
     * @param id bookmark id
     * @return bookmarkEntity
     */
    @Override
    public Bookmark findById(String id) {
        logger.info("Entering findById() in BookmarkBusinessService");
        BookmarkEntity bookmark = service.findById(id);
        Bookmark bookmarkEntity = new Bookmark(bookmark.getId(), bookmark.getTrail(), bookmark.getUser());
        logger.info("Entering findById() in BookmarkBusinessService");
        return bookmarkEntity;
    }

    /**
     * removes Bookmark from the database
     * 
     * @param id
     */
    @Override
    public boolean removeBookmark(String id) {
        logger.info("Entering removeBookmark() in BookmarkBusinessService");
        return service.delete(id);
    }

}
