package com.ems.requestdto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDTO {

    @NotNull(message = "Email field is empty")
    @Email(message = "Please provide a valid email address")
    private String email;

    @NotNull(message = "Password field is empty")
    private String password;
}