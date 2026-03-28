package com.ems.requestdto.task;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTaskRequestDTO {
    @Size(min = 3, max = 100)
    private String title;

    private String description;

    @Future(message = "Due date must be in future")
    private LocalDateTime dueDate;
}
