package com.example.DevHw17.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "username")
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "role")
    private String role;
    @Column(name = "enabled")
    private boolean enabled;

}
