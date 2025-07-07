package com.smartjob.dtos;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {

    @NotBlank
    @Column(length = 50, nullable = false, unique = true)
    private String username;

    @NotBlank
    @Column(length = 50, nullable = false)
    private String email;

    @NotBlank
    @Column(length = 60, nullable = false)
    private String password;

}
