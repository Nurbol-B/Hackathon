package com.jdbc.aviatickets.repo;

import com.jdbc.aviatickets.entity.Flights;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightsRepo extends JpaRepository <Flights,Integer> {
    List <Flights> findFlightsByTo(String to);

}
