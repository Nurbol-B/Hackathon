package com.jdbc.aviatickets.controller;

import com.jdbc.aviatickets.entity.Flights;
import com.jdbc.aviatickets.service.FlightsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/flights")
public class FlightsController {
    private final FlightsService flightsService;

    @GetMapping("/all")
    public List<Flights> getAllFlights() {
        return flightsService.getAll();
    }

    @GetMapping("/{id}")
    public Flights getFlightById(@PathVariable Integer id) {
        return flightsService.findById(id);
    }

    @PostMapping
    public Integer saveFlight(@RequestBody Flights flights) {
        return flightsService.save(flights);
    }

    @DeleteMapping("/{id}")
    public String deleteFlight(@PathVariable Integer id) {
        return flightsService.deleteById(id);
    }

    @GetMapping("/to/{to}")
    public List<Flights> getFlightsByTo(@PathVariable String to) {
        return flightsService.findByTo(to);
    }
}