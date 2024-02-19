package com.jdbc.aviatickets.service.impl;

import com.jdbc.aviatickets.entity.Booking;
import com.jdbc.aviatickets.entity.Flights;
import com.jdbc.aviatickets.entity.Users;
import com.jdbc.aviatickets.enums.BookingStatus;
import com.jdbc.aviatickets.repo.BookingRepo;
import com.jdbc.aviatickets.repo.FlightsRepo;
import com.jdbc.aviatickets.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BookingImpl implements BookingService {
    private final FlightsRepo flightRepository;
    Users users = new Users();
    private final MailImpl mail;

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

        String subject = "Ваш рейс успешно забронирован";
        String text = "Уважаемый " + users.getFullName() + ", ваш рейс успешно забронирован. " +
                "Ваш вылет в " + flights.getTimeOfFlight()  + " часов." +
                "Спасибо за выбор нашей компании.";

        mail.flightBooking(users.getEmail(),subject,text);
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

        String subject = "Ваш бронь успешно удален.";
        String text = "Уважаемый " + users.getFullName() + ", ваш бронь был успешно удален. ";
        mail.flightBooking(users.getEmail(),subject,text);

        return "Deleted";
    }

}
