package com.assignment.eventmanagement.demo.repository;

import com.assignment.eventmanagement.demo.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    @Query("select e from Event e where lower(e.city) = :cityName")
    List<Event> fetchAllEventsInCity(@Param("cityName") String cityName);
}
