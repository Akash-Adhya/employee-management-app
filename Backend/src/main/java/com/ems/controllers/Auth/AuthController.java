package com.ems.controllers.Auth;

import com.ems.dto.requestDto.LoginRequestDTO;
import com.ems.dto.requestDto.SignUpRequestDTO;
import com.ems.dto.responsDto.ApiResponseDto;
import com.ems.dto.responsDto.AuthResponseDTO;
import com.ems.service.auth.AuthService;
import com.ems.serviceimpl.auth.CookieService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final CookieService cookieService;

    @PostMapping("/login")
    public ResponseEntity<ApiResponseDto<AuthResponseDTO>> login(
            @RequestBody LoginRequestDTO dto,
            HttpServletResponse response
    ){
        AuthResponseDTO responseDTO =
                authService.login(dto);

        Cookie cookie = cookieService.getRefreshTokenCookie(responseDTO.getRefreshToken());
        response.addCookie(cookie);

        return ResponseEntity.ok(
                new ApiResponseDto<>(
                        "Logged in successfully",
                        HttpStatus.OK.value(),
                        responseDTO
                )
        );
    }

    @PostMapping("/sign-up")
    public ResponseEntity<ApiResponseDto<AuthResponseDTO>> signUp(
            @RequestBody SignUpRequestDTO dto
    ){
        AuthResponseDTO responseDTO =
                authService.signUp(dto);
        return ResponseEntity.ok(
                new ApiResponseDto<>(
                        "OTP has been send to your email please verify",
                        HttpStatus.OK.value(),
                        responseDTO
                )
        );
    }

    @GetMapping("/sign-up/otp/verify")
    public ResponseEntity<ApiResponseDto<AuthResponseDTO>> verifySignUpOtp(
            @RequestParam String email,
            @RequestParam String verificationCode
    ){
        AuthResponseDTO responseDTO =
                authService.otpVerification(email,verificationCode);
        return ResponseEntity.ok(
                new ApiResponseDto<>(
                        "OTP has been Verified. Please Login to continue",
                        HttpStatus.OK.value(),
                        responseDTO
                )
        );
    }

    @GetMapping("/sign-up/otp/resend")
    public ResponseEntity<ApiResponseDto<String>> resendOtpForAccountCreation(
            @RequestParam String email
    ){
        authService.sendAccountCreationOtp(email);
        return ResponseEntity.ok(
                new ApiResponseDto<>(
                        "OTP has been send to you email : "+email,
                        HttpStatus.OK.value(),
                        null
                )
        );
    }

    @GetMapping("/password/otp/send")
    public ResponseEntity<ApiResponseDto<String>> sendForgotPasswordOtp(
            @RequestParam String email
    ){
        String message = authService.sendForgotPasswordOtp(email);
        return ResponseEntity.ok(
                new ApiResponseDto<>(
                        "OTP has been send to you email : "+email,
                        HttpStatus.OK.value(),
                        message
                )
        );
    }

    @GetMapping("/password/otp/verify")
    public ResponseEntity<ApiResponseDto<String>> otpVerificationForForgotPassword(
            @RequestParam String email,
            @RequestParam String verificationCode
    ){
        String message =
                authService.otpVerificationForPassword(email,verificationCode);
        return ResponseEntity.ok(
                new ApiResponseDto<>(
                        "Email has been verified. Continue to add new password",
                        HttpStatus.OK.value(),
                        message
                )
        );
    }

    @GetMapping("/password/update")
    public ResponseEntity<ApiResponseDto<String>> updatePassword(
            @RequestParam String email,
            @RequestParam String newPassword
    ){
        String message =
                authService.passwordUpdate(email,newPassword);
        return ResponseEntity.ok(
                new ApiResponseDto<>(
                        "Password has been updated",
                        HttpStatus.OK.value(),
                        message
                )
        );
    }

    @GetMapping("/log-out")
    public ResponseEntity<ApiResponseDto<String>> logOut(
            HttpServletResponse response
    ){
        String message = authService.logOut();
        Cookie cookie = cookieService.deleteRefreshTokenCookie();

        response.addCookie(cookie);


        return ResponseEntity.ok(
                new ApiResponseDto<>(
                        "Log out successfully",
                        200,
                        message
                )
        );
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<ApiResponseDto<AuthResponseDTO>> refreshToken(
            @CookieValue(
                    name = "refreshToken",
                    required = false
            ) String refreshToken
    ){
        if(refreshToken == null){
            ApiResponseDto<AuthResponseDTO> api =
                    new ApiResponseDto<>(
                            "Refresh token missing",
                            HttpStatus.UNAUTHORIZED.value(),
                            null
                    );

            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(api);
        }
        AuthResponseDTO responseDTO =
                authService.refreshAccessToken(refreshToken);

        return ResponseEntity.ok(
          new ApiResponseDto<>(
                  "Access token refreshed successfully",
                  200,
                  responseDTO
          )
        );

    }
}
