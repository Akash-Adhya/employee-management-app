package com.ems.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @Column(nullable = false, length = 100)
    private String employeeName;

    @Column(nullable = false, unique = true, length = 120)
    private String employeeEmail;

    @Column(nullable = false)
    private String password;

    // Profile file path
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

    // Default constructor (required by JPA)
    public Employee() {
        this.createdAt = LocalDateTime.now();
    }

    public Employee(String employeeName, String employeeEmail, String password) {
        this.employeeName = employeeName;
        this.employeeEmail = employeeEmail;
        this.password = password;
        this.createdAt = LocalDateTime.now();
    }

    public Employee(Long employeeId, String employeeName, String employeeEmail, String password) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeEmail = employeeEmail;
        this.password = password;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
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
        return "\nEmployee [employeeId=" + employeeId +
                ", employeeName=" + employeeName +
                ", employeeEmail=" + employeeEmail +
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