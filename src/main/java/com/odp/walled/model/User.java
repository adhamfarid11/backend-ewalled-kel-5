package com.odp.walled.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 255)
    private String email;

    @Column(nullable = false, length = 20)
    private String username;

    @Column(nullable = false, length = 70)
    private String fullname;

    @Column(nullable = false)
    private String password;

    @Column(name = "avatar_url", nullable = true)
    private String avatarUrl;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;
}