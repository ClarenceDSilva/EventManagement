package com.assignment.eventmanagement.demo.service.impl;

import com.assignment.eventmanagement.demo.exception.BadRequestException;
import com.assignment.eventmanagement.demo.model.Event;
import com.assignment.eventmanagement.demo.repository.EventRepository;
import com.assignment.eventmanagement.demo.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event createNewEvent(Event event) {
        if(event.getId() != null) {
            throw new BadRequestException("ID must not be provided when creating an event");
        }
        return eventRepository.save(event);
    }

    @Override
    public void deleteEventById(Long id) {
        Optional<Event> event = eventRepository.findById(id);
        if(event.isPresent()) {
            eventRepository.delete(event.get());
        }

    }

    @Override
    public Event getEventDetailsById(Long id) {
        Optional<Event> event = eventRepository.findById(id);
        if (event.isPresent()) {
            return event.get();
        }else {
            throw new BadRequestException("No event exists with the requested eventId");
        }
    }
}
