package com.ndmitrenko.dinosystemsrestapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "first_name")
    @NotNull
    private String firstName;

    @Column(name = "second_name", unique = true)
    @NotNull
    private String secondName;

    @Column(name = "date_of_birth")
    @NotNull
    private Date dateOfBirth;

    @Column(name = "address")
    @NotNull
    private String address;
}

