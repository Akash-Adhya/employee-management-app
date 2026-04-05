package com.ems.mapper;

import com.ems.dto.responsDto.AuthResponseDTO;
import com.ems.entities.User;

public class AuthMapper {
    
    public static AuthResponseDTO toAuthResponseDTO(User user, String token){
        AuthResponseDTO responseDTO = new AuthResponseDTO();
        responseDTO.setToken(token);
        responseDTO.setEmail(user.getEmail());
        responseDTO.setEmployeeId(user.getEmployeeId());
        responseDTO.setRole(user.getRole().toString());
        responseDTO.setUserId(user.getId());
        return responseDTO;
    }
}
