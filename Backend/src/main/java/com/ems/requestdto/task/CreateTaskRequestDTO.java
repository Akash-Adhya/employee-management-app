package com.ems.requestdto.task;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateTaskRequestDTO {
    @NotBlank(message = "Title is required")
    private String title;
    private String description;

    @NotNull(message = "Due date is required")
    private LocalDateTime dueDate;

    @NotNull(message = "Room id is required")
    private Long roomId;

    @NotEmpty(message = "At least one employee must be assigned")
    private List<Long> employeeIds;
}
