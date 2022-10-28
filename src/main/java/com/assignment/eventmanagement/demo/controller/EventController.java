package com.assignment.eventmanagement.demo.controller;

import com.assignment.eventmanagement.demo.model.Event;
import com.assignment.eventmanagement.demo.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Event createEvent(@RequestBody Event event) {
        return eventService.createNewEvent(event);
    }

    @GetMapping("/{eventId}")
    public Event getEventDetailsById(@PathVariable String eventId) {
        return eventService.getEventDetailsById(Long.parseLong(eventId));
    }
}
