package com.ems.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    private Long roomId;

    private Long managerId;

    private String title;
    private String description;
    private LocalDateTime deadline;

    public Task() {
    }

    public Task(Long roomId, Long managerId, String title, String description, LocalDateTime deadline) {
        this.roomId = roomId;
        this.managerId = managerId;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
    }

    public Task(Long taskId, Long roomId, Long managerId, String title, String description, LocalDateTime deadline) {
        this.taskId = taskId;
        this.roomId = roomId;
        this.managerId = managerId;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "\nTask [taskId=" + taskId +
                ", roomId=" + roomId +
                ", managerId=" + managerId +
                ", title=" + title +
                ", description=" + description +
                ", deadline=" + deadline + "]";
    }
}