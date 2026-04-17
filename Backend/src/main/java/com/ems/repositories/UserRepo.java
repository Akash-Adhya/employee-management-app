package com.ems.repositories;

import com.ems.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long>{
    Optional<User> findByEmployeeId(String employeeId);
    Optional<User> findByEmail(String email);
    boolean existsByEmployeeId(String employeeId);
    boolean existsByEmail(String email);
    boolean existsByContactNo(String contactNo);
}
