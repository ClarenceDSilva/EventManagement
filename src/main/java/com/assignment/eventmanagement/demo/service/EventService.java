package com.assignment.eventmanagement.demo.service;

import com.assignment.eventmanagement.demo.model.Event;
import com.assignment.eventmanagement.demo.model.WeatherDetails;

import java.util.List;

public interface EventService {

    List<Event> getAllEvents();

    Event createNewEvent(Event event);

    void deleteEventById(Long id);

    Event getEventDetailsById(Long id);

    List<Event> getAllEventsInCity(String cityName);

    Event updateEvent(Event event, Long id);

    //WeatherDetails fetchCurrentWeatherForLocation(String city);
}
