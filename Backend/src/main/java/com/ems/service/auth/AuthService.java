package com.ems.service.auth;

import com.ems.dto.requestDto.LoginRequestDTO;
import com.ems.dto.requestDto.SignUpRequestDTO;
import com.ems.dto.responsDto.AuthResponseDTO;

public interface AuthService {
    AuthResponseDTO login(LoginRequestDTO dto);
    AuthResponseDTO sigUp(SignUpRequestDTO dto);

    //Use for both verification password and account creation
    AuthResponseDTO otpVerification(String verificationCode);

    //send OTP if user click forgot password
    String sendForgotPasswordOtp();
    String passwordUpdate(String newPassword);

    String logOut();
}
