package com.assignment.eventmanagement.demo.controller;

import com.assignment.eventmanagement.demo.model.Guest;
import com.assignment.eventmanagement.demo.service.GuestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/events")
@Api(value = "/guest", tags = "Guest API")
public class GuestController {

    private final GuestService guestService;

    @Autowired
    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @PostMapping("/guest/{eventId}")
    @ApiOperation(value = "Add Guest to an event",
            notes = "Provide the event id and the details of the guest that you want to add")
    @ResponseStatus(HttpStatus.CREATED)
    public Guest addGuestDetailsToEvent(@RequestBody Guest guest, @PathVariable String eventId) {
        return guestService.addGuestToEvent(guest, Long.parseLong(eventId));
    }
}
