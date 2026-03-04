package com.ems.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BroadcastMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long broadcastId;

    @Column(nullable = false)
    private Long roomId;

    @Column(nullable = false)
    private Long managerId;

    @Column(nullable = false, length = 150)
    private String title;

    @Column(length = 500)
    private String message;

    private LocalDateTime createdAt;

    public BroadcastMessage() {
        this.createdAt = LocalDateTime.now();
    }

    public BroadcastMessage(Long roomId, Long managerId, String title, String message) {
        this.roomId = roomId;
        this.managerId = managerId;
        this.title = title;
        this.message = message;
        this.createdAt = LocalDateTime.now();
    }

    public Long getBroadcastId() {
        return broadcastId;
    }

    public void setBroadcastId(Long broadcastId) {
        this.broadcastId = broadcastId;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "\nBroadcastMessage [broadcastId=" + broadcastId +
                ", roomId=" + roomId +
                ", managerId=" + managerId +
                ", title=" + title +
                ", message=" + message +
                ", createdAt=" + createdAt + "]";
    }
}