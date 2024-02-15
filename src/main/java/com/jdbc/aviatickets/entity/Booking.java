package com.jdbc.aviatickets.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jdbc.aviatickets.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "flight_id")
    private Integer flightId;
    private Date removeDate;
    private BookingStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private Users user;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flight_id", insertable = false, updatable = false)
    private Flights flights;
}
