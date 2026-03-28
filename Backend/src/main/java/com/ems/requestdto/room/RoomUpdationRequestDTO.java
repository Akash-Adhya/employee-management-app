package com.ems.requestdto.room;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RoomUpdationRequestDTO {
    private String roomName;
    private String description;
    private List<Long> employeeIds;
}
