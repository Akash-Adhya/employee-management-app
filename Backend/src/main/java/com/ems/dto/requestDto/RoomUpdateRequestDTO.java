package com.ems.dto.requestDto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomUpdateRequestDTO {
    @Size(min = 2, max = 50, message = "Room name must be between 2 and 50 characters")
    private String roomName;

    @Size(min = 5, max = 300, message = "Description must be between 5 and 300 characters")
    private String description;
}
