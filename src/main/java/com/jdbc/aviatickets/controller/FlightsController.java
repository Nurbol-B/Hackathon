package com.jdbc.aviatickets.controller;

import com.jdbc.aviatickets.entity.Flights;
import com.jdbc.aviatickets.service.FlightsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Flights", description = "Тут находятся все роуты связанные для работы с рейсами")

@RestController
@RequiredArgsConstructor
@RequestMapping("/flights")
public class FlightsController {
    private final FlightsService flightsService;

    @Operation(summary = "Этот роут возвращает весь список пользователей")

    @GetMapping("/all")
    public List<Flights> getAllFlights() {
        return flightsService.getAll();
    }

    @Operation(summary = "Этот роут возвращает рейсы по айди")

    @GetMapping("/{id}")
    public Flights getFlightById(@PathVariable Integer id) {
        return flightsService.findById(id);
    }

    @Operation(summary = "Этот роут обновляет данные о рейсах или добавляет новую")

    @PostMapping
    public Integer saveFlight(@RequestBody Flights flights) {
        try {
            return flightsService.save(flights);
        } catch (NullPointerException exception) {
            System.out.println(exception.getMessage());
            return -1;
        }
    }
    @Operation(summary = "Этот роут удаляет пользователей по айди")

    @DeleteMapping("/{id}")
    public String deleteFlight(@PathVariable Integer id) {
        return flightsService.deleteById(id);
    }
    @Operation(summary = "Этот роут находит  рейсы по пункту назначения. ")

    @GetMapping("/to/{to}")
    public List<Flights> getFlightsByTo(@PathVariable String to) {
        return flightsService.findByTo(to);
    }
}