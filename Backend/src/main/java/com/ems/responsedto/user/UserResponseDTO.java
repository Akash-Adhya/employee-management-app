package com.ems.responsedto.user;

import com.ems.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String contactNo;
    private String imageUrl;
    private String employeeId;
    private Role role;
    private AddressResponseDTO address;

}
