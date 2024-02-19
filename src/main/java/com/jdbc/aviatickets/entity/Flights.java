package com.jdbc.aviatickets.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;
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
    @Column(name = "departure_location")
    private String from;
    @Column(name = "destination")
    private String to;
    private Timestamp timeOfFlight;
    private Date removeDate;
    private Integer availableSeats;
    @ManyToOne
    @JsonIgnore
    private Users users;
}
