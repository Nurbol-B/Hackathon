package com.jdbc.aviatickets.controller;

import com.jdbc.aviatickets.entity.Flights;
import com.jdbc.aviatickets.entity.Users;
import com.jdbc.aviatickets.service.UsersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.aop.target.LazyInitTargetSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Users", description = "Тут находятся все роуты связанные для работы с пользователями сервиса")

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UsersController {
    private final UsersService usersService;

    @Operation(summary = "Этот роут возвращает весь список пользователей")

    @GetMapping("/all")
    public List<Users> getAllUsers(){
        return usersService.getAll();
    }
    @Operation(summary = "Этот роут возвращает пользователей по айди")

    @GetMapping("/{id}")
    public Users getUserById(@PathVariable int id) {
        return usersService.findById(id);
    }
    @Operation(summary = "Этот роут обновляет данные о пользователей или добавляет новую")

    @PostMapping
    public Integer save(@RequestBody Users users ) {
        try {
            return usersService.save(users);

        } catch (NullPointerException exception) {
            System.out.println(exception.getMessage());
            return -1;
        }
    }
    @Operation(summary = "Этот роут удаляет пользователей по айди")

    @DeleteMapping
    public String delete(@RequestParam int id) {
        return usersService.deleteById(id);
    }

    @Operation(summary = "Этот роут находит билетов на рейсы по имени пользователей")

    @GetMapping("/{name}/tickets")
    public List<Flights> getTicketsByUserName(@PathVariable String name) {
        return usersService.findTicketsByUsersName(name);
    }
}
