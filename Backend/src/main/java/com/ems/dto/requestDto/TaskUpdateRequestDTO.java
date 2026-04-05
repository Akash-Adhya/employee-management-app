package com.ems.dto.requestDto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskUpdateRequestDTO {

    @Size(min = 3, max = 150, message = "Title must be between 3 and 150 characters")
    private String title;

    @Size(min = 5, max = 1000, message = "Description must be between 5 and 1000 characters")
    private String description;

    @Future(message = "Due date must be in the future")
    private LocalDateTime dueDate;

    
}
