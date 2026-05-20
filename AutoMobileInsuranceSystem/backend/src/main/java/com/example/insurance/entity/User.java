package com.example.insurance.entity;

import com.example.insurance.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users")

public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="Name required")
    private String name;

    @Email
    @Column(unique=true)
    private String email;

    private String password;

    private String dob;

    private Integer age;

    private String aadhaar;

    private String pan;

    private String address;

    @Enumerated(EnumType.STRING)
    private Role role;

}