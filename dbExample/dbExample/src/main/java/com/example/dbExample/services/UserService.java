package com.example.dbExample.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.dbExample.Repository.UserRepo;

import com.example.dbExample.model.UserCredintials;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    public UserCredintials save(UserCredintials user) {
        return userRepo.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserCredintials> optionalUser = userRepo.findByEmail((email));
        if (!optionalUser.isPresent()) {
            throw new UsernameNotFoundException("User Not Found");
        }
        UserCredintials userCredientials = optionalUser.get();
        List<GrantedAuthority> grantedAuthoriy = new ArrayList<>();
        grantedAuthoriy.add(new SimpleGrantedAuthority(userCredientials.getAuthorities()));
        return new User(userCredientials.getEmail(), userCredientials.getPassword(), grantedAuthoriy);
    }
}
