package com.ems.mapper;

import com.ems.dto.responsDto.UserResponseDTO;
import com.ems.entities.Employee;
import com.ems.entities.Manager;
import com.ems.entities.User;
import com.ems.enums.AccountStatus;

public class UserMapper {
    public static UserResponseDTO toUserResponseDto(
            User user, Manager manager, Employee employee
    ){
        UserResponseDTO dto = new UserResponseDTO();
        dto.setUserId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setContactNo(user.getContactNo());
        dto.setEmployeeId(user.getEmployeeId());

        boolean activeStatus =
                user.getAccountStatus() == AccountStatus.ACTIVE
                        || user.getAccountStatus() == AccountStatus.REQUESTED;

        dto.setActiveStatus(activeStatus); //boolean
        dto.setDob(user.getDob());

        if(manager != null){
            dto.setRole("Manager");
            dto.setManagerDesignation(manager.getManagerDesignation());
            dto.setManagerYearsOfExperience(manager.getManagerYearsOfExperience());
            dto.setDepartment(manager.getDepartment());
            dto.setOfficeLocation(manager.getOfficeLocation());
        }else if(employee != null){
            dto.setRole("Employee");
            dto.setEmployeeDesignation(employee.getEmployeeDesignation());
            dto.setEmployeeYearsOfExperience(employee.getEmployeeYearsOfExperience());
            dto.setSkills(employee.getSkills());
            dto.setJoiningDate(employee.getJoiningDate());
            dto.setOfficeLocation(employee.getOfficeLocation());
        }


        dto.setStreet(user.getAddress().getStreet());
        dto.setCity(user.getAddress().getCity());
        dto.setCountry(user.getAddress().getCountry());
        dto.setState(user.getAddress().getState());
        dto.setPincode(user.getAddress().getPinCode());

        dto.setImageUrl(user.getImageUrl());
        return dto;
    }
}
