package com.example.demo.dto;

import lombok.Data;

@Data
public class UserDto {
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String course;
    private Integer year;
}
