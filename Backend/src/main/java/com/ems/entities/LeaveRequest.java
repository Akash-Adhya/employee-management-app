package com.ems.entities;

import com.ems.enums.LeaveStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LeaveRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private LocalDate startDate;
    private LocalDate endDate;

    private LeaveStatus leaveStatus;
    private LocalDateTime appliedAt;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private User Employee;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private User manager;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
}