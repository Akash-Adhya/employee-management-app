package com.ems.mapper;

import com.ems.dto.responsDto.AuthResponseDTO;
import com.ems.entities.User;

public class AuthMapper {
    
    public static AuthResponseDTO toAuthResponseDTO(User user, String accessToken,String refreshToken){

        AuthResponseDTO responseDTO = new AuthResponseDTO();

        responseDTO.setAccessToken(accessToken);
        responseDTO.setRefreshToken(refreshToken);
        responseDTO.setEmail(user.getEmail());
        responseDTO.setEmployeeId(user.getEmployeeId());
        responseDTO.setRole(user.getRole().toString());
        responseDTO.setUserId(user.getId());
        return responseDTO;
    }
}
