package com.ems.service.auth;

import com.ems.dto.requestDto.LoginRequestDTO;
import com.ems.dto.requestDto.SignUpRequestDTO;
import com.ems.dto.responsDto.AuthResponseDTO;

public interface AuthService {
    AuthResponseDTO login(LoginRequestDTO dto);
    AuthResponseDTO sigUp(SignUpRequestDTO dto);

    AuthResponseDTO otpVerification(String email,String verificationCode);
    void sendAccountCreationOtp(String email);

    //send OTP if user click forgot password
    String sendForgotPasswordOtp(String email);
    String otpVerificationForPassword(String email,String verificationCode);
    String passwordUpdate(String email,String newPassword);

    String logOut();
}
