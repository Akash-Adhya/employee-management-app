package com.ems.dto.requestDto;

import jakarta.validation.constraints.*;
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

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 100, message = "Name must be between 3 and 100 characters")
    private String name;


    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;


    @NotBlank(message = "Contact number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Contact number must be 10 digits")
    private String contactNo;


    @NotBlank(message = "Password is required")
    @Size(min = 6, max = 50, message = "Password must be between 6 and 50 characters")
    private String password;


    @NotBlank(message = "Employee ID is required")
    private String employeeId;


    @NotBlank(message = "Role is required")
    private String role;

    @Past(message = "DOB must be in the past")
    private LocalDate dob;

    private String imageUrl;

    // manager fields

    @Size(max = 100, message = "Department max 100 characters")
    private String department;


    @Size(max = 100, message = "Manager designation max 100 characters")
    private String managerDesignation;


    @Min(value = 0, message = "Experience cannot be negative")
    @Max(value = 60, message = "Experience seems too high")
    private Integer managerYearsOfExperience;



    // employee fields

    @Size(max = 100, message = "Employee designation max 100 characters")
    private String employeeDesignation;


    @Size(max = 300, message = "Skills max 300 characters")
    private String skills;


    @Min(value = 0, message = "Experience cannot be negative")
    @Max(value = 60, message = "Experience seems too high")
    private Integer employeeYearsOfExperience;


    @PastOrPresent(message = "Joining date cannot be in the future")
    private LocalDate joiningDate;



    @Size(max = 150, message = "Office location max 150 characters")
    private String officeLocation;



    // address

    @Size(max = 150)
    private String street;


    @Size(max = 100)
    private String city;


    @Size(max = 100)
    private String state;


    @Pattern(regexp = "^[0-9]{6}$", message = "Pincode must be 6 digits")
    private String pincode;


    @Size(max = 100)
    private String country;
}