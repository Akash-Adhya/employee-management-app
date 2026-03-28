package com.ems.responsedto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseDTO extends UserResponseDTO{
    private String empId;
    private String designation;
    private String skills;
    private Integer yearsOfExperience;
    private LocalDate joiningDate;
}
