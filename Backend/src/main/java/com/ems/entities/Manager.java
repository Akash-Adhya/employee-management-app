package com.ems.entities;


import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Manager {
    private String department;
    private String ManagerDesignation;
    private Integer ManagerYearsOfExperience;
    private String officeLocation;
}
