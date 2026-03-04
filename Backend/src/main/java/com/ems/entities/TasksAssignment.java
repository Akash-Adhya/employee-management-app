package com.ems.entities;

import java.time.LocalDateTime;

import com.ems.enums.TaskStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class TasksAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskAssnId;

    @Column(nullable = false)
    private Long taskId;

    @Column(nullable = false)
    private Long employeeId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TaskStatus status = TaskStatus.ASSIGNED;

    private LocalDateTime statusUpdatedAt;

    public TasksAssignment() {
    }

    public TasksAssignment(Long taskId, Long employeeId, TaskStatus status, LocalDateTime statusUpdatedAt) {
        this.taskId = taskId;
        this.employeeId = employeeId;
        this.status = status;
        this.statusUpdatedAt = statusUpdatedAt;
    }

    public TasksAssignment(Long taskAssnId, Long taskId, Long employeeId, TaskStatus status, LocalDateTime statusUpdatedAt) {
        this.taskAssnId = taskAssnId;
        this.taskId = taskId;
        this.employeeId = employeeId;
        this.status = status;
        this.statusUpdatedAt = statusUpdatedAt;
    }

    public Long getTaskAssnId() {
        return taskAssnId;
    }

    public void setTaskAssnId(Long taskAssnId) {
        this.taskAssnId = taskAssnId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
        this.statusUpdatedAt = LocalDateTime.now();
    }

    public LocalDateTime getStatusUpdatedAt() {
        return statusUpdatedAt;
    }

    public void setStatusUpdatedAt(LocalDateTime statusUpdatedAt) {
        this.statusUpdatedAt = statusUpdatedAt;
    }

    @Override
    public String toString() {
        return "\nTasksAssignment [taskAssnId=" + taskAssnId +
                ", taskId=" + taskId +
                ", employeeId=" + employeeId +
                ", status=" + status +
                ", statusUpdatedAt=" + statusUpdatedAt + "]";
    }
}