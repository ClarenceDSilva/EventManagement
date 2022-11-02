package com.assignment.eventmanagement.demo.controller;

import com.assignment.eventmanagement.demo.model.Event;
import com.assignment.eventmanagement.demo.service.EventService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/events")
@Api(value = "/events", tags = "Events API")
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    @ApiOperation(value = "List all the events",
    notes = "Returns a list of all the available events from the database")
    @ResponseStatus(HttpStatus.OK)
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/{eventId}")
    @ApiOperation(value = "Retrieve a specific event",
    notes = "Provide the eventId you want to retrieve")
    @ResponseStatus(HttpStatus.OK)
    public Event getEventDetailsById(@PathVariable String eventId) {
        return eventService.getEventDetailsById(Long.parseLong(eventId));
    }
    @GetMapping("/city/{cityName}")
    @ApiOperation(value = "Fetch all events in a city",
            notes = "Provide the city name for all the events in the city you want to retrieve")
    @ResponseStatus(HttpStatus.OK)
    public List<Event> getAllEventsByCity(@PathVariable String cityName) {
        return eventService.getAllEventsInCity(cityName.toLowerCase());
    }

    @PostMapping
    @ApiOperation(value = "Create a new event",
            notes = "Required fields to create an event: City Name, Country Name, Event Name and Event Date")
    @ResponseStatus(HttpStatus.CREATED)
    public Event createEvent(@RequestBody Event event) {
        return eventService.createNewEvent(event);
    }
    @DeleteMapping("/{eventId}")
    @ApiOperation(value = "Delete an existing event",
            notes = "Provide the event id of the event that you want to delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEventById(@PathVariable String eventId) {
        eventService.deleteEventById(Long.parseLong(eventId));
    }

    @PutMapping("/{eventId}")
    @ApiOperation(value = "Update an existing event",
            notes = "Provide the event id and the new details of the event that you want to update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Event updateEvent(@RequestBody Event event, @PathVariable String eventId) {
        return eventService.updateEvent(event, Long.parseLong(eventId));
    }
}
