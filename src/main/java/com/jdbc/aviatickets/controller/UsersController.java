package com.jdbc.aviatickets.controller;

import com.jdbc.aviatickets.entity.Flights;
import com.jdbc.aviatickets.entity.Users;
import com.jdbc.aviatickets.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.aop.target.LazyInitTargetSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UsersController {
    private final UsersService usersService;

    @GetMapping("/all")
    public List<Users> getAllUsers(){
        return usersService.getAll();
    }
    @GetMapping("/{id}")
    public Users getUserById(@PathVariable int id) {
        return usersService.findById(id);
    }

    @PostMapping
    public Integer save(@RequestBody Users users ) {
        try {
            return usersService.save(users);

        } catch (NullPointerException exception) {
            System.out.println(exception.getMessage());
            return -1;
        }
    }
    @DeleteMapping
    public String delete(@RequestParam int id) {
        return usersService.deleteById(id);
    }

    @GetMapping("/{name}/tickets")
    public List<Flights> getTicketsByUserName(@PathVariable String name) {
        return usersService.findTicketsByUsersName(name);
    }
}
