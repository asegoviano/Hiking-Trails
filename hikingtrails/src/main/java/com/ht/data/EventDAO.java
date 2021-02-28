package com.ht.data;

/**
 * Angel Segoviano 
 * 2/20/2021
 * EventkDAO 
 * Event DAO that connects to the database and implements the EventDAOInterface
 */

import java.util.List;
import com.ht.data.entity.EventEntity;

public class EventDAO implements EventDAOInterface<EventEntity> {

    @Override
    public EventEntity create(EventEntity t) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<EventEntity> findAllEvents() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<EventEntity> findUserEvent() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean updateEvent(EventEntity event) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(String id) {
        // TODO Auto-generated method stub
        return false;
    }

}
