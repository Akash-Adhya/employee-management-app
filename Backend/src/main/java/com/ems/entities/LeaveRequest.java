package com.ems.entities;

import java.time.LocalDateTime;

import com.ems.enums.ExitRequestStatus;
import com.ems.enums.LeaveType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class LeaveRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leaveId;

    @Column(nullable = false)
    private Long employeeId;

    @Column(nullable = false)
    private Long managerId;

    @Column(nullable = false)
    private Long roomId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LeaveType leaveType;

    @Column(length = 500)
    private String leaveDescription;

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @Enumerated(EnumType.STRING)
    private ExitRequestStatus leaveStatus = ExitRequestStatus.PENDING;

    private String managerComment;

    private LocalDateTime createdAt;
    private LocalDateTime updateStatusAt;

    public LeaveRequest() {
        this.createdAt = LocalDateTime.now();
    }

    public LeaveRequest(Long employeeId, Long managerId, Long roomId, LeaveType leaveType, String leaveDescription,
                         LocalDateTime startDate, LocalDateTime endDate) {
        this.employeeId = employeeId;
        this.managerId = managerId;
        this.roomId = roomId;
        this.leaveType = leaveType;
        this.leaveDescription = leaveDescription;
        this.startDate = startDate;
        this.endDate = endDate;
        this.leaveStatus = ExitRequestStatus.PENDING;
        this.createdAt = LocalDateTime.now();
    }

    public Long getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(Long leaveId) {
        this.leaveId = leaveId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public LeaveType getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(LeaveType leaveType) {
        this.leaveType = leaveType;
    }

    public String getLeaveDescription() {
        return leaveDescription;
    }

    public void setLeaveDescription(String leaveDescription) {
        this.leaveDescription = leaveDescription;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public ExitRequestStatus getLeaveStatus() {
        return leaveStatus;
    }

    public void setLeaveStatus(ExitRequestStatus leaveStatus) {
        this.leaveStatus = leaveStatus;
        this.updateStatusAt = LocalDateTime.now();
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

    @Override
    public String toString() {
        return "\nLeaveRequests [leaveId=" + leaveId +
                ", employeeId=" + employeeId +
                ", managerId=" + managerId +
                ", roomId=" + roomId +
                ", leaveType=" + leaveType +
                ", leaveDescription=" + leaveDescription +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", leaveStatus=" + leaveStatus +
                ", managerComment=" + managerComment +
                ", createdAt=" + createdAt +
                ", updateStatusAt=" + updateStatusAt + "]";
    }
}