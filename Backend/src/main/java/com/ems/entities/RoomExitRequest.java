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

    private LocalDateTime requestedTime;

    @Enumerated(EnumType.STRING)
    private RoomExitRequestStatus status;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private User manager;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private User employee;


    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

}