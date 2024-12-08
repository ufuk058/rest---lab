package com.client_lab.entity;

import com.client_lab.enums.AddressType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="addresses")
public class Address extends BaseEntity {

    @Column(updatable = false,unique = true)
    private String addressNo;
    private String street;
    private String country;
    private String state;
    private String city;
    private String postCode;
    @Enumerated(EnumType.STRING)
    private AddressType addressType;
}
