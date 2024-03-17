package com.resitechpro.showcaseservice.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String organizationName;
    @Column(unique = true)
    private String personalEmail;
    private String email;
    private String password;
    private String phone;

    @OneToOne
    private Image image;
}
