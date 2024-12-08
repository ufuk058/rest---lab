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
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "students")
public class Student extends BaseEntity {

    private String firstName;
    private String lastName;
    private String phoneNumber;

    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String username;
    private String password;
    @Column(columnDefinition = "DATE")
    private LocalDate birthday;
    private String addressNo;
    private String parent;
    private String teacher;

}
