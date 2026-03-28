package com.ems.requestdto.user;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ManagerUpdateDTO {

    private String department;

    private String managerDesignation;

    private Integer managerYearsOfExperience;

    private String officeLocation;
}