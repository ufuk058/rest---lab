package com.client_lab.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ParentDTO {
    @Column(updatable = false)
    private Long id;

    private String firstName;
    private String lastName;
    private String profession;
    private String phoneNumber;

    private String email;
    private String username;
    @JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
    private String password;

    private LocalDate birthday;

    private String addressNo;
}
