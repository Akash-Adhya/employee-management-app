package com.ems.entities;

import com.ems.enums.Role;
import jakarta.persistence.*;
import lombok.*;

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
    private UUID id;

    private String name;

    @Column(unique = true,nullable = false)
    private String email;

    @Column(unique = true,nullable = false)
    private String contactNo;

    @Column(nullable = false)
    private String password;


    private  String imageUrl;

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


}