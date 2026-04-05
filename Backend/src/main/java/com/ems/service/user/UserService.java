package com.ems.service.user;

import com.ems.dto.requestDto.UpdateUserRequestDTO;
import com.ems.dto.responsDto.NotificationResponseDTO;
import com.ems.dto.responsDto.UserResponseDTO;

import java.util.List;

public interface UserService {
    UserResponseDTO getLoggedInUser();
    UserResponseDTO getUserByEmployeeId(String empId);
    String updateUserByEmployeeId(UpdateUserRequestDTO dto, String empId);
    String updateAvatarByEmployeeId(String empId,String imageUrl);
    String removeAvatarByEmployeeId(String empId);
    List<NotificationResponseDTO> getAllNotificationOfUser(String employeeId);
}
