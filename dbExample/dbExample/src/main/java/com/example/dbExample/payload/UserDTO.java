package com.example.dbExample.payload;

import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDTO {
    @Email
    private String email;

    private String password;
}
