package com.assignment.eventmanagement.demo.service.impl;

import com.assignment.eventmanagement.demo.exception.BadRequestException;
import com.assignment.eventmanagement.demo.model.Event;
import com.assignment.eventmanagement.demo.model.Guest;
import com.assignment.eventmanagement.demo.repository.EventRepository;
import com.assignment.eventmanagement.demo.repository.GuestRepository;
import com.assignment.eventmanagement.demo.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class GuestServiceImpl implements GuestService {
    private final EventRepository eventRepository;
    private final GuestRepository guestRepository;

    @Autowired
    public GuestServiceImpl(EventRepository eventRepository, GuestRepository guestRepository) {
        this.eventRepository = eventRepository;
        this.guestRepository = guestRepository;
    }

    @Override
    public Guest addGuestToEvent(Guest guest, Long id) {
        Optional<Event> eventOptional  = eventRepository.findById(id);
        if(eventOptional.isEmpty()) {
            throw new BadRequestException("Could not find an event you are trying to enter in");
        }else {
            guest.setEvent(eventOptional.get());
            return guestRepository.save(guest);
        }
    }
}
