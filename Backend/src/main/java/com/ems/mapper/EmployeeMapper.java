package com.ems.mapper;

import com.ems.dto.responsDto.EmployeeBasicResponseDTO;
import com.ems.entities.Employee;
import com.ems.entities.User;

public class EmployeeMapper {
    public static EmployeeBasicResponseDTO toEmployeeBasicResponseDTO(Employee employee){
        EmployeeBasicResponseDTO dto = new EmployeeBasicResponseDTO();

        User user = employee.getUser();
        dto.setEmployeeId(user.getEmployeeId());
        dto.setName(user.getName());
        dto.setImageUrl(user.getImageUrl());
        dto.setJoiningDate(employee.getJoiningDate());
        dto.setEmail(user.getEmail());
        dto.setAccountStatus(user.getAccountStatus().toString());
        return dto;
    }
}
