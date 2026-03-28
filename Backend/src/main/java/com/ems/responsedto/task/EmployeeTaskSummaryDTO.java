package com.ems.responsedto.task;

import com.ems.enums.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeTaskSummaryDTO {
    private Long employeeId;
    private String name;
    private String email;
    private String statusUpdationTime;
    private TaskStatus taskStatus;
    private String imageUrl;
}
