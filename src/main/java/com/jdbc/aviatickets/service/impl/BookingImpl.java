package com.jdbc.aviatickets.service.impl;

import com.jdbc.aviatickets.entity.Booking;
import com.jdbc.aviatickets.entity.Flights;
import com.jdbc.aviatickets.enums.BookingStatus;
import com.jdbc.aviatickets.repo.BookingRepo;
import com.jdbc.aviatickets.repo.FlightsRepo;
import com.jdbc.aviatickets.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BookingImpl implements BookingService {
    private final FlightsRepo flightRepository;

    private final BookingRepo bookingRepository;
    @Override
    public Booking bookFlight(int userId, int flightId) {
        Flights flights = flightRepository.findById(flightId).orElse(null);
        if(flights == null){
            throw  new NullPointerException(String.format("Рейс с id %s не найдена", flightId));
        }
        if(flights.getAvailableSeats() <= 0){
            throw  new NullPointerException(String.format("Нет свободных мест на рейсе %s", flightId));

        }
        flights.setAvailableSeats(flights.getAvailableSeats()-1);
        flightRepository.save(flights);

        Booking booking = new Booking();
        booking.setUserId(userId);
        booking.setFlightId(flightId);
        booking.setStatus(BookingStatus.BOOKED);
        bookingRepository.save(booking);
        return booking;
    }

    @Override
    public List<Booking> getAll() {
        return bookingRepository.findAll();
    }

    @Override
    public String deleteById(Integer id) {
        Optional<Booking> optionalBooking = bookingRepository.findById(id);

        if (optionalBooking.isPresent()) {
            Booking booking = optionalBooking.get();
            booking.setRemoveDate(new Date(System.currentTimeMillis()));
            bookingRepository.save(booking);

        } else throw new NullPointerException(String.format("Бронь с id %s не найдена", id));
        return "Deleted";
    }

}
