package com.ems.entities;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Manager {
    @Id
    private Long id;

    private String department;
    private String managerDesignation;
    private Integer managerYearsOfExperience;
    private String officeLocation;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private User user;


    @OneToMany(mappedBy = "manager")
    List<Room> rooms;
}
