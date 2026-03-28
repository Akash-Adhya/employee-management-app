package com.ems.requestdto.user;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {

    private String street;

    private String city;

    private String state;

    private String pinCode;

    private String country;
}