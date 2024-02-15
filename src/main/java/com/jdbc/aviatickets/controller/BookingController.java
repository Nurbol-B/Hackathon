package com.jdbc.aviatickets.controller;

import com.jdbc.aviatickets.entity.Booking;
import com.jdbc.aviatickets.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/booking")
public class BookingController {
    private final BookingService bookingService;

    @PostMapping()
    public Booking bookFlight(@RequestParam int userId, @RequestParam int flightId) {
        return bookingService.bookFlight(userId, flightId);
    }

    @GetMapping("/all")
    public List<Booking> getAllBookings() {
        return bookingService.getAll();
    }

    @DeleteMapping("/{id}")
    public String deleteBooking(@PathVariable Integer id) {
        return bookingService.deleteById(id);
    }
}
