package com.ems.responsedto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressResponseDTO {
    private  String street;
    private String city;
    private String state;
    private String pinCode;
    private String country;
}
