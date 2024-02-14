package com.jdbc.aviatickets.service;

import com.jdbc.aviatickets.entity.Booking;
import org.springframework.stereotype.Service;

@Service
public interface BookingService {
    public Booking bookFlight(int userId, int flightId);
}
