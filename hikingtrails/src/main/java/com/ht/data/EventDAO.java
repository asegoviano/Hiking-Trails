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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class EventDAO implements EventDAOInterface<EventEntity> {

    Logger logger = LoggerFactory.getLogger(EventDAO.class);

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
        logger.info("Entering create() in EventDAO");
        return eventRepository.save(event);
    }

    /**
     * gets all instance of eventEntity from the database
     * 
     * @return list of eventEntity
     */
    @Override
    public List<EventEntity> findAll() {
        logger.info("Entering findAll() in EventDAO");
        return eventRepository.findAll();
    }

    /**
     * gets all instance of eventEntity by user id
     * 
     * @return list of eventEntity
     */
    @Override
    public List<EventEntity> findAllByUserId(String id) {
        logger.info("Entering findAllByUserId() in EventDAO");
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
        logger.info("Entering findById() in EventDAO");
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
        logger.info("Entering updateEvent() in EventDAO");
        eventRepository.save(event);
        logger.info("Leaving updateEvent() in EventDAO");
        return true;
    }

    /**
     * removes the eventEntity from the database by ID
     * 
     * @param id
     */
    @Override
    public boolean delete(String id) {
        logger.info("Entering delete() in EventDAO");
        eventRepository.deleteById(id);
        logger.info("Leaving delete() in EventDAO");
        return true;
    }

}
