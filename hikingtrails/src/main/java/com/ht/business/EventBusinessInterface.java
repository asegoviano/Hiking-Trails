package com.ht.business;

/**
 * Angel Segoviano 
 * 2/20/2021
 * EventBusinessInterface 
 * 
 */

import java.util.List;
import com.ht.model.Event;

public interface EventBusinessInterface {

    /**
     * @param event
     * @return true if event was added
     */
    public Event addEvent(Event event);

    /**
     * displays a list of all events
     * 
     * @returns a list of EventEntity instances
     */
    public List<Event> getAllEvents();
    
    /**
     * finds the specefied Event
     * 
     * @param id
     * @return eventEntity
     */
    public Event findById(String id);
    
    /**
     * used for display all events by a user id
     * 
     * @param bookmark
     * @return a list of eventEntity instance by user id
     */
    public List<Event> getAllByUserId(String id);

    /**
     * edits the event created by user
     * 
     * @param event
     * @return
     */
    public boolean editEvent(Event event);

    /**
     * removes en event
     * 
     * @param id
     */
    public boolean removeEvent(String id);

}
