package com.ems.serviceimpl.user;

import com.ems.dto.requestDto.SignUpRequestDTO;
import com.ems.dto.requestDto.UpdateUserRequestDTO;
import com.ems.dto.responsDto.NotificationResponseDTO;
import com.ems.dto.responsDto.UserResponseDTO;
import com.ems.entities.*;
import com.ems.enums.Role;
import com.ems.exceptions.DuplicateEntry;
import com.ems.exceptions.ResourceNotFound;
import com.ems.mapper.NotificationMapper;
import com.ems.mapper.UserMapper;
import com.ems.repositories.EmployeeRepo;
import com.ems.repositories.ManagerRepo;
import com.ems.repositories.NotificationRepo;
import com.ems.repositories.UserRepo;
import com.ems.service.user.UserService;
import com.ems.utils.SecurityUtil;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    SecurityUtil securityUtil;


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
        User user = securityUtil.getCurrentUser();
        Employee employee = null;
        Manager manager = null;
        if(user.getRole() == Role.EMPLOYEE){
            employee = securityUtil.getEmployee(user);
        }else{
            manager = securityUtil.getManager(user);
        }
        return UserMapper.toUserResponseDto(user,manager,employee);
    }

    @Override
    public UserResponseDTO getUserByEmployeeId(String empId) {
        User user = securityUtil.getCurrentUser();
        securityUtil.validateManager(user);

        Employee employee = employeeRepo.findByEmployeeId(empId)
                .orElseThrow(()->new ResourceNotFound("User with this ID does not exist"));


        return UserMapper.toUserResponseDto(user,null,employee);
    }

    @Override
    public String updateUser(UpdateUserRequestDTO dto) {
        User user = securityUtil.getCurrentUser();

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
            employee = securityUtil.getEmployee(user);
        }else if (user.getRole() == Role.MANAGER){
            manager = securityUtil.getManager(user);
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
    public String updateAvatarOfUser(String imageUrl) {
        User user = securityUtil.getCurrentUser();
        user.setImageUrl(imageUrl);
        userRepo.save(user);
        return "Avatar has been updated for employee ID : "+user.getEmployeeId();
    }

    @Override
    public String removeAvatarOfUser() {
        User user = securityUtil.getCurrentUser();
        user.setImageUrl(null);
        userRepo.save(user);
        return "Avatar has been removed for employee ID : "+user.getEmployeeId();
    }

    @Override
    public List<NotificationResponseDTO> getAllNotificationOfUser() {
        User user = securityUtil.getCurrentUser();

        List<Notification> notificationList =
                notificationRepo.findByUser(user);

        List<NotificationResponseDTO> dtoList = new ArrayList<>();
        notificationList.forEach((notification)->{
            dtoList.add(NotificationMapper.toNotificationResponseDto(notification));
        });
        return dtoList;
    }

    @Override
    public UserResponseDTO createUser(SignUpRequestDTO dto) {

        User existingUser = userRepo.findByEmail(dto.getEmail())
                .orElse(null);
        if(existingUser != null && existingUser.getAuth().isEmailVerified()==false){
            
        }

        if(userRepo.existsByEmail(dto.getEmail()))
            throw new DuplicateEntry("Email already exists");
        if(userRepo.existsByEmployeeId(dto.getEmployeeId()))
            throw new DuplicateEntry("User with this employee ID already exists");
        if(userRepo.existsByContactNo(dto.getContactNo()))
            throw new DuplicateEntry("User with this contact no. already exists");


        User user = new User();

        // mandatory fields
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setContactNo(dto.getContactNo());
        user.setPassword(dto.getPassword());
        user.setEmployeeId(dto.getEmployeeId());
        user.setRole(Role.valueOf(dto.getRole().toUpperCase()));

        // optional fields
        user.setDob(dto.getDob());
        user.setImageUrl(dto.getImageUrl());


        // Address (Embedded)
        Address address = new Address();
        address.setStreet(dto.getStreet());
        address.setCity(dto.getCity());
        address.setState(dto.getState());
        address.setCountry(dto.getCountry());
        address.setPinCode(dto.getPincode());

        user.setAddress(address);


        // save user first
        User savedUser = userRepo.save(user);

        Employee employee = null;
        Manager manager = null;

        // create role based entity
        if(savedUser.getRole() == Role.EMPLOYEE){

            employee = new Employee();

            employee.setUser(savedUser);
            employee.setEmployeeDesignation(dto.getEmployeeDesignation());
            employee.setEmployeeYearsOfExperience(dto.getEmployeeYearsOfExperience());
            employee.setJoiningDate(dto.getJoiningDate());
            employee.setSkills(dto.getSkills());
            employee.setOfficeLocation(dto.getOfficeLocation());

            employeeRepo.save(employee);

        }
        else if(savedUser.getRole() == Role.MANAGER){

            manager = new Manager();

            manager.setUser(savedUser);
            manager.setDepartment(dto.getDepartment());
            manager.setManagerDesignation(dto.getManagerDesignation());
            manager.setManagerYearsOfExperience(dto.getManagerYearsOfExperience());
            manager.setOfficeLocation(dto.getOfficeLocation());

            managerRepo.save(manager);
        }


        return UserMapper.toUserResponseDto(savedUser,manager,employee);
    }


    private static <T> boolean isNullOrEmpty(T data){
        if(data == null){
            return true;
        }
        if(data instanceof String){
            return ((String) data).trim().isEmpty();
        }
        return false;
    }
}
