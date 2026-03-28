package com.ems.requestdto.room;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomCreationRequestDTO {

    @NotBlank(message = "Room Name is required")
    private String roomName;

    private String description;
}
