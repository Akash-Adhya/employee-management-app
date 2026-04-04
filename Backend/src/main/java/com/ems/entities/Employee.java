package com.ems.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Employee {
    @Id
    private Long id;

    private String employeeDesignation;
    private String skills;
    private Integer employeeYearsOfExperience;
    private LocalDate joiningDate;
    private String officeLocation;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @OneToMany(mappedBy = "employee")
    private List<EmployeeToTask> tasks;
}
