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

    @GetMapping("/{eventId}")
    @ResponseStatus(HttpStatus.OK)
    public Event getEventDetailsById(@PathVariable String eventId) {
        return eventService.getEventDetailsById(Long.parseLong(eventId));
    }

    @GetMapping("/city/{cityName}")
    public List<Event> getAllEventsByCity(@PathVariable String cityName) {
        return eventService.getAllEventsInCity(cityName.toLowerCase());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Event createEvent(@RequestBody Event event) {
        return eventService.createNewEvent(event);
    }

    @DeleteMapping("/{eventId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEventById(@PathVariable String eventId) {
        eventService.deleteEventById(Long.parseLong(eventId));
    }
}
