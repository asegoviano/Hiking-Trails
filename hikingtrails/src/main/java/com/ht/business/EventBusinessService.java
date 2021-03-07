package com.ht.business;

import java.util.ArrayList;

/**
 * Angel Segoviano 
 * 2/20/2021
 * EventBusinessService 
 * 
 */

import java.util.List;

import com.ht.data.EventDAOInterface;
import com.ht.data.entity.EventEntity;
import com.ht.model.Event;

import org.springframework.beans.factory.annotation.Autowired;

public class EventBusinessService implements EventBusinessInterface {

    @Autowired
    EventDAOInterface<EventEntity> service;

    @Override
    public Event addEvent(Event event) {
        EventEntity entity = new EventEntity(event.getId(), event.getTrail(), event.getUser(), event.getUserDistance(),
                event.getUserDescription());
        
        EventEntity newEntity = service.create(entity);
      
        Event eventEntity = new Event(newEntity.getId(), newEntity.getTrail(), newEntity.getUser(),
                newEntity.getUserDistance(), newEntity.getUserDescription());
        return eventEntity;
    }

    @Override
    public List<Event> getAllEvents() {
        List<EventEntity> eventEntity = service.findAll();
        List<Event> eventDomain = new ArrayList<Event>();
        for (EventEntity entity : eventEntity) {
            eventDomain.add(new Event(entity.getId(), entity.getTrail(), entity.getUser(), entity.getUserDistance(),
                    entity.getUserDescription()));
        }
        return eventDomain;
    }

    @Override
    public List<Event> getUserEvents(Event event) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Event findById(String id) {
        EventEntity event = service.findById(id);
        Event eventEntity = new Event(event.getId(), event.getTrail(), event.getUser(), event.getUserDistance(),
                event.getUserDescription());
               
        return eventEntity;
    }

    @Override
    public boolean editEvent(Event event) {
 
        EventEntity eventEntity = new EventEntity(event.getId(), event.getTrail(), event.getUser(),
                event.getUserDistance(), event.getUserDescription());
        service.create(eventEntity);
        return true;
    }

    @Override
    public boolean removeEvent(String id) {
        return service.delete(id);
    }

}
