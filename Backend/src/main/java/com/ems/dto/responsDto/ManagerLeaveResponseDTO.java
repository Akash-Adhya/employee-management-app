package com.ems.dto.responsDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ManagerLeaveResponseDTO {
    private EmployeeBasicResponseDTO employee;

    private LeaveResponseDTO leave;
}
