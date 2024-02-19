package com.jdbc.aviatickets.service;

import com.jdbc.aviatickets.entity.Flights;
import com.jdbc.aviatickets.entity.Users;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsersService {
    public List<Users> getAll();
    public Users findById(int id);
    public String deleteById(int id);
    public Integer save(Users users) throws NullPointerException;
    public List <Flights> findTicketsByUsersName(String name);
    Integer registration(Users users);


}
