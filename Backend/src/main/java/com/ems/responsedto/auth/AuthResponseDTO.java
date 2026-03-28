package com.ems.responsedto.auth;

import com.ems.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponseDTO {
//    private String token;
    private String email;
    private Role role;
    private String message;
}
