package com.ht.services;

import java.util.ArrayList;
import java.util.List;

/**
 * Angel Segoviano 
 * 2/20/2021
 * BookmarkService 
 * REST Service API that communicates with the React front end application to send the data from one application to the other.
 */

import com.ht.business.BookmarkBusinessInterface;
import com.ht.data.entity.BookmarkEntity;
import com.ht.model.Bookmark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// URI for connecting to React Application
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/bookmarkapi")
public class BookmarkService {

    // variable for BookmarkBusinessInterface
    @Autowired
    BookmarkBusinessInterface<Bookmark> service;

    /**
     * rest service call for creating a new bookmark
     * 
     * @param bookmark
     * @return new user entity
     */
    @PostMapping("/create")
    Bookmark newBookmark(@RequestBody BookmarkEntity bookmark) {
        Bookmark newBookmark = new Bookmark(bookmark.getId(), bookmark.getTrail(), bookmark.getUser());
        newBookmark = service.addBookmark(newBookmark);
        return newBookmark;
    }

    /**
     * rest service call for finding all bookmarks
     * 
     * @return list of all bookmarks
     */
    @GetMapping("/findAll")
    List<Bookmark> getAllBookmarks() {
        List<Bookmark> bookmark = new ArrayList<Bookmark>();
        bookmark = service.getAllBookmarks();
        return bookmark;
    }

    /**
     * rest service call for finding a bookmark by their id
     * 
     * @param id
     * @return bookmarkEntity
     */
    @GetMapping("/findByBookmarkId/{id}")
    Bookmark findById(@PathVariable("id") String id) {
        return service.findById(id);
    }

     /**
     * rest service call for finding all bookmarks by userID
     * 
     * @return list of all bookmarks related to the userID
     */
    @GetMapping("/findByUserId/{id}")
    List<Bookmark> getAllByUserId(@PathVariable("id") String id) {
        List<Bookmark> bookmark = new ArrayList<Bookmark>();
        bookmark = service.getAllByUserId(id);
        return bookmark;
    }

    /**
     * rest service call to delete a bookmark
     * 
     * @param id
     */
    @DeleteMapping("/delete/{id}")
    Boolean deleteBookmark(@PathVariable("id") String id) {
        return service.removeBookmark(id);
    }
}
