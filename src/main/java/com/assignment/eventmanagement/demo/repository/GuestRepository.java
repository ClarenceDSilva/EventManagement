package com.assignment.eventmanagement.demo.repository;

import com.assignment.eventmanagement.demo.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {
}
