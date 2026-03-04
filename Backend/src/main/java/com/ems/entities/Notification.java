package com.ems.entities;

import java.time.LocalDateTime;

import com.ems.enums.NotificationUserRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notificationId;

    @Column(nullable = false)
    private Long userId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NotificationUserRole notificationUserRole;

    @Column(nullable = false, length = 150)
    private String title;

    @Column(length = 500)
    private String message;

    @Column(nullable = false)
    private boolean isRead = false;

    private LocalDateTime createdAt;

    public Notification() {
        this.createdAt = LocalDateTime.now();
    }

    public Notification(Long userId, NotificationUserRole notificationUserRole, String title, String message) {
        this.userId = userId;
        this.notificationUserRole = notificationUserRole;
        this.title = title;
        this.message = message;
        this.isRead = false;
        this.createdAt = LocalDateTime.now();
    }

    public Long getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Long notificationId) {
        this.notificationId = notificationId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public NotificationUserRole getNotificationUserRole() {
        return notificationUserRole;
    }

    public void setNotificationUserRole(NotificationUserRole notificationUserRole) {
        this.notificationUserRole = notificationUserRole;
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

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean isRead) {
        this.isRead = isRead;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "\nNotification [notificationId=" + notificationId +
                ", userId=" + userId +
                ", notificationUserRole=" + notificationUserRole +
                ", title=" + title +
                ", message=" + message +
                ", isRead=" + isRead +
                ", createdAt=" + createdAt + "]";
    }
}