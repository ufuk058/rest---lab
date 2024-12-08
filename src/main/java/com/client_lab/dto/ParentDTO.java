package com.client_lab.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParentDTO {
    private Long id;

    private String firstName;
    private String lastName;
    private String profession;
    private String phoneNumber;
    private String email;
    private String username;

    private String password;

    private LocalDate birthday;

    private String addressNo;
}
