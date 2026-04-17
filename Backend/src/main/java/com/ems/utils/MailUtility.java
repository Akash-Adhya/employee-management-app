package com.ems.utils;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailUtility {

    private final JavaMailSender mailSender;

    public void sendMailForCreateAccount(String email, String otp) {
        String subject = "Welcome to EMS 🚀 | Verify Your Account";
        String content = generateEmailTemplate(
                "Welcome to the Team!",
                "We're excited to have you on board. Use the verification code below to get started with your Employee Management System account.",
                otp,
                "Verify Account",
                "If you didn't create an account, you can safely ignore this email."
        );

        sendHtmlEmail(email, subject, content);
    }

    public void sendMailForForgetPassword(String email, String otp) {
        String subject = "Reset Your Password | EMS 🔐";
        String content = generateEmailTemplate(
                "Password Reset Request",
                "We received a request to reset your password. Please use the following One-Time Password (OTP) to proceed. This code is valid for a limited time.",
                otp,
                "Reset Password",
                "If you didn't request a password reset, please secure your account immediately."
        );

        sendHtmlEmail(email, subject, content);
    }

    private void sendHtmlEmail(String to, String subject, String htmlContent) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(htmlContent, true); // true indicates HTML

            mailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException("Failed to send email to: " + to, e);
        }
    }

    private String generateEmailTemplate(String title, String message, String otp, String actionText, String footerNote) {
        return "<div style=\"font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; background-color: #f9fafb; padding: 40px 0; margin: 0;\">" +
                "  <div style=\"max-width: 500px; margin: 0 auto; background-color: #ffffff; border-radius: 12px; overflow: hidden; box-shadow: 0 4px 15px rgba(0,0,0,0.05); border: 1px solid #eef2f6;\">" +
                "    <div style=\"background-color: #3B1E54; padding: 30px; text-align: center;\">" +
                "      <h1 style=\"color: #ffffff; margin: 0; font-size: 24px; letter-spacing: 1px;\">EMS</h1>" +
                "    </div>" +
                "    <div style=\"padding: 40px 30px; text-align: center;\">" +
                "      <h2 style=\"color: #1f2937; margin-bottom: 20px; font-size: 22px;\">" + title + "</h2>" +
                "      <p style=\"color: #4b5563; line-height: 1.6; font-size: 16px; margin-bottom: 30px;\">" + message + "</p>" +
                "      " +
                "      <div style=\"background-color: #f3f4f6; border-radius: 8px; padding: 20px; margin-bottom: 30px;\">" +
                "        <span style=\"display: block; color: #6b7280; font-size: 12px; text-transform: uppercase; margin-bottom: 8px; font-weight: bold;\">Your Verification Code</span>" +
                "        <span style=\"font-family: 'Courier New', Courier, monospace; font-size: 32px; font-weight: bold; color: #9B7EBD; letter-spacing: 8px;\">" + otp + "</span>" +
                "      </div>" +
                "      " +
                "      <p style=\"color: #9ca3af; font-size: 14px; margin-top: 20px;\">" + footerNote + "</p>" +
                "    </div>" +
                "    <div style=\"background-color: #f9fafb; padding: 20px; text-align: center; border-top: 1px solid #eef2f6;\">" +
                "      <p style=\"color: #9ca3af; font-size: 12px; margin: 0;\">&copy; 2026 EMS Inc. All rights reserved.</p>" +
                "    </div>" +
                "  </div>" +
                "</div>";
    }
}