package com.ems.entities;

import com.ems.enums.RoomExitRequestStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RoomExitRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reason;

    private LocalDateTime requestedTime = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private RoomExitRequestStatus status = RoomExitRequestStatus.REQUESTED;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;


    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

}