package com.jdbc.aviatickets.repo;

import com.jdbc.aviatickets.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepo extends JpaRepository <Users,Integer> {
    Users findByUsername(String name);
//    Optional<Users> findByUsername(String userame);
    Optional<Users> findByEmail(String email);

}
