package com.ems.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


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
    
    @Column(unique = true, nullable = false)
    private String roomCode;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private User manager;

    @OneToMany(mappedBy = "room")
    private List<User> employees;

    @OneToMany(mappedBy = "room")
    private List<Task> tasks;

    private LocalDateTime createdAt;

}