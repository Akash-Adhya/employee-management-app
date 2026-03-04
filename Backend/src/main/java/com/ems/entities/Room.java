package com.ems.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;

    @Column(nullable = false, length = 100)
    private String roomName;

    @Column(length = 500)
    private String roomDescription;

    @Column(nullable = false, unique = true, length = 16)
    private String roomKey;

    @Column(nullable = false)
    private Long managerId;

    @Column(nullable = false)
    private boolean isLocked = false;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    public Room() {
        this.createdAt = LocalDateTime.now();
    }

    public Room(String roomName, String roomDescription, String roomKey, Long managerId) {
        this.roomName = roomName;
        this.roomDescription = roomDescription;
        this.roomKey = roomKey;
        this.managerId = managerId;
        this.createdAt = LocalDateTime.now();
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }

    public String getRoomKey() {
        return roomKey;
    }

    public void setRoomKey(String roomKey) {
        this.roomKey = roomKey;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "\nRoom [roomId=" + roomId + 
               ", roomName=" + roomName + 
               ", roomDescription=" + roomDescription + 
               ", roomKey=" + roomKey + 
               ", managerId=" + managerId + 
               ", isLocked=" + isLocked + 
               ", createdAt=" + createdAt + "]";
    }
}