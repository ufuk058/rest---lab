package com.client_lab.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="parents")
public class Parent extends BaseEntity{

    private String firstName;
    private String lastName;
    private String profession;
    private String phoneNumber;

    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String username;
    private String password;

    @Column(columnDefinition = "DATE")
    private LocalDate birthday;

    private String addressNo;
}
