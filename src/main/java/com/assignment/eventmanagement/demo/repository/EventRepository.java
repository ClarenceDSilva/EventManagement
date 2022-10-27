package com.assignment.eventmanagement.demo.repository;

import com.assignment.eventmanagement.demo.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
