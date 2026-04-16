package com.ems.service.user;

import com.ems.dto.requestDto.SignUpRequestDTO;
import com.ems.dto.requestDto.UpdateUserRequestDTO;
import com.ems.dto.responsDto.NotificationResponseDTO;
import com.ems.dto.responsDto.UserResponseDTO;

import java.util.List;

public interface UserService {
    UserResponseDTO getLoggedInUser();
    UserResponseDTO getUserByEmployeeId(String empId);
    String updateUser(UpdateUserRequestDTO dto);
    String updateAvatarOfUser(String imageUrl);
    String removeAvatarOfUser();
    List<NotificationResponseDTO> getAllNotificationOfUser();

    //auth part
    UserResponseDTO createUser(SignUpRequestDTO dto);
}
