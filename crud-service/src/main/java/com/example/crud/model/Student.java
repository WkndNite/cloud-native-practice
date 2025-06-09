package com.example.crud.model;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Student {
    private Integer studentId;
    private String name;
    private String gender;
    private LocalDate birthDate;
    private String major;
    private String gradeLevel;
    private String email;
    private String phoneNumber;
    private String address;
    private String nationality;
    private Integer enrollmentYear;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
