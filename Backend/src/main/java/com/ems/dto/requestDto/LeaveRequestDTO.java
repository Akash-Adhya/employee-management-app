package com.ems.dto.requestDto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

import com.ems.enums.LeaveCategory;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LeaveRequestDTO {

    @NotBlank(message = "Title is required")
    @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters")
    private String title;


    @NotBlank(message = "Description is required")
    @Size(min = 5, max = 500, message = "Description must be between 5 and 500 characters")
    private String description;


    @NotNull(message = "Leave category is required")
    private LeaveCategory category;


    @NotNull(message = "Start date is required")
    @FutureOrPresent(message = "Start date must be today or future date")
    private LocalDate startDate;


    @NotNull(message = "End date is required")
    @FutureOrPresent(message = "End date must be today or future date")
    private LocalDate endDate;
}