package com.jdbc.aviatickets.controller;

import com.jdbc.aviatickets.entity.Users;
import com.jdbc.aviatickets.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.aop.target.LazyInitTargetSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UsersController {
    private final UsersService usersService;

    @GetMapping("/all")
    public List<Users> getAllUsers(){

    }

}
