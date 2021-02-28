package com.ht.services;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// URI for connecting to React Application
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/bookmarkapi")
public class BookmarkService {

    @Autowired
    BookmarkBusinessInterface<Bookmark> service;

    @PostMapping("/addBookmark")
    BookmarkEntity newBookmark(@RequestBody BookmarkEntity bookmark) {
        // Bookmark newBookmark = new Bookmark(bookmark.getId(), bookmark.getTrail_id(),
        // bookmark.getUser_id());
        // newBookmark = service.addBookmark(newBookmark);
        // return bookmark;
        return null;
    }
}
