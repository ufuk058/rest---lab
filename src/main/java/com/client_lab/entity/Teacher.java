package com.client_lab.entity;

import com.client_lab.enums.EducationLevel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="teachers")
public class Teacher extends BaseEntity {
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
    @Enumerated(EnumType.STRING)
    private EducationLevel educationLevel;
    private String addressNo;



}
