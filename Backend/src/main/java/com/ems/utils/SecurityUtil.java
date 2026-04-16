package com.ems.utils;

import com.ems.entities.Employee;
import com.ems.entities.Manager;
import com.ems.entities.User;
import com.ems.enums.Role;
import com.ems.exceptions.AuthorizationException;
import com.ems.exceptions.ResourceNotFound;
import com.ems.repositories.EmployeeRepo;
import com.ems.repositories.ManagerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SecurityUtil {

    private final ManagerRepo managerRepo;
    private final EmployeeRepo employeeRepo;


    public User getCurrentUser(){
        Authentication authentication =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication();

        if(authentication == null){
            throw new AuthorizationException("User not authenticated");
        }
        return (User) authentication.getPrincipal();
    }


    public void validateManager(User user){
        if(user.getRole() != Role.MANAGER){
            throw new AuthorizationException(
                    "Access denied. Manager role required"
            );
        }
    }


    public Manager getManager(User user){
        return managerRepo.findByUser(user)
                .orElseThrow(() ->
                        new ResourceNotFound(
                                "Manager profile not found"
                        )
                );
    }


    public void validateEmployee(User user){
        if(user.getRole() != Role.EMPLOYEE){
            throw new AuthorizationException(
                    "Access denied. Employee role required"
            );
        }
    }


    public Employee getEmployee(User user){
        return employeeRepo.findByUser(user)
                .orElseThrow(() ->
                        new ResourceNotFound(
                                "Employee profile not found"
                        )
                );
    }
}