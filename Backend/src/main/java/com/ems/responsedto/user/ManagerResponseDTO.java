package com.ems.responsedto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ManagerResponseDTO extends UserResponseDTO{
    private String department;
    private String designation;
    private Integer yearsOfExperience;
    private String officeLocation;
}
