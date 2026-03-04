package com.ems.entities;

import java.time.LocalDateTime;

import com.ems.enums.ExitRequestStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ExitRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long exitId;

    @Column(nullable = false)
    private Long employeeId;

    @Column(nullable = false)
    private Long roomId;

    @Column(nullable = false)
    private Long managerId;

    @Column(length = 500)
    private String exitReason;

    @Column(length = 500)
    private String managerComment;

    private LocalDateTime createdAt;
    private LocalDateTime updateStatusAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ExitRequestStatus exitStatus = ExitRequestStatus.PENDING;

    public ExitRequest() {
        this.createdAt = LocalDateTime.now();
    }

    public ExitRequest(Long employeeId, Long roomId, Long managerId, String exitReason) {
        this.employeeId = employeeId;
        this.roomId = roomId;
        this.managerId = managerId;
        this.exitReason = exitReason;
        this.exitStatus = ExitRequestStatus.PENDING;
        this.createdAt = LocalDateTime.now();
    }

    public Long getExitId() {
        return exitId;
    }

    public void setExitId(Long exitId) {
        this.exitId = exitId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public String getExitReason() {
        return exitReason;
    }

    public void setExitReason(String exitReason) {
        this.exitReason = exitReason;
    }

    public String getManagerComment() {
        return managerComment;
    }

    public void setManagerComment(String managerComment) {
        this.managerComment = managerComment;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdateStatusAt() {
        return updateStatusAt;
    }

    public void setUpdateStatusAt(LocalDateTime updateStatusAt) {
        this.updateStatusAt = updateStatusAt;
    }

    public ExitRequestStatus getExitStatus() {
        return exitStatus;
    }

    public void setExitStatus(ExitRequestStatus exitStatus) {
        this.exitStatus = exitStatus;
        this.updateStatusAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "\nExitRequests [exitId=" + exitId +
                ", employeeId=" + employeeId +
                ", roomId=" + roomId +
                ", managerId=" + managerId +
                ", exitReason=" + exitReason +
                ", managerComment=" + managerComment +
                ", createdAt=" + createdAt +
                ", updateStatusAt=" + updateStatusAt +
                ", exitStatus=" + exitStatus + "]";
    }
}