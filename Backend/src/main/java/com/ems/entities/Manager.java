package com.ems.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long managerId;

    @Column(nullable = false, length = 100)
    private String managerName;

    @Column(nullable = false, unique = true, length = 120)
    private String managerEmail;

    @Column(nullable = false)
    private String password;

    // Profile image/file path
    @Column(length = 255)
    private String profilePath;

    private LocalDateTime createdAt;

    // Email Verification
    private boolean emailVerified = false;

    @Column(length = 6)
    private String emailVerificationOtp;

    private LocalDateTime emailOtpExpiry;

    // Password Reset
    @Column(length = 6)
    private String passwordResetOtp;

    private LocalDateTime passwordResetOtpExpiry;

    public Manager() {
        this.createdAt = LocalDateTime.now();
    }

    public Manager(String managerName, String managerEmail, String password) {
        this.managerName = managerName;
        this.managerEmail = managerEmail;
        this.password = password;
        this.createdAt = LocalDateTime.now();
    }

    public Manager(Long managerId, String managerName, String managerEmail, String password) {
        this.managerId = managerId;
        this.managerName = managerName;
        this.managerEmail = managerEmail;
        this.password = password;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerEmail() {
        return managerEmail;
    }

    public void setManagerEmail(String managerEmail) {
        this.managerEmail = managerEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfilePath() {
        return profilePath;
    }

    public void setProfilePath(String profilePath) {
        this.profilePath = profilePath;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public String getEmailVerificationOtp() {
        return emailVerificationOtp;
    }

    public void setEmailVerificationOtp(String emailVerificationOtp) {
        this.emailVerificationOtp = emailVerificationOtp;
    }

    public LocalDateTime getEmailOtpExpiry() {
        return emailOtpExpiry;
    }

    public void setEmailOtpExpiry(LocalDateTime emailOtpExpiry) {
        this.emailOtpExpiry = emailOtpExpiry;
    }

    public String getPasswordResetOtp() {
        return passwordResetOtp;
    }

    public void setPasswordResetOtp(String passwordResetOtp) {
        this.passwordResetOtp = passwordResetOtp;
    }

    public LocalDateTime getPasswordResetOtpExpiry() {
        return passwordResetOtpExpiry;
    }

    public void setPasswordResetOtpExpiry(LocalDateTime passwordResetOtpExpiry) {
        this.passwordResetOtpExpiry = passwordResetOtpExpiry;
    }

    @Override
    public String toString() {
        return "\nManager [managerId=" + managerId +
                ", managerName=" + managerName +
                ", managerEmail=" + managerEmail +
                ", password=" + password +
                ", profilePath=" + profilePath +
                ", createdAt=" + createdAt +
                ", emailVerified=" + emailVerified +
                ", emailVerificationOtp=" + emailVerificationOtp +
                ", emailOtpExpiry=" + emailOtpExpiry +
                ", passwordResetOtp=" + passwordResetOtp +
                ", passwordResetOtpExpiry=" + passwordResetOtpExpiry + "]";
    }

}