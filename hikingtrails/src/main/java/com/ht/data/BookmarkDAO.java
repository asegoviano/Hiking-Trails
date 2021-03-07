package com.ht.data;

/**
 * Angel Segoviano 
 * 2/20/2021
 * BookmarkDAO 
 * Bookmark DAO that connects to the database and implements the BookmarkDAOInterface
 */

import java.util.List;

import com.ht.data.entity.BookmarkEntity;
import com.ht.data.repository.BookmarkRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class BookmarkDAO implements BookmarkDAOInterface<BookmarkEntity> {

    // variable for the bookmarkRepository to call the rest service
    @Autowired
    BookmarkRepository bookmarkRepository;

    /**
     * adds the bookmarkEntity to database
     * 
     * @param bookmark
     * @return bookmark Entity
     */
    @Override
    public BookmarkEntity create(BookmarkEntity bookmark) {
        return bookmarkRepository.save(bookmark);
    }

    /**
     * gets all instance of BookmarkEntity from the database
     * 
     * @return list of BookmarkEntity
     */
    @Override
    public List<BookmarkEntity> findAll() {
        return bookmarkRepository.findAll();

    }

    /**
     * gets all instance of Bookmarks by user id
     * 
     * @return list of bookmarkEntity
     */
    @Override
    public List<BookmarkEntity> findUserBookmark() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * finds the bookmarkEnttiy in the database by id
     * 
     * @param id
     * @return bookmarkEntity
     */
    @Override
    public BookmarkEntity findById(String id) {
        return bookmarkRepository.findByID(id);
    }

    /**
     * removes the bookmarkEntity from the database by ID
     * 
     * @param id
     */
    @Override
    public boolean delete(String id) {
        bookmarkRepository.deleteById(id);
        return true;
    }
}
