package com.jdbc.aviatickets.service;

import com.jdbc.aviatickets.entity.Flights;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface FlightsService {
    public List<Flights> getAll();
    public Flights findById(Integer id);
    public String deleteById(Integer id);
    public Integer save(Flights flights) throws NullPointerException;
    public List <Flights> findByTo(String to);
}