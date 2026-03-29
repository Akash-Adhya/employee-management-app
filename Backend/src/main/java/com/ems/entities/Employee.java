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
    private String employeeDesignation;
    private String skills;
    private Integer employeeYearsOfExperience;
    private LocalDate joiningDate;
}
