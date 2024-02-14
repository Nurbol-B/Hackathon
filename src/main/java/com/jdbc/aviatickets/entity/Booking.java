package com.jdbc.aviatickets.entity;

import com.jdbc.aviatickets.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer userId;
    private Integer flightId;
    private BookingStatus status;
}
