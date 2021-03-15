package com.ht.data;

/**
 * Angel Segoviano 
 * 2/20/2021
 * EventkDAO 
 * Event DAO that connects to the database and implements the EventDAOInterface
 */

import java.util.List;

import com.ht.data.entity.EventEntity;
import com.ht.data.repository.EventRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class EventDAO implements EventDAOInterface<EventEntity> {

    // variable for the bookmarkRepository to call the rest service
    @Autowired
    EventRepository eventRepository;

    /**
     * adds the eventEntity to database
     * 
     * @param bookmark
     * @return eventEntity
     */
    @Override
    public EventEntity create(EventEntity event) {
        return eventRepository.save(event);
    }

    /**
     * gets all instance of eventEntity from the database
     * 
     * @return list of eventEntity
     */
    @Override
    public List<EventEntity> findAll() {
        return eventRepository.findAll();
    }

    /**
     * gets all instance of eventEntity by user id
     * 
     * @return list of eventEntity
     */
    @Override
    public List<EventEntity> findAllByUserId(String id) {
        return eventRepository.findAllByUserId(id);
    }

    /**
     * finds the eventEntity in the database by id
     * 
     * @param id
     * @return eventEntity
     */
    @Override
    public EventEntity findById(String id) {
        System.out.println("ID OF EVENT: " + id);
        return eventRepository.findByID(id);
    }

    /**
     * edits a EventEntity from the database
     * 
     * @param event
     * @return eventEntity
     */
    @Override
    public boolean updateEvent(EventEntity event) {
        eventRepository.save(event);
        return true;
    }

    /**
     * removes the eventEntity from the database by ID
     * 
     * @param id
     */
    @Override
    public boolean delete(String id) {
        eventRepository.deleteById(id);
        return true;
    }

}
