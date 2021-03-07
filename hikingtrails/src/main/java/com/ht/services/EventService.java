package com.ht.services;

import java.util.ArrayList;
import java.util.List;

import com.ht.business.EventBusinessInterface;
import com.ht.data.entity.EventEntity;
import com.ht.model.Event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Angel Segoviano 2/20/2021 EventService REST Service API that communicates
 * with the React front end application to send the data from one application to
 * the other.
 */

// URI for connecting to React Application
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/eventapi")
public class EventService {

    @Autowired
    EventBusinessInterface service;

    @PostMapping("/create")
    Event newEvent(@RequestBody EventEntity event) {
        Event newevent = new Event(event.getId(), event.getTrail(), event.getUser(), event.getUserDistance(),
                event.getUserDescription());
        newevent = service.addEvent(newevent);

        return newevent;
    }

    @GetMapping("/findAll")
    List<Event> getAllEvents() {
        List<Event> event = new ArrayList<Event>();
        event = service.getAllEvents();
        return event;
    }

    @GetMapping("/findByEventId/{id}")
    Event findById(@PathVariable("id") String id) {
        return service.findById(id);
    }

    @PostMapping("/editEvent")
    Boolean editEvent(@RequestBody EventEntity event) {
        Event e = new Event(event.getId(), event.getTrail(), event.getUser(), event.getUserDistance(),
                event.getUserDescription());
        return service.editEvent(e);
    }

    @DeleteMapping("/delete/{id}")
    Boolean deleteUser(@PathVariable("id") String id) {
        return service.removeEvent(id);
    }

}
