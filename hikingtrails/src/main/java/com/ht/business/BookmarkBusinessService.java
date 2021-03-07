package com.ht.business;

import java.util.ArrayList;

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
        BookmarkEntity entity = new BookmarkEntity(bookmark.getId(), bookmark.getTrail(), bookmark.getUser());
        BookmarkEntity newEntity = service.create(entity);
        Bookmark bookmarkEntity = new Bookmark(newEntity.getId(), newEntity.getTrail(), newEntity.getUser());
        return bookmarkEntity;
    }

    @Override
    public List<Bookmark> getAllBookmarks() {
        List<BookmarkEntity> bookmarkEntity = service.findAll();
        List<Bookmark> bookmarkDomain = new ArrayList<Bookmark>();
        for (BookmarkEntity entity : bookmarkEntity) {
            bookmarkDomain.add(new Bookmark(entity.getId(), entity.getTrail(), entity.getUser()));
        }
        return bookmarkDomain;
    }

    @Override
    public List<Bookmark> getUserBookmark(Bookmark bookmark) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Bookmark findById(String id) {
        BookmarkEntity bookmark = service.findById(id);
        Bookmark bookmarkEntity = new Bookmark(bookmark.getId(), bookmark.getTrail(), bookmark.getUser());
        return bookmarkEntity;
    }

    @Override
    public boolean removeBookmark(String id) {
        return service.delete(id);
    }

}
