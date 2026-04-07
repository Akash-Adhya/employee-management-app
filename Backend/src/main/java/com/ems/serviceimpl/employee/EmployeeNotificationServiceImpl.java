package com.ems.serviceimpl.employee;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ems.dto.responsDto.NotificationResponseDTO;
import com.ems.entities.Employee;
import com.ems.entities.Notification;
import com.ems.entities.User;
import com.ems.enums.Role;
import com.ems.exceptions.ResourceNotFound;
import com.ems.mapper.NotificationMapper;
import com.ems.repositories.EmployeeRepo;
import com.ems.repositories.NotificationRepo;
import com.ems.service.employee.EmployeeNotificationService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeNotificationServiceImpl implements EmployeeNotificationService {

    private final EmployeeRepo employeeRepo;
    private final NotificationRepo notificationRepo;

    @Override
    public List<NotificationResponseDTO> getNotifications(Long employeeId) {

        if (employeeId == null || employeeId <= 0) {
            throw new IllegalArgumentException("Invalid employee ID");
        }
        Employee employee = employeeRepo.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFound("Employee not found with this employeeId"));

        User user = employee.getUser();

        if (user == null) {
            throw new ResourceNotFound("User not linked with employee");
        }

        if (user.getRole() != Role.EMPLOYEE) {
            throw new RuntimeException("Access denied: User is not an employee");
        }

        List<Notification> notifications = notificationRepo.findByUser(user);

        return notifications.stream()
                .map(NotificationMapper::toNotificationResponseDto)
                .collect(Collectors.toList());
    }

}
