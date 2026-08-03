package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tbl_users")
public class Users {
    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    @Column(length = 255, nullable = false, name = "first_name")
    private String firstName;

    @Column(length = 255, name = "middle_name")
    private String middleName;

    @Column(length = 255, nullable = false, name = "last_name")
    private String lastName;

    @Column(length = 255, nullable = false, unique = true, name = "email")
    private String email;

    @Column(length = 255, nullable = false, name = "course")
    private String course;

    @Column(nullable = false, name = "year")
    private Integer year;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
