package com.ht;

import com.ht.business.BookmarkBusinessInterface;
import com.ht.business.BookmarkBusinessService;
import com.ht.business.EventBusinessInterface;
import com.ht.business.EventBusinessService;
import com.ht.business.TrailBusinessService;
import com.ht.business.TrailBusinessInterface;
import com.ht.business.UserBusinessService;
import com.ht.business.UserBusinessInterface;
import com.ht.data.BookmarkDAO;
import com.ht.data.BookmarkDAOInterface;
import com.ht.data.EventDAO;
import com.ht.data.EventDAOInterface;
import com.ht.data.TrailDAO;
import com.ht.data.TrailDAOInterface;
import com.ht.data.UserDAO;
import com.ht.data.UserDAOInterface;
import com.ht.data.entity.BookmarkEntity;
import com.ht.data.entity.EventEntity;
import com.ht.data.entity.TrailEntity;
import com.ht.data.entity.UserEntity;
import com.ht.model.Bookmark;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class springconfig {

    @Bean(name = "userBusinessService")
    public UserBusinessInterface getuserBusinessService() {
        return new UserBusinessService();
    }

    @Bean(name = "userDAO")
    public UserDAOInterface<UserEntity> getuserData() {
        return new UserDAO();
    }

    @Bean(name = "trailBusinessService")
    public TrailBusinessInterface gettrailBusinessService() {
        return new TrailBusinessService();
    }

    @Bean(name = "trailDAO")
    public TrailDAOInterface<TrailEntity> gettrailData() {
        return new TrailDAO();
    }

    @Bean(name = "bookmarkBusinessService")
    public BookmarkBusinessInterface<Bookmark> getBookmarkBusinessService() {
        return new BookmarkBusinessService();
    }

    @Bean(name = "bookmarkDAO")
    public BookmarkDAOInterface<BookmarkEntity> getbookmarkData() {
        return new BookmarkDAO();
    }

    @Bean(name = "eventBusinessService")
    public EventBusinessInterface getEventBusinessService() {
        return new EventBusinessService();
    }

    @Bean(name = "eventDAO")
    public EventDAOInterface<EventEntity> getEventData() {
        return new EventDAO();
    }
}
