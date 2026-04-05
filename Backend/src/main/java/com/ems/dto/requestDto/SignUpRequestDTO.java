package com.ems.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequestDTO {
    private String name;
    private String email;
    private String contactNo;
    private String password;

    private String employeeId;
    private String role;
    private LocalDate dob;

    // manager fields

    private String department;
    private String managerDesignation;
    private Integer managerYearsOfExperience;

    // employee fields

    private String employeeDesignation;
    private String skills;
    private Integer employeeYearsOfExperience;
    private LocalDate joiningDate;

    private String officeLocation;

    // address

    private String street;
    private String city;
    private String state;
    private String pincode;
    private String country;

    private String imageUrl;
}
