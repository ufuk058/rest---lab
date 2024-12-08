package com.client_lab.dto;

import com.client_lab.enums.AddressType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressDTO {
    private Long id;

    private String addressNo;

    private String street;
    private String country;
    private String state;
    private String city;
    private String postalCode;
    private String flag;

    private AddressType addressType;

    private Integer currentTemperature;
}
