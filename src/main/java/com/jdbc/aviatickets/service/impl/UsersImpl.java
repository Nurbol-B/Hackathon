package com.jdbc.aviatickets.service.impl;

import com.jdbc.aviatickets.entity.Flights;
import com.jdbc.aviatickets.entity.Users;
import com.jdbc.aviatickets.repo.UsersRepo;
import com.jdbc.aviatickets.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor

@Service

public class UsersImpl  implements UsersService {
    private final UsersRepo usersRepo;

    @Override
    public List<Users> getAll() {
        return usersRepo.findAll();
    }

    @Override
    public Users findById(int id) {
        return usersRepo.findById(id).orElse(null);
    }

    public String deleteById(int id) {
        Optional <Users> optionalUsers = usersRepo.findById(id);

        if(optionalUsers.isPresent()){
            Users users = optionalUsers.get();
            users.setRemoveDate(new Date(System.currentTimeMillis()));
            usersRepo.save(users);
        }else  throw new NullPointerException(String.format("Пользователь с id %s не найдена", id));
        return "Deleted";
    }

    @Override
    public Integer save(Users users) throws NullPointerException {
        if (users.getId() == null) {
            Users savedBook = usersRepo.save(users);
            return savedBook.getId();
        } else {
            return update(users);
        }
    }

    private Integer update (Users users) throws  NullPointerException{
        Optional <Users> optionalUsers = usersRepo.findById(users.getId());
        if (optionalUsers.isPresent()){
            Users existingUsers = optionalUsers.get();
            existingUsers.setId(users.getId());
            existingUsers.setUserName(users.getUserName());
            return usersRepo.save(existingUsers).getId();
        }else{
            throw new NullPointerException(String.format("Пользователь с id %s не найдена", users.getId()));
        }
    }
    @Override
    public List<Flights> findTicketsByUsersName(String name) {
        Users user = usersRepo.findByUserName(name);
        if (user != null) {
            return user.getFlightsList();
        } else {
            return null;
        }
    }

}
