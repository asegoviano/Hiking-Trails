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

    @Autowired
    BookmarkRepository bookmarkRepository;

    @Override
    public BookmarkEntity create(BookmarkEntity bookmark) {
        return null;
    }

    @Override
    public boolean delete(String id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<BookmarkEntity> findAllBookmarks() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<BookmarkEntity> findUserBookmark() {
        // TODO Auto-generated method stub
        return null;
    }
}
