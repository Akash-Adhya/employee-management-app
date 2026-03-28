package com.ems.requestdto.user;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeUpdateDTO {

    private String employeeDesignation;

    private String skills;

    private Integer employeeYearsOfExperience;

    private LocalDate joiningDate;
}