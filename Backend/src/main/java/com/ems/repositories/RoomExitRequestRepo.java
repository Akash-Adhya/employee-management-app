package com.ems.repositories;

import com.ems.entities.Employee;
import com.ems.entities.RoomExitRequest;
import com.ems.enums.RoomExitRequestStatus;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomExitRequestRepo extends JpaRepository<RoomExitRequest, Long> {
    boolean existsByEmployeeAndStatus(Employee employee,
            RoomExitRequestStatus status);
}
