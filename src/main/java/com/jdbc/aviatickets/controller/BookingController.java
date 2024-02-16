package com.jdbc.aviatickets.controller;

import com.jdbc.aviatickets.entity.Booking;
import com.jdbc.aviatickets.service.BookingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Booking", description = "Тут находятся все роуты связанные для работы с бронированием рейсами")

@RestController
@RequiredArgsConstructor
@RequestMapping("/booking")
public class BookingController {
    private final BookingService bookingService;
    @Operation(summary = "Этот роут делает бронь рейсов по айди пользователей и по айди рейсов")

    @PostMapping()
    public Booking bookFlight(@RequestParam int userId, @RequestParam int flightId) {
        return bookingService.bookFlight(userId, flightId);
    }
    @Operation(summary = "Этот роут возвращает весь список броней")

    @GetMapping("/all")
    public List<Booking> getAllBookings() {
        return bookingService.getAll();
    }
    @Operation(summary = "Этот роут удаляет бронь рейсов по айди")

    @DeleteMapping("/{id}")
    public String deleteBooking(@PathVariable Integer id) {
        return bookingService.deleteById(id);
    }
}
