package com.ems.entities;

import com.ems.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true,nullable = false)
    private String email;

    @Column(unique = true,nullable = false)
    private String contactNo;

    @Column(nullable = false)
    private String password;


    private  String imageUrl;

    @Column(nullable = false,unique = true)
    private String EmployeeId;

    @Enumerated(EnumType.STRING)
    private Role role;

    //Embeded Objects
    @Embedded
    private Manager manager;
    @Embedded
    private Employee employee;
    @Embedded
    private Address address;

    @Embedded
    private Authentication auth;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    private LocalDateTime createdAt = LocalDateTime.now();

}