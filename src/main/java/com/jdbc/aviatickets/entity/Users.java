package com.jdbc.aviatickets.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"email", "userName"}))

public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull(message = "Имя пользователя не указано")
    private String username;
    private String fullName;
    private String email;
    @NotEmpty(message = "Пароль не указан")
    private String password;
    private Date removeDate;
    @OneToMany
    private List<Flights> flightsList;
}