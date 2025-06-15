package com.example.stats.model;

import lombok.Data;

@Data
public class StudentPerformance {
    private Integer studentId;
    private String studentName;
    private Integer courseCount;
    private Double averageGrade;
    private Double totalCredits;
    private Double gpa;
}
