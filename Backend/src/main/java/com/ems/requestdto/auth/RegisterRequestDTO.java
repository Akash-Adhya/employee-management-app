package com.ems.requestdto.auth;

import com.ems.enums.Role;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequestDTO {

    private String name;


    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Contact No is required")
    private String contactNo;


    @NotBlank(message = "Password is required")
    private String password;


    @NotBlank(message = "Employee ID is required")
    private String employeeId;


    @NotNull(message = "Role is required")
    private Role role;


    private String roomCode;


    @AssertTrue(message =
            "Room code is required when role is EMPLOYEE")
    public boolean isRoomCodeValid(){

        if(role == Role.EMPLOYEE){
            return roomCode != null && !roomCode.isBlank();
        }

        return true;
    }
}