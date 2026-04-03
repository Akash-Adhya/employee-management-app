package com.ems.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String roomName;
    private String description;
    private boolean isLocked = false;

    @Column(unique = true, nullable = false)
    private String roomCode;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;

    @OneToMany(mappedBy = "room")
    private List<Employee> employees;

    @OneToMany(mappedBy = "room")
    private List<Task> tasks;

    private LocalDateTime createdAt = LocalDateTime.now();

}