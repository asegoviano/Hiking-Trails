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

    public BookmarkEntity create(T t);

    public List<BookmarkEntity> findAll();

    public List<BookmarkEntity> findUserBookmark();

    public boolean delete(String id);

    public BookmarkEntity findById(String id);

}
