package com.ems.responsedto.room;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseRoomDTO {

    private Long id;
    private String name;
    private String email;
    private String employeeId;
    private String imageUrl;
}
