package com.assignment.eventmanagement.demo.controller;

import com.assignment.eventmanagement.demo.repository.EventRepository;
import com.assignment.eventmanagement.demo.service.EventService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EventController.class)
public class EventControllerTests {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private EventRepository repository;

    @MockBean
    private EventService eventService;

    @Test
    @DisplayName("Should return the status 200 when making a GET call to the endpoint: /events")
    public void getAllEvents() throws Exception {
        Mockito.when(eventService.getAllEvents()).thenReturn(Collections.emptyList());
        String jsonPayload =
                """
                        {
                                "id": 1,
                                "eventName": "Coldplay Concert",
                                "date": "2022-11-23",
                                "city": "London",
                                "country": "England",
                                "guestList": [
                                    {
                                        "id": 1,
                                        "name": "Chris Martin",
                                        "city": "London"
                                    }
                                ]
                            }
                 """.trim();
        mockMvc.perform(MockMvcRequestBuilders.get("/events")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload)
                        .characterEncoding("utf-8")
                )
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("When all events are requested, they are returned")
    void allEventsRequested() throws Exception {
        mockMvc
                .perform(get("/events"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$", hasSize((int) repository.count())));

    }
}
