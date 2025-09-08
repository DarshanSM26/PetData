package com.Group3tatastrive.VetPawtner.Controller;


import com.Group3tatastrive.VetPawtner.Entity.Event;
import com.Group3tatastrive.VetPawtner.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("event")
@CrossOrigin(origins = "http://127.0.0.1:5500")

public class EventController {
    @Autowired
    private EventService eventService;
    @GetMapping("/fetch")
    public ResponseEntity<List<Event>> GetAllEvents()
    {
        return ResponseEntity.ok(eventService.GetAllEvents());
    }
    @PostMapping("/insertevents")
    public ResponseEntity<Event> insertEvents(@RequestBody Event event)
    {
        return ResponseEntity.ok(eventService.insertEvent(event));
    }
    @PutMapping("{id}")
    public ResponseEntity<Event> modifyEvent(@PathVariable int id,@RequestBody Event event)
    {
        return ResponseEntity.ok(eventService.modifyEvent(id,event));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Event> deleteEvent(@PathVariable int id)
    {
        return ResponseEntity.ok(eventService.deleteEvent(id));
    }
}
