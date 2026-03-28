package com.ems.responsedto.task;

import com.ems.enums.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeTaskResponseDTO {
    private Long employeeId;
    private Long taskId;
    private String title;
    private String description;
    private TaskStatus status;
    private LocalDateTime dueDate;
    private String roomName;
    private String managerName;
}
