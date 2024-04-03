package com.example.dbExample.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.dbExample.Repository.UserRepo;
import com.example.dbExample.model.User;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    public User save(User user) {
        return userRepo.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepo.findByEmail((email));
        if (!optionalUser.isPresent()) {
            throw new UsernameNotFoundException("User Not Found");
        }
        User user = optionalUser.get();
        return new User(user.getEmail(), user.getPassword());
    }
}
