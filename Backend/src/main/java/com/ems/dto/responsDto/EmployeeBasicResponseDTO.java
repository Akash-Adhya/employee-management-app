package com.ems.dto.responsDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeBasicResponseDTO {
    private String name;

    private String email;

    private String employeeId;

    private String imageUrl;

    private String accountStatus;

    private LocalDate joiningDate;
}
