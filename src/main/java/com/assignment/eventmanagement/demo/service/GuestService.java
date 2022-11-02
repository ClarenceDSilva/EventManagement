package com.assignment.eventmanagement.demo.service;

import com.assignment.eventmanagement.demo.model.Guest;

public interface GuestService {

    Guest addGuestToEvent(Guest guest, Long id);
}
