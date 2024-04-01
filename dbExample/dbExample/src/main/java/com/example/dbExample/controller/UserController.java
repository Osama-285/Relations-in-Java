package com.example.dbExample.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dbExample.payload.UserDTO;

import jakarta.validation.Valid;

@RestController
public class UserController {

    public ResponseEntity<?> addUser(@Valid @RequestBody UserDTO userDTO) {

    }
}
