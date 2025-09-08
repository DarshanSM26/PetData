package com.Group3tatastrive.VetPawtner.Service;

import com.Group3tatastrive.VetPawtner.Entity.Event;
import com.Group3tatastrive.VetPawtner.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    EventRepository eventRepository;
    public List<Event> GetAllEvents() {
        return eventRepository.findAll();

    }

    public Event insertEvent(Event event) {
        return eventRepository.save(event);

    }

    public Event modifyEvent(int id, Event event) {
        Event event1= eventRepository.findById(id).orElse(null);
        event1.setEvent_name(event.getEvent_name());
        event1.setDate(event.getDate());
        event1.setLocation(event.getLocation());
        return eventRepository.save(event1);
    }

    public Event deleteEvent(int id) {
        Event event1 = eventRepository.findById(id).orElse(null);
        if(event1 != null)
        {
            eventRepository.delete(event1);
        }
        return event1;
    }
}

