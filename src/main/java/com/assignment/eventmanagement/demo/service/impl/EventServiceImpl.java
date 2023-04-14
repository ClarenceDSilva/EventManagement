package com.assignment.eventmanagement.demo.service.impl;

import com.assignment.eventmanagement.demo.exception.BadRequestException;
import com.assignment.eventmanagement.demo.exception.ResourceNotFoundException;
import com.assignment.eventmanagement.demo.model.Event;
import com.assignment.eventmanagement.demo.model.WeatherDetails;
import com.assignment.eventmanagement.demo.repository.EventRepository;
import com.assignment.eventmanagement.demo.service.EventService;
import com.assignment.eventmanagement.demo.service.externalapi.WeatherDetailsApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    private final WeatherDetailsApi weatherDetailsUtil;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository, WeatherDetailsApi weatherDetailsApi) {
        this.eventRepository = eventRepository;
        this.weatherDetailsUtil = weatherDetailsApi;
    }

    @Override
    public List<Event> getAllEvents() {
        List<Event> eventList = eventRepository.findAll();
        WeatherDetails weatherDetails;
        for(Event event : eventList) {
            weatherDetails = weatherDetailsUtil.fetchCurrentWeatherForLocation(event.getCity());
            event.setWeatherDetails(weatherDetails);
        }
        return eventList;
    }

    @Override
    public Event createNewEvent(Event event) {
        if(event.getId() != null || event.getEventName() == null || event.getCity() == null
                || event.getCountry() == null || event.getDate() == null) {
            throw new BadRequestException("Missing fields when creating an event. Required fields: Name, City, Country, Date");
        }
        return eventRepository.save(event);
    }

    @Override
    public void deleteEventById(Long id) {
        Optional<Event> event = eventRepository.findById(id);
        if(event.isPresent()) {
            eventRepository.delete(event.get());
        }else {
            throw new ResourceNotFoundException("No event exists with the requested eventId");
        }
    }

    @Override
    public Event getEventDetailsById(Long id) {
        Optional<Event> event = eventRepository.findById(id);
        if (event.isPresent()) {
            WeatherDetails weatherDetails;
            weatherDetails = weatherDetailsUtil.fetchCurrentWeatherForLocation(event.get().getCity());
            event.get().setWeatherDetails(weatherDetails);
            return event.get();
        }else {
            throw new ResourceNotFoundException("No event exists with the requested eventId");
        }
    }

    @Override
    public List<Event> getAllEventsInCity(String cityName) {
        List<Event> eventList = eventRepository.fetchAllEventsInCity(cityName);
        if(eventList.size() == 0) {
            throw new ResourceNotFoundException("No event present in this city");
        }else {
            WeatherDetails weatherDetails;
            for(Event event : eventList) {
                weatherDetails = weatherDetailsUtil.fetchCurrentWeatherForLocation(event.getCity());
                event.setWeatherDetails(weatherDetails);
            }
            return eventList;
        }
    }

    @Override
    public Event updateEvent(Event event, Long id) {
        Optional<Event> eventOptional  = eventRepository.findById(id);
        if(eventOptional.isEmpty()) {
            throw new BadRequestException("Could not find an event associated with the Id");
        }else if(event.getEventName() == null || event.getCity() == null
                || event.getCountry() == null || event.getDate() == null) {
            throw new BadRequestException("Missing fields when creating an event. Required fields: Name, City, Country, Date");
        }else {
            event.setId(id);
            return eventRepository.save(event);
        }
    }
}
