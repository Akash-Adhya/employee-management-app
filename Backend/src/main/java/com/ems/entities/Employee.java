package com.ems.entities;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.time.LocalDate;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
    private String empId;
    private String EmployeeDesignation;
    private String skills;
    private Integer EmployeeYearsOfExperience;
    private LocalDate joiningDate;
}
