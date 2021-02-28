package com.ht.business;

/**
 * Angel Segoviano 
 * 2/20/2021
 * BookmarkBusinessService
 * 
 */

import java.util.List;
import com.ht.data.BookmarkDAOInterface;
import com.ht.data.entity.BookmarkEntity;
import com.ht.model.Bookmark;

import org.springframework.beans.factory.annotation.Autowired;

public class BookmarkBusinessService implements BookmarkBusinessInterface<Bookmark> {

    @Autowired
    BookmarkDAOInterface<BookmarkEntity> service;

    public Bookmark addBookmark(Bookmark bookmark) {
        return null;

    }

    @Override
    public boolean removeBookmark(String id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<Bookmark> getAllBookmarks() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Bookmark> getUserBookmark(Bookmark bookmark) {
        // TODO Auto-generated method stub
        return null;
    }

}
