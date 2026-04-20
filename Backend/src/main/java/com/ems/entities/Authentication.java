package com.ems.entities;

import com.ems.enums.AuthProvider;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.time.LocalDateTime;


@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Authentication {
    // OAuth
    @Enumerated(EnumType.STRING)
    private AuthProvider provider = AuthProvider.LOCAL;
    private String providerId;

    // email verification
    private boolean emailVerified = false;
    private String emailVerificationToken;
    private LocalDateTime emailVerificationTokenExpiry;

    // reset password
    private String resetPasswordToken;
    private LocalDateTime resetPasswordExpiry;
    private boolean resetPasswordVerified = false;
}
