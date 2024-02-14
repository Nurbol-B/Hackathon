package com.jdbc.aviatickets.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table
public class Flights {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String company;
    private BigDecimal price;
    private String from;
    private String to;
    private Date timeOfFlight;
    private Date removeDate;
    private Integer availableSeats;
    @ManyToOne
    private Users users;
}
