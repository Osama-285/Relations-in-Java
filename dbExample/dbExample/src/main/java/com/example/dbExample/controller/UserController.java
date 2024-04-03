package com.example.dbExample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dbExample.model.User;
import com.example.dbExample.payload.UserDTO;
import com.example.dbExample.services.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    public ResponseEntity<?> addUser(@Valid @RequestBody UserDTO userDTO) {
        try {
            User user = new User();
            user.setEmail(userDTO.getEmail());
            user.setPassword(userDTO.getPassword());
            System.out.println("USER INFORMATION : " + user + userDTO);
            userService.save(user);
            return ResponseEntity.ok(200);
        } catch (Exception e) {
            log.debug(AccountStatus.ADD_ACCOUNT_ERROR.toString() + ": " + e.getMessage());
            String errorMessage;
            HttpStatus status = HttpStatus.BAD_REQUEST;
        }
    }
}
