package com.ht.business;

/**
 * Angel Segoviano 
 * 2/20/2021
 * EventBusinessService 
 * 
 */


import java.util.ArrayList;
import java.util.List;
import com.ht.data.EventDAOInterface;
import com.ht.data.entity.EventEntity;
import com.ht.model.Event;
import org.springframework.beans.factory.annotation.Autowired;

public class EventBusinessService implements EventBusinessInterface {

    // variable for EventDAOInterface and the EventEntity
    @Autowired
    EventDAOInterface<EventEntity> service;

    /**
     * method for adding an event
     * 
     * @param event
     * @return returns the Event created
     */
    @Override
    public Event addEvent(Event event) {
        EventEntity entity = new EventEntity(event.getId(), event.getTrail(), event.getUser(), event.getUserDistance(),
                event.getUserDescription());
        EventEntity newEntity = service.create(entity);
        Event eventEntity = new Event(newEntity.getId(), newEntity.getTrail(), newEntity.getUser(),
                newEntity.getUserDistance(), newEntity.getUserDescription());
        return eventEntity;
    }

    /**
     * method for getting a list of all Events
     * 
     * @return list of Events
     */
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

    /**
     * method for getting Events by their User ID
     */
    @Override
    public List<Event> getUserEvents(Event event) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * method for finding a Event by their ID
     * 
     * @param id event id
     * @return evenEntity
     */
    @Override
    public Event findById(String id) {
        EventEntity event = service.findById(id);
        Event eventEntity = new Event(event.getId(), event.getTrail(), event.getUser(), event.getUserDistance(),
                event.getUserDescription());

        return eventEntity;
    }

    /**
     * method for editing an event
     * 
     * @param event
     * @return the results of the updated event
     */
    @Override
    public boolean editEvent(Event event) {

        EventEntity eventEntity = new EventEntity(event.getId(), event.getTrail(), event.getUser(),
                event.getUserDistance(), event.getUserDescription());
        service.create(eventEntity);
        return true;
    }

    /**
     * removes Event from the database
     * 
     * @param id
     */
    @Override
    public boolean removeEvent(String id) {
        return service.delete(id);
    }

}
