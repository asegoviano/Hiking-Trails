package com.ht.data;

/**
 * Angel Segoviano 
 * 2/20/2021
 * EventkDAO 
 * Event DAO that connects to the database and implements the EventDAOInterface
 */

import java.util.List;

import javax.swing.text.html.parser.Entity;

import com.ht.data.entity.EventEntity;
import com.ht.data.repository.EventRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class EventDAO implements EventDAOInterface<EventEntity> {

    @Autowired
    EventRepository eventRepository;

    @Override
    public EventEntity create(EventEntity event) {
        return eventRepository.save(event);
    }

    @Override
    public List<EventEntity> findAll() {
        return eventRepository.findAll();
    }

    @Override
    public List<EventEntity> findUserEvent() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public EventEntity findById(String id) {
        System.out.println("ID OF EVENT: " + id);
        return eventRepository.findByID(id);
    }

    @Override
    public boolean updateEvent(EventEntity event) {
        eventRepository.save(event);
        return true;
    }

    @Override
    public boolean delete(String id) {
        eventRepository.deleteById(id);
        return true;
    }

}
