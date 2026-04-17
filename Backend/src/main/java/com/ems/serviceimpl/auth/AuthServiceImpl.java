package com.ems.serviceimpl.auth;

import com.ems.dto.requestDto.LoginRequestDTO;
import com.ems.dto.requestDto.SignUpRequestDTO;
import com.ems.dto.responsDto.AuthResponseDTO;
import com.ems.dto.responsDto.UserResponseDTO;
import com.ems.repositories.UserRepo;
import com.ems.service.auth.AuthService;
import com.ems.service.user.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@Transactional
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final UserRepo userRepo;

    @Override
    public AuthResponseDTO login(LoginRequestDTO dto) {
        return null;
    }

    @Override
    public AuthResponseDTO sigUp(SignUpRequestDTO dto) {


        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        UserResponseDTO user = userService.createUser(dto);



        return null;
    }

    @Override
    public AuthResponseDTO otpVerification(String verificationCode) {
        return null;
    }

    @Override
    public String sendForgotPasswordOtp() {
        return "";
    }

    @Override
    public String passwordUpdate(String newPassword) {
        return "";
    }

    @Override
    public String logOut() {
        return "";
    }




    private boolean sendAccountCreationOtp(String email) {
        return false;
    }
}
