package com.smartjob.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {

    @Column(length = 80, nullable = false)
    private String id;

    @JsonIgnore
    private String username;

    @JsonIgnore
    private String email;

    @JsonIgnore
    private String password;

    private LocalDateTime created;

    private LocalDateTime modified;

    private LocalDateTime last_login;

    private String token;

    private boolean isactve;

}
