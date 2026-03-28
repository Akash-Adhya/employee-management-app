package com.ems.responsedto.task;

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
public class ManagerTaskResponseDTO {
    private Long taskId;

    private String title;
    private String description;
    private LocalDateTime dueDate;
    private Long roomId;
    private String roomName;

    private String managerName;
    private String managerEmail;

    private List<EmployeeTaskSummaryDTO> assignedEmployees;

}
