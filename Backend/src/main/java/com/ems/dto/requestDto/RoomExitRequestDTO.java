package com.ems.dto.requestDto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomExitRequestDTO {

    @NotBlank(message = "Reason is required")
    private String reason;
}