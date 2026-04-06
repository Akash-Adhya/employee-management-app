package com.ems.repositories;

import com.ems.entities.Employee;
import com.ems.enums.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {
    boolean existsByIdAndUserRole(Long id, Role role);
}
