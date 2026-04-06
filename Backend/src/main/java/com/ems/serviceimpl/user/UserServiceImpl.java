package com.ems.serviceimpl.user;

import com.ems.dto.requestDto.UpdateUserRequestDTO;
import com.ems.dto.responsDto.NotificationResponseDTO;
import com.ems.dto.responsDto.UserResponseDTO;
import com.ems.entities.Employee;
import com.ems.entities.Manager;
import com.ems.entities.Notification;
import com.ems.entities.User;
import com.ems.enums.Role;
import com.ems.exceptions.ResourceNotFound;
import com.ems.mapper.NotificationMapper;
import com.ems.mapper.UserMapper;
import com.ems.repositories.EmployeeRepo;
import com.ems.repositories.ManagerRepo;
import com.ems.repositories.NotificationRepo;
import com.ems.repositories.UserRepo;
import com.ems.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;
    @Autowired
    EmployeeRepo employeeRepo;
    @Autowired
    ManagerRepo managerRepo;
    @Autowired
    NotificationRepo notificationRepo;

    @Override
    public UserResponseDTO getLoggedInUser() {
        return null;
    }

    @Override
    public UserResponseDTO getUserByEmployeeId(String empId) {
        User user = userRepo.findByEmployeeId(empId)
                .orElseThrow(()->new ResourceNotFound("User with this Employee Id does not exist"));
        Long userId = user.getId();
        Employee employee = null;
        Manager manager = null;
        if(user.getRole() == Role.EMPLOYEE){
            employee = employeeRepo.findById(userId)
                    .orElseThrow(()->new ResourceNotFound("User with this ID does not exist"));
        }else if (user.getRole() == Role.MANAGER){
            manager = managerRepo.findById(userId)
                    .orElseThrow(()->new ResourceNotFound("User with this ID does not exist"));
        }

        return UserMapper.toUserResponseDto(user,manager,employee);
    }

    @Override
    public String updateUserByEmployeeId(UpdateUserRequestDTO dto, String empId) {
        User user = userRepo.findByEmployeeId(empId)
                .orElseThrow(()->new ResourceNotFound("User with this employee ID not found"));

        if(!isNullOrEmpty(dto.getName())){
            user.setName(dto.getName());
        }
        if(!isNullOrEmpty(dto.getDob())){
            user.setDob(dto.getDob());
        }
        if(!isNullOrEmpty(dto.getStreet())){
           user.getAddress().setStreet(dto.getStreet());
        }
        if(!isNullOrEmpty(dto.getState())){
            user.getAddress().setState(dto.getState());
        }
        if(!isNullOrEmpty(dto.getCity())){
            user.getAddress().setCity(dto.getCity());
        }
        if(!isNullOrEmpty(dto.getCountry())){
            user.getAddress().setCountry(dto.getCountry());
        }
        if(!isNullOrEmpty(dto.getPincode())){
            user.getAddress().setPinCode(dto.getPincode());
        }
        if(!isNullOrEmpty(dto.getImageUrl())){
            user.setImageUrl(dto.getImageUrl());
        }

        Employee employee = null;
        Manager manager = null;
        if(user.getRole() == Role.EMPLOYEE){
            employee = employeeRepo.findById(user.getId())
                    .orElseThrow(()->new ResourceNotFound("User with this ID does not exist"));
        }else if (user.getRole() == Role.MANAGER){
            manager = managerRepo.findById(user.getId())
                    .orElseThrow(()->new ResourceNotFound("User with this ID does not exist"));
        }
        if(employee != null){
            if(!isNullOrEmpty(dto.getEmployeeDesignation())){
                employee.setEmployeeDesignation(dto.getEmployeeDesignation());
            }
            if(!isNullOrEmpty(dto.getEmployeeYearsOfExperience())){
                employee.setEmployeeYearsOfExperience(dto.getEmployeeYearsOfExperience());
            }
            if(!isNullOrEmpty(dto.getJoiningDate())){
                employee.setJoiningDate(dto.getJoiningDate());
            }
            if(!isNullOrEmpty(dto.getSkills())){
                employee.setSkills(dto.getSkills());
            }
            if(!isNullOrEmpty(dto.getOfficeLocation())){
                employee.setOfficeLocation(dto.getOfficeLocation());
            }
            employeeRepo.save(employee);
        }else if (manager != null){
            if(!isNullOrEmpty(dto.getManagerDesignation())){
                manager.setManagerDesignation(dto.getManagerDesignation());
            }
            if(!isNullOrEmpty(dto.getDepartment())){
                manager.setDepartment(dto.getDepartment());
            }
            if(!isNullOrEmpty(dto.getManagerYearsOfExperience())){
                manager.setManagerYearsOfExperience(dto.getManagerYearsOfExperience());
            }
            if(!isNullOrEmpty(dto.getOfficeLocation())){
                manager.setOfficeLocation(dto.getOfficeLocation());
            }
            managerRepo.save(manager);
        }
        userRepo.save(user);

        return "User with Email : "+user.getEmail()+" and EmpId : "+user.getEmployeeId()+" Updated Successfully";
    }

    @Override
    public String updateAvatarByEmployeeId(String empId, String imageUrl) {
        User user = userRepo.findByEmployeeId(empId)
                .orElseThrow(()->new ResourceNotFound("User with this employee ID not found"));
        user.setImageUrl(imageUrl);
        userRepo.save(user);
        return "Avatar has been updated for employee ID : "+user.getEmployeeId();
    }

    @Override
    public String removeAvatarByEmployeeId(String empId) {
        User user = userRepo.findByEmployeeId(empId)
                .orElseThrow(()->new ResourceNotFound("User with this employee ID not found"));
        user.setImageUrl(null);
        userRepo.save(user);
        return "Avatar has been removed for employee ID : "+user.getEmployeeId();
    }

    @Override
    public List<NotificationResponseDTO> getAllNotificationOfUser(String employeeId) {
        User user = userRepo.findByEmployeeId(employeeId)
                .orElseThrow(()->new ResourceNotFound("User with this employee ID not found"));

        List<Notification> notificationList =
                notificationRepo.findByUser(user);

        List<NotificationResponseDTO> dtoList = new ArrayList<>();
        notificationList.forEach((notification)->{
            dtoList.add(NotificationMapper.toNotificationResponseDto(notification));
        });
        return dtoList;
    }




    public static <T> boolean isNullOrEmpty(T data){
        if(data == null){
            return true;
        }
        if(data instanceof String){
            return ((String) data).trim().isEmpty();
        }
        return false;
    }
}
