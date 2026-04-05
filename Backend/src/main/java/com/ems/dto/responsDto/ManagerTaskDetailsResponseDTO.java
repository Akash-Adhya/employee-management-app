package com.ems.dto.responsDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ManagerTaskDetailsResponseDTO {
    private String title;

    private String description;

    private LocalDateTime dueDate;

    private String roomName;

    private List<EmployeeTaskDetails> employees;


    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class EmployeeTaskDetails {

        private EmployeeBasicResponseDTO employee;

        private String taskStatus;

        private LocalDateTime updateTime;
    }
}
