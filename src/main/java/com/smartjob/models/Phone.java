package com.smartjob.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String idPhone;

    @ManyToOne
    @JoinColumn(name="id_user", nullable = false, foreignKey = @ForeignKey(name="fk_user_phone"))
    private Users user;

    @Column(nullable = false)
    private Integer number;

    @Column(length = 2, nullable = false)
    private String citycode;

    @Column(length = 2, nullable = false)
    private String contrycode;

    @Column(nullable = false)
    private LocalDateTime created;

    @Column(nullable = false)
    private LocalDateTime modified;

    private boolean isactve;


}