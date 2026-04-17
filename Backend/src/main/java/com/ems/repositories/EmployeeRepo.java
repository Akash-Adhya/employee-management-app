package com.ems.repositories;

import com.ems.entities.Employee;
import com.ems.entities.Manager;
import com.ems.entities.User;
import com.ems.enums.Role;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {
    boolean existsByIdAndUserRole(Long id, Role role);
    Optional<Employee> findByUser(User user);
    Optional<Employee> findByEmployeeId(String employeeId);
}
