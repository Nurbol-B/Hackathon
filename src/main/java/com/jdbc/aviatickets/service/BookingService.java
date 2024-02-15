package com.jdbc.aviatickets.service;

import com.jdbc.aviatickets.entity.Booking;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookingService {
    public Booking bookFlight(int userId, int flightId);
    public List <Booking> getAll();
    public String deleteById(Integer id);

}
