package com.jdbc.aviatickets.service.impl;

import com.jdbc.aviatickets.entity.Flights;
import com.jdbc.aviatickets.repo.FlightsRepo;
import com.jdbc.aviatickets.service.FlightsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FlightsImpl implements FlightsService {
    private final FlightsRepo flightsRepo;

    @Override
    public List<Flights> getAll() {
        return flightsRepo.findAll();
    }

    public Flights findById(Integer id) {
        return flightsRepo.findById(id).orElse(null);
    }

    public String deleteById(Integer id) {
        Optional<Flights> optionalFlights = flightsRepo.findById(id);

        if (optionalFlights.isPresent()) {
            Flights flights = optionalFlights.get();
            flights.setRemoveDate(new Date(System.currentTimeMillis()));
            flightsRepo.save(flights);

        } else throw new NullPointerException(String.format("Рейс с id %s не найдена", id));
        return "Deleted";
    }

    @Override
    public Integer save(Flights flights) throws NullPointerException {
        if (flights.getId() == null) {
            Flights savedFlights = flightsRepo.save(flights);
            return savedFlights.getId();
        } else {
            return update(flights);
        }
    }

    @Override
    public List<Flights> findByTo(String to) {
        return flightsRepo.findFlightsByTo(to);
    }

    private Integer update (Flights flights) throws  NullPointerException{
        Optional <Flights> flightsOptional = flightsRepo.findById(flights.getId());
        if (flightsOptional.isPresent()){
            Flights existingFlights = flightsOptional.get();
            existingFlights.setId(flights.getId());
            existingFlights.setPrice(flights.getPrice());
            existingFlights.setCompany(flights.getCompany());
            existingFlights.setTo(flights.getTo());
            existingFlights.setTimeOfFlight(flights.getTimeOfFlight());
            existingFlights.setFrom(flights.getFrom());
            return flightsRepo.save(existingFlights).getId();
        }else{
            throw new NullPointerException(String.format("Рейс с id %s не найдена", flights.getId()));
        }
    }

}
