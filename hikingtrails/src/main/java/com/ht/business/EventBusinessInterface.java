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

    public Event addEvent(Event event);

    public List<Event> getAllEvents();

    public List<Event> getUserEvents(Event event);

    public Event findById(String id);

    public boolean editEvent(Event event);

    public boolean removeEvent(String id);

}
