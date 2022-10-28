package com.assignment.eventmanagement.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Entity
@Getter
@Setter
@Table(name = "EVENT")
@NoArgsConstructor
public class Event implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String eventName;

    @Temporal(TemporalType.DATE)
    @Column(name = "curr_date")
    private java.util.Date date;
    private String city;

    private String country;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "event", cascade = CascadeType.ALL)
    private Set<Guest> guestList;

    public Event(Long id, String eventName, java.util.Date date, String city, String country, Set<Guest> guestList) {
        this.id = id;
        this.eventName = eventName;
        this.date = date;
        this.city = city;
        this.country = country;
        this.guestList = guestList;
    }
}
