package com.smartjob.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 80, nullable = false)
    private String idUser;

    @NotBlank
    @Column(length = 50, nullable = false, unique = true)
    private String username;

    @NotBlank
    @Column(length = 50, nullable = false)
    private String email;

    @NotBlank
    @Column(length = 60, nullable = false)
    private String password;

    @Column(nullable = false)
    private LocalDateTime created;

    @Column(nullable = false)
    private LocalDateTime modified;

    @Column(nullable = false)
    private LocalDateTime last_login;

    @Column(nullable = false)
    private boolean isactve;

}
