package com.example.dbExample.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dbExample.model.UserCredintials;

public interface UserRepo extends JpaRepository<UserCredintials, Long> {
    Optional<UserCredintials> findByEmail(String email);
}
