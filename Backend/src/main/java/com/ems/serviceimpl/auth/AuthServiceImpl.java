package com.ems.serviceimpl.auth;

import com.ems.dto.requestDto.LoginRequestDTO;
import com.ems.dto.requestDto.SignUpRequestDTO;
import com.ems.dto.responsDto.AuthResponseDTO;
import com.ems.entities.Authentication;
import com.ems.entities.User;
import com.ems.exceptions.AuthenticationException;
import com.ems.exceptions.ResourceNotFound;
import com.ems.mapper.AuthMapper;
import com.ems.repositories.UserRepo;
import com.ems.service.auth.AuthService;
import com.ems.service.user.UserService;
import com.ems.utils.MailUtility;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@Transactional
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final MailUtility mailUtility;

    private final UserRepo userRepo;
    private final JwtService jwtService;

    @Override
    public AuthResponseDTO login(LoginRequestDTO dto) {
        User user = userRepo.findByEmail(dto.getEmail())
                .orElseThrow(()->new ResourceNotFound("User not found with this email. Try to create account first"));

        if(!user.getAuth().isEmailVerified()){
            throw new RuntimeException("Email not verified yet try to create account first");
        }

        if(!passwordEncoder.matches(dto.getPassword(),user.getPassword())){
            throw new AuthenticationException("Invalid login credentials");
        }

        String accessToken = jwtService.generateAccessToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);

        return AuthMapper.toAuthResponseDTO(user,accessToken,refreshToken);
    }

    @Override
    public AuthResponseDTO sigUp(SignUpRequestDTO dto) {
        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        User user = userService.createUser(dto);
        sendAccountCreationOtp(user.getEmail());
        return AuthMapper.toAuthResponseDTO(user,null,null);
    }

    @Override
    public AuthResponseDTO otpVerification(String email, String verificationCode) {
        User user = userRepo.findByEmail(email)
                .orElseThrow(()->new ResourceNotFound("User not found with this email"));
        Authentication auth = user.getAuth();

        if(auth == null|| auth.getEmailVerificationToken() == null){
            throw new RuntimeException(
                    "OTP not generated or already used"
            );
        }
        if(LocalDateTime.now().isAfter(auth.getEmailVerificationTokenExpiry())){
            throw new RuntimeException("OTP expired please try using resend OTP");
        }

        if(!auth.getEmailVerificationToken().equals(verificationCode)){
            throw new RuntimeException("Invalid OTP. Please try again");
        }

        auth.setEmailVerified(true);
        auth.setEmailVerificationToken(null);
        auth.setEmailVerificationTokenExpiry(null);

        user.setAuth(auth);
        userRepo.save(user);

        return AuthMapper.toAuthResponseDTO(user,null,null);
    }

    @Override
    public String sendForgotPasswordOtp(String email) {
        User user = userRepo.findByEmail(email)
                .orElseThrow(()->new ResourceNotFound("User not found with this email"));

        String otp = generateOtp();
        mailUtility.sendMailForForgetPassword(user.getEmail(),otp);

        Authentication userAuth = user.getAuth();
        userAuth.setResetPasswordToken(otp);
        userAuth.setResetPasswordExpiry(
                LocalDateTime.now().plusMinutes(10)
        );
        user.setAuth(userAuth);
        userRepo.save(user);
        return "Otp has been send to email: "+user.getEmail();
    }

    @Override
    public String otpVerificationForPassword(String email, String verificationCode) {
        User user = userRepo.findByEmail(email)
                .orElseThrow(()->new ResourceNotFound("User not found with this email"));
        Authentication auth = user.getAuth();

        if(auth == null|| auth.getResetPasswordToken() == null){
            throw new RuntimeException(
                    "OTP not generated or already used"
            );
        }
        if(LocalDateTime.now().isAfter(auth.getResetPasswordExpiry())){
            throw new RuntimeException("OTP expired please try using resend OTP");
        }

        if(!auth.getResetPasswordToken().equals(verificationCode)){
            throw new RuntimeException("Invalid OTP. Please try again");
        }

        auth.setResetPasswordToken(null);
        auth.setResetPasswordExpiry(null);
        auth.setResetPasswordVerified(true);
        user.setAuth(auth);
        userRepo.save(user);


        return "OTP verified successfully";
    }

    @Override
    public String passwordUpdate(String email,String newPassword) {
        User user = userRepo.findByEmail(email)
                .orElseThrow(()->new ResourceNotFound("User not found with this email"));

        if(!user.getAuth().isResetPasswordVerified()){
            throw new RuntimeException("Please verify your email before resetting password");
        }

        user.setPassword(passwordEncoder.encode(
                newPassword
        ));

        user.getAuth().setResetPasswordVerified(false);
        userRepo.save(user);
        return "Password has been updated successfully";
    }

    @Override
    public String logOut() {
        return "User logged out successfully";
    }



    @Override
    public void sendAccountCreationOtp(String email) {
        User user = userRepo.findByEmail(email)
                .orElseThrow(()->new ResourceNotFound("User not found with this email"));

        String otp = generateOtp();
        mailUtility.sendMailForCreateAccount(email,otp);

        Authentication userAuth = user.getAuth();
        userAuth.setEmailVerificationToken(otp);
        userAuth.setEmailVerificationTokenExpiry(
                LocalDateTime.now().plusMinutes(10)
        );
        user.setAuth(userAuth);
        userRepo.save(user);
    }


    private String generateOtp(){
        int otp =
                100000 +
                        new java.util.Random()
                                .nextInt(900000);

        return String.valueOf(otp);
    }
}
