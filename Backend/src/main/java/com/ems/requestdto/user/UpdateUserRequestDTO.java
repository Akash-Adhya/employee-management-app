package com.ems.requestdto.user;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequestDTO {
    @Size(min = 2, max = 50,
            message = "Name must be between 2 and 50 characters")
    private String name;


    @Size(max = 15,
            message = "Contact number too long")
    private String contactNo;


    private String imageUrl;


    @Valid
    private AddressDTO address;


    @Valid
    private ManagerUpdateDTO manager;


    @Valid
    private EmployeeUpdateDTO employee;
}
