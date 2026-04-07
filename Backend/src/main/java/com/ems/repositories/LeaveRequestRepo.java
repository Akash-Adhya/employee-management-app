package com.ems.repositories;

import com.ems.entities.LeaveRequest;
import com.ems.enums.LeaveStatus;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeaveRequestRepo extends JpaRepository<LeaveRequest, Long> {

    List<LeaveRequest> findByEmployeeId(Long employeeId);

    List<LeaveRequest> findByEmployeeIdAndLeaveStatus(Long employeeId, LeaveStatus leaveStatus);
}
