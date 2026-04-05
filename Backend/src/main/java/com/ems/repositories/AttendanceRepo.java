package com.ems.repositories;

import com.ems.entities.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepo extends JpaRepository<Attendance,Long>{
}
