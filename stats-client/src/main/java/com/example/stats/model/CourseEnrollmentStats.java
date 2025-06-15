package com.example.stats.model;

import lombok.Data;

@Data
public class CourseEnrollmentStats {
    private Integer courseId;
    private String courseName;
    private Integer studentCount;
    private Double averageGrade;
    private Double maxGrade;
    private Double minGrade;
    private Double passRate;
}
