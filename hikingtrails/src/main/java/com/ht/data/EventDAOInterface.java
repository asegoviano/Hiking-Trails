package com.ht.data;

/**
 * Angel Segoviano 
 * 2/20/2021
 * BookmarkDAOInterface
 */

import java.util.List;
import com.ht.data.entity.EventEntity;

public interface EventDAOInterface<T> {

    /**
     * creates a new instance of EventEntity
     * 
     * @param t
     * @return new event
     */
    public EventEntity create(T t);

    /**
     * gets all eventEntities from database
     * 
     * @return list of EventEntities
     */
    public List<EventEntity> findAll();

    /**
     * gets all events created by a single user
     * 
     * @return list of event entities by user ID
     */
    public List<EventEntity> findUserEvent();

    /**
     * get a single event by id
     * 
     * @param id
     * @return event
     */
    public EventEntity findById(String id);

    /**
     * updates the event from the database
     * 
     * @param event
     * @return event
     */
    public boolean updateEvent(EventEntity event);

    /**
     * deletes an event by id
     * 
     * @param id
     */
    public boolean delete(String id);
}
