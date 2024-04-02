package com.example.dbExample.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.example.dbExample.Repository.UserRepo;
import com.example.dbExample.model.User;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @SuppressWarnings("null")
    public User save(User user) {
        return userRepo.save(user);
    }
}
