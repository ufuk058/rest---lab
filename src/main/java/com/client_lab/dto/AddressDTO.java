package com.client_lab.dto;

import com.client_lab.enums.AddressType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressDTO {
    private Long id;

    private String addressNo;

    private String street;
    private String country;
    private String state;
    private String city;
    private String postCode;
    private String flag;

    private AddressType addressType;

    private Integer currentTemperature;
}
